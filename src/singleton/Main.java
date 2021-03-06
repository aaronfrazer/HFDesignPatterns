package singleton;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import singleton.chocolate.ChocolateBoiler;

import java.io.File;

public class Main extends Application
{
    private static String imageDir = "res/images/singleton/";

    private static Image chocolateBoilerEmptyImage = new Image(new File(imageDir + "ChocolateBoilerEmpty.png").toURI().toString());
    private static Image chocolateUnboiledFillAnimationImage = new Image(new File(imageDir + "ChocolateUnboiledFillAnimation.gif").toURI().toString());
    private static Image chocolateBoiledDrainAnimationImage = new Image(new File(imageDir + "ChocolateBoiledDrainAnimation.gif").toURI().toString());
    private static Image chocolateUnboiledDrainAnimationImage = new Image(new File(imageDir + "ChocolateUnboiledDrainAnimation.gif").toURI().toString());
    private static Image chocolateUnboiledFullImage = new Image(new File(imageDir + "ChocolateUnboiledFull.png").toURI().toString());
    private static Image chocolateBoiledFullImage = new Image(new File(imageDir + "ChocolateBoiledFull.png").toURI().toString());
    private static ImageView chocolateBoilerImageView = new ImageView(chocolateBoilerEmptyImage);

    private static Image boilImage = new Image(new File(imageDir + "spark.gif").toURI().toString());
    private static ImageView boilImageView = new ImageView(boilImage);

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();

    private Label labelComplete = new Label("Number of Chocolate Gallons: ");
    private static Text textComplete = new Text("0");

    private Button fillButton = new Button("Fill");
    private Button boilButton = new Button("Boil");
    private Button drainButton = new Button("Drain");

    private static final Timeline fillTimeline = new Timeline();
    private static final Timeline boilTimeline = new Timeline();
    private static final Timeline drainTimeline = new Timeline();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Choco-O-Holic Inc. : Chocolate Boiler");
        window.setOnCloseRequest(e -> closeProgram());

        gridPane.setHgap(40);
        gridPane.setVgap(20);

        // Boiler image on left
        boilImageView.setFitWidth(100);
        boilImageView.setFitHeight(100);
        chocolateBoilerImageView.setFitWidth(200);
        chocolateBoilerImageView.setFitHeight(200);

        // Images
        StackPane.setAlignment(boilImageView, Pos.TOP_CENTER);
        boilImageView.setVisible(false);
        stackPane.getChildren().addAll(chocolateBoilerImageView, boilImageView);
        gridPane.add(stackPane, 0, 0, 2, 3);

        // Buttons
        gridPane.add(fillButton, 2, 0, 1, 1);
        gridPane.add(boilButton, 2, 1, 1, 1);
        gridPane.add(drainButton, 2, 2, 1, 1);

        // Button events
        fillButton.setOnAction(e -> fillTimeline.play());
        boilButton.setOnAction(e -> boilTimeline.play());
        drainButton.setOnAction(e -> drainTimeline.play());

        // # of tanks complete
        gridPane.add(labelComplete, 0, 3, 1, 1);
        gridPane.add(textComplete, 1, 3, 1, 1);


        scene = new Scene(gridPane, 400, 400);
        window.setScene(scene);
        window.show();

        // initialize fillTimeline: wait 2 seconds to simulate chocolate tank filling up
        fillTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(0),
                        e -> playFillAnimation()
                ));
        fillTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                        e -> stopFillAnimation()
                ));

        // initialize boilTimeline: wait 2 seconds to simulate chocolate boiling
        boilTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(0),
                        e -> playBoilAnimation()
                ));
        boilTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                        e -> stopBoilAnimation()
                ));

        // initialize drainTimeline: wait 2 seconds to simulate chocolate tank draining
        drainTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(0),
                        e -> playDrainAnimation()
                ));
        drainTimeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                        e -> stopDrainAnimation()
                ));
    }

    private static void playFillAnimation()
    {
        if (ChocolateBoiler.getInstance().isEmpty())
            chocolateBoilerImageView.setImage(chocolateUnboiledFillAnimationImage);
        else
            System.out.println("Cannot fill: already filled");
    }

    private static void stopFillAnimation()
    {
        if (!ChocolateBoiler.getInstance().isBoiled())
            chocolateBoilerImageView.setImage(chocolateUnboiledFullImage);
        else
            chocolateBoilerImageView.setImage(chocolateBoiledFullImage);

        textComplete.setText(Integer.toString(ChocolateBoiler.getInstance().getNumChocolateBoiled()));

        if (!ChocolateBoiler.getInstance().isBoiled())
            ChocolateBoiler.getInstance().fill();
    }

    private static void playBoilAnimation()
    {
        if (!ChocolateBoiler.getInstance().isEmpty() && !ChocolateBoiler.getInstance().isBoiled()) // full and unboiled
        {
            boilImageView.setVisible(true); // spark
        } else
        {
            if (ChocolateBoiler.getInstance().isEmpty())
                System.out.println("Cannot boil: tank is empty");
            else
                System.out.println("Cannot boil: tank is already boiled");
        }
    }

    private static void stopBoilAnimation()
    {
        if (!ChocolateBoiler.getInstance().isEmpty() && !ChocolateBoiler.getInstance().isBoiled())
        {
            boilImageView.setVisible(false);
            chocolateBoilerImageView.setImage(chocolateBoiledFullImage);
        }

        ChocolateBoiler.getInstance().boil();
    }

    private static void playDrainAnimation()
    {
        if (!ChocolateBoiler.getInstance().isEmpty())
            if (ChocolateBoiler.getInstance().isBoiled())
                chocolateBoilerImageView.setImage(chocolateBoiledDrainAnimationImage);
            else
                chocolateBoilerImageView.setImage(chocolateUnboiledDrainAnimationImage);
        else
            System.out.println("Cannot drain: tank is empty");
    }

    private static void stopDrainAnimation()
    {
        if (!ChocolateBoiler.getInstance().isEmpty())
            chocolateBoilerImageView.setImage(chocolateBoilerEmptyImage);

        ChocolateBoiler.getInstance().drain();
        textComplete.setText(Integer.toString(ChocolateBoiler.getInstance().getNumChocolateBoiled()));
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        window.close();
    }
}