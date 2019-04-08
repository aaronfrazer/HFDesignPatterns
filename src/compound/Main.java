package compound;

import compound.adapter.GooseAdapter;
import compound.composite.Flock;
import compound.decorator.QuackCounter;
import compound.ducks.Goose;
import compound.factory.AbstractDuckFactory;
import compound.factory.CountingDuckFactory;
import compound.observer.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import compound.observer.Observer;

import java.io.File;

public class Main extends Application
{
    private static String imageDir = "res/images/compound/";
    private static String soundDir = "res/sounds/compound/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private static ImageView imageView = new ImageView(new Image(new File(imageDir + "MallardDuck.jpg").toURI().toString()));

    // Labels
    private Label labelRedHead = new Label("Red Head Duck");
    private Label labelDuckCall = new Label("Duck Call");
    private Label labelRubber = new Label("Rubber Duck");
    private Label labelGoose = new Label("Goose Duck");
    private Label labelMallard1 = new Label("Mallard Duck");

    // Buttons
    private Button buttonRedHeadQuack = new Button("Quack");
    private Button buttonDuckCallQuack = new Button("Quack");
    private Button buttonRubberQuack = new Button("Quack");
    private Button buttonGooseQuack = new Button("Quack");
    private Button buttonMallard1Quack = new Button("Quack");

    private CheckBox quackolgistCheckBox = new CheckBox("Quackologist Observing");

    private Label labelQuackCount = new Label("Quack Count: ");
    private Text textQuackCount = new Text("0");

    private AbstractDuckFactory duckFactory = new CountingDuckFactory();

    private Quackable redheadDuck = duckFactory.createRedheadDuck();
    private Quackable duckCall = duckFactory.createDuckCall();
    private Quackable rubberDuck = duckFactory.createRubberDuck();
    private Quackable gooseDuck = new GooseAdapter(new Goose());
    private static Flock flockOfDucks = new Flock();

    private Quackable mallardOne = duckFactory.createMallardDuck();
    private Quackable mallardTwo = duckFactory.createMallardDuck();
    private Quackable mallardThree = duckFactory.createMallardDuck();
    private Quackable mallardFour = duckFactory.createMallardDuck();
    private Flock flockOfMallards = new Flock();

    private Quackologist quackologist = new Quackologist();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Compound Pattern");
        window.setOnCloseRequest(e -> closeProgram());

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        flockOfMallards.add(mallardOne);
        flockOfMallards.add(mallardTwo);
        flockOfMallards.add(mallardThree);
        flockOfMallards.add(mallardFour);

        flockOfDucks.add(flockOfMallards);

        gridPane.setHgap(40);
        gridPane.setVgap(20);

        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        // Images
        gridPane.add(imageView, 1, 0, 4, 1);

        gridPane.add(labelRedHead, 0, 1, 1, 1);
        gridPane.add(labelDuckCall, 1, 1, 1, 1);
        gridPane.add(labelRubber, 2, 1, 1, 1);
        gridPane.add(labelGoose, 3, 1, 1, 1);
        gridPane.add(labelMallard1, 4, 1, 1, 1);

        buttonRedHeadQuack.setOnAction(e -> performQuack(redheadDuck));
        buttonDuckCallQuack.setOnAction(e -> performQuack(duckCall));
        buttonRubberQuack.setOnAction(e -> performQuack(rubberDuck));
        buttonGooseQuack.setOnAction(e -> performQuack(gooseDuck));
        buttonMallard1Quack.setOnAction(e -> performQuack(mallardOne));

        quackolgistCheckBox.selectedProperty().addListener((v, oldValue, newValue) -> manageObserver(newValue, quackologist));

        gridPane.add(buttonRedHeadQuack, 0, 2, 1, 1);
        gridPane.add(buttonDuckCallQuack, 1, 2, 1, 1);
        gridPane.add(buttonRubberQuack, 2, 2, 1, 1);
        gridPane.add(buttonGooseQuack, 3, 2, 1, 1);
        gridPane.add(buttonMallard1Quack, 4, 2, 1, 1);
        gridPane.add(quackolgistCheckBox, 0, 3, 4, 1);
        gridPane.add(labelQuackCount, 0, 4, 1, 1);
        gridPane.add(textQuackCount, 1, 4, 1, 1);

        scene = new Scene(gridPane, 1000, 550);
        window.setScene(scene);
        window.show();
    }

    private void performQuack(Quackable duck)
    {
        duck.quack();
        textQuackCount.setText("" + QuackCounter.getQuacks());
    }

    /**
     * Manages an observer by registering/removing them from observers.
     * @param register true if this observer should be registered, false if should be removed
     */
    private static void manageObserver(boolean register, Observer observer)
    {
        if (register)
            flockOfDucks.registerObserver(observer);
        else
            flockOfDucks.removeObserver(observer);
    }

    /**
     * Displays an image in a picture region.
     * @param image file path
     */
    public static void displayImage(String image)
    {
        File file = new File(imageDir + image);
        imageView.setImage(new Image(file.toURI().toString()));
    }

    /**
     * Plays a sound byte from a .wav file.
     * @param sound file path
     */
    public static void playSound(String sound)
    {
        Media hit = new Media(new File(soundDir + sound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}