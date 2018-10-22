package facade;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;

import static command.devices.CeilingFan.*;

public class Main extends Application
{
    private static String imageDir = "res/images/facade/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private static ImageView imageViewAmplifier = new ImageView(new Image(new File(imageDir + "Amplifier.png").toURI().toString()));
    private static ImageView imageViewTuner = new ImageView(new Image(new File(imageDir + "Radio.png").toURI().toString()));
    private static ImageView imageViewDVDPlayer = new ImageView(new Image(new File(imageDir + "DVDPlayer.png").toURI().toString()));
    private static ImageView imageViewCDPlayer = new ImageView(new Image(new File(imageDir + "CDPlayer.png").toURI().toString()));
    private static ImageView imageViewProjector = new ImageView(new Image(new File(imageDir + "Projector.png").toURI().toString()));
    private static ImageView imageViewLights = new ImageView(new Image(new File(imageDir + "LightOff.jpg").toURI().toString()));
    private static ImageView imageViewScreen = new ImageView(new Image(new File(imageDir + "Screen.png").toURI().toString()));
    private static ImageView imageViewPopcornPopper = new ImageView(new Image(new File(imageDir + "PopcornPopper.gif").toURI().toString()));

    private Button buttonWatchMovie = new Button("Watch Movie");
    private Button buttonEndMovie = new Button("End Movie");

    // Appliances
    private Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    private Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
    private DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    private CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
    private Projector projector = new Projector("Top-O-Line Projector", dvd);
    private TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    private Screen screen = new Screen("Theater Screen");
    private PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    // Remote Control
    private HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Home Theater Facade : Top-O-Line Movie Theater");
        window.setOnCloseRequest(e -> closeProgram());

        gridPane.setHgap(20);
        gridPane.setVgap(10);

        imageViewAmplifier.setFitHeight(80);
        imageViewAmplifier.setPreserveRatio(true);
        imageViewTuner.setFitHeight(80);
        imageViewTuner.setPreserveRatio(true);
        imageViewDVDPlayer.setFitHeight(80);
        imageViewDVDPlayer.setPreserveRatio(true);
        imageViewCDPlayer.setFitHeight(80);
        imageViewCDPlayer.setPreserveRatio(true);
        imageViewProjector.setFitHeight(80);
        imageViewProjector.setPreserveRatio(true);
        imageViewLights.setFitHeight(80);
        imageViewLights.setPreserveRatio(true);
        imageViewScreen.setFitHeight(80);
        imageViewScreen.setPreserveRatio(true);
        imageViewPopcornPopper.setFitHeight(80);
        imageViewPopcornPopper.setPreserveRatio(true);

        // Pictures and buttons
        gridPane.add(imageViewLights, 1, 0, 1, 1);

        gridPane.add(imageViewScreen, 0, 1, 1, 1);
        gridPane.add(imageViewProjector, 1, 1, 1, 1);
        gridPane.add(imageViewTuner, 1, 2, 1, 1);
        gridPane.add(imageViewDVDPlayer, 1, 3, 1, 1);
        gridPane.add(imageViewCDPlayer, 1, 4, 1, 1);
        gridPane.add(imageViewAmplifier, 1, 5, 1, 1);
        gridPane.add(imageViewPopcornPopper, 3, 1, 1, 1);
        gridPane.add(buttonWatchMovie, 4, 0, 1, 1);
        gridPane.add(buttonEndMovie, 4, 1, 1, 1);

        // When you click the buttons, execute their actions
        buttonWatchMovie.setOnAction(e -> homeTheater.watchMovie("Raiders of the Lost Ark"));
        buttonEndMovie.setOnAction(e -> homeTheater.endMovie());

        scene = new Scene(gridPane, 600, 800);
        window.setScene(scene);
        window.show();
    }

    public static void displayLightImage(String location, boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "LightOn.jpg");
        else
            file = new File(imageDir + "LightOff.jpg");

//        if (location.equals("Living Room"))
//            imageViewLivingRoom.setImage(new Image(file.toURI().toString()));
//        if (location.equals("Kitchen"))
//            imageViewKitchen.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnCeilingFan(int speed)
    {
        File file = null;

        switch (speed)
        {
            case OFF:       file = new File(imageDir + "CeilingFanOff.gif");
                            break;
            case LOW:       file = new File(imageDir + "CeilingFanLow.gif");
                            break;
            case MEDIUM:    file = new File(imageDir + "CeilingFanMedium.gif");
                            break;
            case HIGH:      file = new File(imageDir + "CeilingFanHigh.gif");
                            break;
        }

//        if (file != null)
//            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
    }

    public static void openCloseGarageDoor(boolean up)
    {
        File file;

//        if (up)
//            file = new File(imageDir + "GarageDoorOpen.jpg");
//        else
//            file = new File(imageDir + "GarageDoorClosed.jpg");

//        imageViewGarageDoor.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffStereo(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "StereoOn.gif");
        else
            file = new File(imageDir + "StereoOff.gif");

//        imageViewStereo.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffHuttub(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "HotTubOn.jpg");
        else
            file = new File(imageDir + "HotTubOff.jpg");

//        imageViewHottub.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffTV(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "TVOn.gif");
        else
            file = new File(imageDir + "TVOff.jpg");

//        imageViewTV.setImage(new Image(file.toURI().toString()));
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        window.close();
    }
}