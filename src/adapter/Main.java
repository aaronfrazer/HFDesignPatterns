package adapter;

import adapter.ducks.Duck;
import adapter.ducks.MallardDuck;
import adapter.ducks.TurkeyAdapter;
import adapter.ducks.WildTurkey;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application
{
    private static String imageDir = "res/images/adapter/";
    private static String soundDir = "res/sounds/adapter/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private static ImageView imageViewDuck = new ImageView(new Image(new File(imageDir + "MallardDuck.jpg").toURI().toString()));
//    private static ImageView imageViewDuckFlying = new ImageView(new Image(new File(imageDir + "MallardDuckFlying.png").toURI().toString()));
    private static ImageView imageViewTurkey = new ImageView(new Image(new File(imageDir + "Turkey.png").toURI().toString()));
//    private static ImageView imageViewTurkeyFlying = new ImageView(new Image(new File(imageDir + "TurkeyFlying.gif").toURI().toString()));
    private static ImageView imageViewTurkeyAdapter = new ImageView(new Image(new File(imageDir + "Turkey.png").toURI().toString()));

    private Label labelDuck = new Label("Duck");
    private Label labelTurkey = new Label("Turkey");
    private Label labelTurkeyAdapter = new Label("Turkey Adapter");

    private Button buttonDuckFly = new Button("Fly");
    private Button buttonDuckQuack = new Button("Quack");

    private Button buttonTurkeyFly = new Button("Fly");
    private Button buttonTurkeyQuack = new Button("Gobble");

    private Button buttonTurkeyAdapterFly = new Button("Fly");
    private Button buttonTurkeyAdapterQuack = new Button("Quack");

    private MallardDuck duck = new MallardDuck();
    private WildTurkey turkey = new WildTurkey();
    private Duck turkeyAdapter = new TurkeyAdapter(turkey);

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Adapter");
        window.setOnCloseRequest(e -> closeProgram());

        gridPane.setHgap(40);
        gridPane.setVgap(20);

        imageViewDuck.setFitHeight(200);
        imageViewDuck.setFitWidth(200);
        imageViewTurkey.setFitHeight(200);
        imageViewTurkey.setFitWidth(200);
        imageViewTurkeyAdapter.setFitHeight(200);
        imageViewTurkeyAdapter.setFitWidth(200);

        // Images
        gridPane.add(imageViewDuck, 0, 0, 1, 1);
        gridPane.add(imageViewTurkey, 1, 0, 1, 1);
        gridPane.add(imageViewTurkeyAdapter, 2, 0, 1, 1);

        // Labels
        gridPane.add(labelDuck, 0, 1, 1, 1);
        gridPane.add(labelTurkey, 1, 1, 1, 1);
        gridPane.add(labelTurkeyAdapter, 2, 1, 1, 1);

        // Buttons
        buttonDuckFly.setOnAction(e -> duck.fly());
        buttonDuckQuack.setOnAction(e -> duck.quack());
        buttonTurkeyFly.setOnAction(e -> turkey.fly());
        buttonTurkeyQuack.setOnAction(e -> turkey.gobble());
        buttonTurkeyAdapterFly.setOnAction(e -> turkeyAdapter.fly());
        buttonTurkeyAdapterQuack.setOnAction(e -> turkeyAdapter.quack());

        gridPane.add(buttonDuckFly, 0, 2, 1, 1);
        gridPane.add(buttonDuckQuack, 0, 3, 1, 1);

        gridPane.add(buttonTurkeyFly, 1, 2, 1, 1);
        gridPane.add(buttonTurkeyQuack, 1, 3, 1, 1);

        gridPane.add(buttonTurkeyAdapterFly, 2, 2, 1, 1);
        gridPane.add(buttonTurkeyAdapterQuack, 2, 3, 1, 1);

        scene = new Scene(gridPane, 1000, 550);
        window.setScene(scene);
        window.show();
    }

    /**
     * Displays an image in a picture region.
     *
     * @param image file path
     */
    public static void displayImage(String image)
    {
        File file = new File(imageDir + image);
        imageViewDuck.setImage(new Image(file.toURI().toString()));
    }

    /**
     * Plays a sound byte from a .wav file.
     *
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