package strategy;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import strategy.duck.*;
import strategy.flyBehaviors.FlyNoWay;
import strategy.flyBehaviors.FlyRocketPowered;
import strategy.flyBehaviors.FlyWithWings;
import strategy.quackBehaviors.FakeQuack;
import strategy.quackBehaviors.MuteQuack;
import strategy.quackBehaviors.Quack;
import strategy.quackBehaviors.Squeak;

public class Main extends Application
{
    public static String imageDir = "res/images/";
    public static String soundDir = "res/sounds/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();

    private static ImageView imageView = new ImageView(new Image(new File(imageDir + "MallardDuck.jpg").toURI().toString()));
    public static Image waterImage = new Image(new File(imageDir + "water.gif").toURI().toString());
    private static ImageView backgroundImageView = new ImageView(waterImage);

    private MallardDuck mallardDuck = new MallardDuck();
    private RedHeadDuck redHeadDuck = new RedHeadDuck();
    private RubberDuck rubberDuck = new RubberDuck();
    private DecoyDuck decoyDuck = new DecoyDuck();
    private ModelDuck modelDuck = new ModelDuck();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        window.setTitle("Main");
        window.setOnCloseRequest(e -> closeProgram());

        gridPane.setHgap(40);
        gridPane.setVgap(20);

        removeBackgroundImage();
        backgroundImageView.setFitHeight(200);
        backgroundImageView.setFitWidth(200);

        imageView.setFitHeight(200);
        imageView.setFitWidth(200);

        // Images
        StackPane.setAlignment(backgroundImageView, Pos.BOTTOM_CENTER);
        stackPane.getChildren().addAll(backgroundImageView, imageView);

        gridPane.add(stackPane, 1, 0, 4, 1);

        // Labels
        Label labelMallard = new Label("Mallard Duck");
        Label labelRedHead = new Label("Red Head Duck");
        Label labelRubber = new Label("Rubber Duck");
        Label labelDecoy = new Label("Decoy Duck");
        Label labelModel = new Label("Model Duck");

        gridPane.add(labelMallard, 0, 1, 1, 1);
        gridPane.add(labelRedHead, 1, 1, 1, 1);
        gridPane.add(labelRubber, 2, 1, 1, 1);
        gridPane.add(labelDecoy, 3, 1, 1, 1);
        gridPane.add(labelModel, 4, 1, 1, 1);

        // Dropdowns
        ChoiceBox<String> choiceBoxMallardFly = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxMallardQuack = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxRedHeadFly = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxRedHeadQuack = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxRubberFly = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxRubberQuack = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxDecoyFly = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxDecoyQuack = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxModelFly = new ChoiceBox<>();
        ChoiceBox<String> choiceBoxModelQuack = new ChoiceBox<>();

        choiceBoxMallardFly.getItems().addAll("FlyNoWay", "FlyRocketPowered", "FlyWithWings");
        choiceBoxMallardQuack.getItems().addAll("FakeQuack", "Quack", "MuteQuack", "Squeak");
        choiceBoxRedHeadFly.getItems().addAll("FlyNoWay", "FlyRocketPowered", "FlyWithWings");
        choiceBoxRedHeadQuack.getItems().addAll("FakeQuack", "Quack", "MuteQuack", "Squeak");
        choiceBoxRubberFly.getItems().addAll("FlyNoWay", "FlyRocketPowered", "FlyWithWings");
        choiceBoxRubberQuack.getItems().addAll("FakeQuack", "Quack", "MuteQuack", "Squeak");
        choiceBoxDecoyFly.getItems().addAll("FlyNoWay", "FlyRocketPowered", "FlyWithWings");
        choiceBoxDecoyQuack.getItems().addAll("FakeQuack", "Quack", "MuteQuack", "Squeak");
        choiceBoxModelFly.getItems().addAll("FlyNoWay", "FlyRocketPowered", "FlyWithWings");
        choiceBoxModelQuack.getItems().addAll("FakeQuack", "Quack", "MuteQuack", "Squeak");

        choiceBoxMallardFly.setValue("FlyWithWings");
        choiceBoxMallardQuack.setValue("Quack");
        choiceBoxRedHeadFly.setValue("FlyWithWings");
        choiceBoxRedHeadQuack.setValue("Quack");
        choiceBoxRubberFly.setValue("FlyNoWay");
        choiceBoxRubberQuack.setValue("Squeak");
        choiceBoxDecoyFly.setValue("FlyNoWay");
        choiceBoxDecoyQuack.setValue("MuteQuack");
        choiceBoxModelFly.setValue("FlyNoWay");
        choiceBoxModelQuack.setValue("Quack");

        choiceBoxMallardFly.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FlyNoWay")
                mallardDuck.setFlyBehavior(new FlyNoWay());
            if (newValue == "FlyRocketPowered")
                mallardDuck.setFlyBehavior(new FlyRocketPowered());
            if (newValue == "FlyWithWings")
                mallardDuck.setFlyBehavior(new FlyWithWings());
        });
        choiceBoxMallardQuack.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FakeQuack")
                mallardDuck.setQuackBehavior(new FakeQuack());
            if (newValue == "Quack")
                mallardDuck.setQuackBehavior(new Quack());
            if (newValue == "MuteQuack")
                mallardDuck.setQuackBehavior(new MuteQuack());
            if (newValue == "Squeak")
                mallardDuck.setQuackBehavior(new Squeak());
        });
        choiceBoxRedHeadFly.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FlyNoWay")
                redHeadDuck.setFlyBehavior(new FlyNoWay());
            if (newValue == "FlyRocketPowered")
                redHeadDuck.setFlyBehavior(new FlyRocketPowered());
            if (newValue == "FlyWithWings")
                redHeadDuck.setFlyBehavior(new FlyWithWings());
        });
        choiceBoxRedHeadQuack.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FakeQuack")
                redHeadDuck.setQuackBehavior(new FakeQuack());
            if (newValue == "Quack")
                redHeadDuck.setQuackBehavior(new Quack());
            if (newValue == "MuteQuack")
                redHeadDuck.setQuackBehavior(new MuteQuack());
            if (newValue == "Squeak")
                redHeadDuck.setQuackBehavior(new Squeak());
        });
        choiceBoxRubberFly.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FlyNoWay")
                rubberDuck.setFlyBehavior(new FlyNoWay());
            if (newValue == "FlyRocketPowered")
                rubberDuck.setFlyBehavior(new FlyRocketPowered());
            if (newValue == "FlyWithWings")
                rubberDuck.setFlyBehavior(new FlyWithWings());
        });
        choiceBoxRubberQuack.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FakeQuack")
                rubberDuck.setQuackBehavior(new FakeQuack());
            if (newValue == "Quack")
                rubberDuck.setQuackBehavior(new Quack());
            if (newValue == "MuteQuack")
                rubberDuck.setQuackBehavior(new MuteQuack());
            if (newValue == "Squeak")
                rubberDuck.setQuackBehavior(new Squeak());
        });
        choiceBoxDecoyFly.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FlyNoWay")
                decoyDuck.setFlyBehavior(new FlyNoWay());
            if (newValue == "FlyRocketPowered")
                decoyDuck.setFlyBehavior(new FlyRocketPowered());
            if (newValue == "FlyWithWings")
                decoyDuck.setFlyBehavior(new FlyWithWings());
        });
        choiceBoxDecoyQuack.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FakeQuack")
                decoyDuck.setQuackBehavior(new FakeQuack());
            if (newValue == "Quack")
                decoyDuck.setQuackBehavior(new Quack());
            if (newValue == "MuteQuack")
                decoyDuck.setQuackBehavior(new MuteQuack());
            if (newValue == "Squeak")
                decoyDuck.setQuackBehavior(new Squeak());
        });
        choiceBoxModelFly.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FlyNoWay")
                modelDuck.setFlyBehavior(new FlyNoWay());
            if (newValue == "FlyRocketPowered")
                modelDuck.setFlyBehavior(new FlyRocketPowered());
            if (newValue == "FlyWithWings")
                modelDuck.setFlyBehavior(new FlyWithWings());
        });
        choiceBoxModelQuack.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (newValue == "FakeQuack")
                modelDuck.setQuackBehavior(new FakeQuack());
            if (newValue == "Quack")
                modelDuck.setQuackBehavior(new Quack());
            if (newValue == "MuteQuack")
                modelDuck.setQuackBehavior(new MuteQuack());
            if (newValue == "Squeak")
                modelDuck.setQuackBehavior(new Squeak());
        });

        gridPane.add(choiceBoxMallardFly, 0, 2, 1, 1);
        gridPane.add(choiceBoxMallardQuack, 0, 3, 1, 1);
        gridPane.add(choiceBoxRedHeadFly, 1, 2, 1, 1);
        gridPane.add(choiceBoxRedHeadQuack, 1, 3, 1, 1);
        gridPane.add(choiceBoxRubberFly, 2, 2, 1, 1);
        gridPane.add(choiceBoxRubberQuack, 2, 3, 1, 1);
        gridPane.add(choiceBoxDecoyFly, 3, 2, 1, 1);
        gridPane.add(choiceBoxDecoyQuack, 3, 3, 1, 1);
        gridPane.add(choiceBoxModelFly, 4, 2, 1, 1);
        gridPane.add(choiceBoxModelQuack, 4, 3, 1, 1);

        // Buttons
        Button buttonMallardFly = new Button("Fly");
        Button buttonMallardQuack = new Button("Quack");
        Button buttonMallardDisplay = new Button("Display");
        Button buttonMallardSwim = new Button("Swim");

        Button buttonRedHeadFly = new Button("Fly");
        Button buttonRedHeadQuack = new Button("Quack");
        Button buttonRedHeadDisplay = new Button("Display");
        Button buttonRedHeadSwim = new Button("Swim");

        Button buttonRubberFly = new Button("Fly");
        Button buttonRubberQuack = new Button("Quack");
        Button buttonRubberDisplay = new Button("Display");
        Button buttonRubberSwim = new Button("Swim");

        Button buttonDecoyFly = new Button("Fly");
        Button buttonDecoyQuack = new Button("Quack");
        Button buttonDecoyDisplay = new Button("Display");
        Button buttonDecoySwim = new Button("Swim");

        Button buttonModelFly = new Button("Fly");
        Button buttonModelQuack = new Button("Quack");
        Button buttonModelDisplay = new Button("Display");
        Button buttonModelSwim = new Button("Swim");

        buttonMallardFly.setOnAction(e -> mallardDuck.performFly());
        buttonMallardQuack.setOnAction(e -> mallardDuck.performQuack());
        buttonMallardDisplay.setOnAction(e -> mallardDuck.display());
        buttonMallardSwim.setOnAction(e -> mallardDuck.swim());

        buttonRedHeadFly.setOnAction(e -> redHeadDuck.performFly());
        buttonRedHeadQuack.setOnAction(e -> redHeadDuck.performQuack());
        buttonRedHeadDisplay.setOnAction(e -> redHeadDuck.display());
        buttonRedHeadSwim.setOnAction(e -> redHeadDuck.swim());

        buttonRubberFly.setOnAction(e -> rubberDuck.performFly());
        buttonRubberQuack.setOnAction(e -> rubberDuck.performQuack());
        buttonRubberDisplay.setOnAction(e -> rubberDuck.display());
        buttonRubberSwim.setOnAction(e -> rubberDuck.swim());

        buttonDecoyFly.setOnAction(e -> decoyDuck.performFly());
        buttonDecoyQuack.setOnAction(e -> decoyDuck.performQuack());
        buttonDecoyDisplay.setOnAction(e -> decoyDuck.display());
        buttonDecoySwim.setOnAction(e -> decoyDuck.swim());

        buttonModelFly.setOnAction(e -> modelDuck.performFly());
        buttonModelQuack.setOnAction(e -> modelDuck.performQuack());
        buttonModelDisplay.setOnAction(e -> modelDuck.display());
        buttonModelSwim.setOnAction(e -> modelDuck.swim());

        gridPane.add(buttonMallardFly, 0, 4, 1, 1);
        gridPane.add(buttonMallardQuack, 0, 5, 1, 1);
        gridPane.add(buttonMallardDisplay, 0, 6, 1, 1);
        gridPane.add(buttonMallardSwim, 0, 7, 1, 1);

        gridPane.add(buttonRedHeadFly, 1, 4, 1, 1);
        gridPane.add(buttonRedHeadQuack, 1, 5, 1, 1);
        gridPane.add(buttonRedHeadDisplay, 1, 6, 1, 1);
        gridPane.add(buttonRedHeadSwim, 1, 7, 1, 1);

        gridPane.add(buttonRubberFly, 2, 4, 1, 1);
        gridPane.add(buttonRubberQuack, 2, 5, 1, 1);
        gridPane.add(buttonRubberDisplay, 2, 6, 1, 1);
        gridPane.add(buttonRubberSwim, 2, 7, 1, 1);

        gridPane.add(buttonDecoyFly, 3, 4, 1, 1);
        gridPane.add(buttonDecoyQuack, 3, 5, 1, 1);
        gridPane.add(buttonDecoyDisplay, 3, 6, 1, 1);
        gridPane.add(buttonDecoySwim, 3, 7, 1, 1);

        gridPane.add(buttonModelFly, 4, 4, 1, 1);
        gridPane.add(buttonModelQuack, 4, 5, 1, 1);
        gridPane.add(buttonModelDisplay, 4, 6, 1, 1);
        gridPane.add(buttonModelSwim, 4, 7, 1, 1);

        scene = new Scene(gridPane, 1000, 550);
        window.setScene(scene);
        window.show();
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
     * Displays an image in the background.
     * @param image background image
     */
    public static void addBackGroundImage(Image image)
    {
        backgroundImageView.setImage(image);
    }

    /**
     * Removes the background image.
     */
    public static void removeBackgroundImage()
    {
        backgroundImageView.setImage(null);
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}