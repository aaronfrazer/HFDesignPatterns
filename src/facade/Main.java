package facade;

import facade.appliances.*;
import facade.homeTheater.HomeTheaterFacade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

import static command.devices.CeilingFan.*;

public class Main extends Application
{
    private static String imageDir = "res/images/facade1/";

    private Stage window;
    private Scene scene;
    private GridPane gridPaneDevices = new GridPane();
    private GridPane gridPaneButtons = new GridPane();
    private HBox hBox = new HBox();

    // Images
    private static ImageView imageViewAmplifier = new ImageView(new Image(new File(imageDir + "Amplifier.png").toURI().toString()));
    private static ImageView imageViewTuner = new ImageView(new Image(new File(imageDir + "Radio.png").toURI().toString()));
    private static ImageView imageViewDVDPlayer = new ImageView(new Image(new File(imageDir + "DVDPlayer.png").toURI().toString()));
    private static ImageView imageViewCDPlayer = new ImageView(new Image(new File(imageDir + "CDPlayer.png").toURI().toString()));
    private static ImageView imageViewProjector = new ImageView(new Image(new File(imageDir + "Projector.png").toURI().toString()));
    private static ImageView imageViewLights = new ImageView(new Image(new File(imageDir + "LightOff.jpg").toURI().toString()));
    private static ImageView imageViewScreen = new ImageView(new Image(new File(imageDir + "Screen.png").toURI().toString()));
    private static ImageView imageViewPopcornPopper = new ImageView(new Image(new File(imageDir + "PopcornPopperOff.png").toURI().toString()));

    // Labels
    private Label labelWatchMovie = new Label("Watch Movie:");
    private Label labelAmplifier = new Label("Amplifier:");
    private Label labelTuner = new Label("Radio:");
    private Label labelDVD = new Label("DVD:");
    private Label labelCD = new Label("CD:");
    private Label labelProjector = new Label("Projector:");
    private Label labelLights = new Label("Lights:");
    private Label labelScreen = new Label("Screen:");
    private Label labelPopcornPopper = new Label("Popcorn:");

    // Buttons
    private Button buttonWatchMovie = new Button("Watch Movie");
    private Button buttonEndMovie = new Button("End Movie");
    private Button buttonAmplifierOn = new Button("On");
    private Button buttonAmplifierOff = new Button("Off");
    private Button buttonAmplifierSetStereoSound = new Button("Stereo");
    private Button buttonAmplifierSetSurroundSound = new Button("Surround");
    private Button buttonAmplifierSetVolume = new Button("Set Volume");
    private Button buttonAmplifierSetTuner = new Button("Radio");
    private Button buttonAmplifierSetDVD = new Button("DVD");
    private Button buttonAmplifierSetCD = new Button("CD");
    private Button buttonTunerOn = new Button("On");
    private Button buttonTunerOff = new Button("Off");
    private Button buttonTunerSetFrequency = new Button("Set Frequency");
    private Button buttonTunerSetAM = new Button("Set AM");
    private Button buttonTunerSetFM = new Button("Set FM");
    private Button buttonDvdPlayerOn = new Button("On");
    private Button buttonDvdPlayerOff = new Button("Off");
    private Button buttonDvdPlayerEject = new Button("Eject");
    private Button buttonDvdPlayerPlay = new Button("Play");
    private Button buttonDvdPlayerStop = new Button("Stop");
    private Button buttonDvdPlayerPause = new Button("Pause");
    private Button buttonDvdPlayerSetTwoChannelAudio = new Button("2 Channel Audio");
    private Button buttonDvdPlayerSetSurroundAudio = new Button("Surround Audio");
    private Button buttonCdPlayerOn = new Button("On");
    private Button buttonCdPlayerOff = new Button("Off");
    private Button buttonCdPlayerEject = new Button("Eject");
    private Button buttonCdPlayerPlay = new Button("Play");
    private Button buttonCdPlayerStop = new Button("Stop");
    private Button buttonCdPlayerPause = new Button("Pause");
    private Button buttonProjectorOn = new Button("On");
    private Button buttonProjectorOff = new Button("Off");
    private Button buttonProjectorWideScreenMode = new Button("Wide Screen Mode");
    private Button buttonProjectorTvMode = new Button("TV Mode");
    private Button buttonLightsOn = new Button("On");
    private Button buttonLightsOff = new Button("Off");
    private Button buttonLightsDim = new Button("Dim");
    private Button buttonScreenUp = new Button("Up");
    private Button buttonScreenDown = new Button("Down");
    private Button buttonPopcornOn = new Button("On");
    private Button buttonPopcornOff = new Button("Off");
    private Button buttonPopcornPop = new Button("Pop");

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

        gridPaneDevices.setHgap(20);
        gridPaneDevices.setVgap(0);
        gridPaneButtons.setHgap(20);
        gridPaneButtons.setVgap(10);

        imageViewAmplifier.setFitHeight(60);
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
        imageViewScreen.setFitHeight(120);
        imageViewScreen.setPreserveRatio(true);
        imageViewPopcornPopper.setFitHeight(200);
        imageViewPopcornPopper.setPreserveRatio(true);

        // Devices
        gridPaneDevices.add(imageViewLights, 1, 0, 1, 1);
        gridPaneDevices.add(imageViewScreen, 0, 1, 1, 3);
        gridPaneDevices.add(imageViewProjector, 1, 1, 1, 1);
        gridPaneDevices.add(imageViewTuner, 1, 2, 1, 1);
        gridPaneDevices.add(imageViewDVDPlayer, 1, 3, 1, 1);
        gridPaneDevices.add(imageViewCDPlayer, 1, 4, 1, 1);
        gridPaneDevices.add(imageViewAmplifier, 1, 5, 1, 1);
        gridPaneDevices.add(imageViewPopcornPopper, 3, 1, 1, 5);

        // Buttons
        gridPaneButtons.add(labelWatchMovie, 0, 0, 1, 1);
        gridPaneButtons.add(buttonWatchMovie, 1, 0, 1, 1);
        gridPaneButtons.add(buttonEndMovie, 2, 0, 1, 1);
        gridPaneButtons.add(labelAmplifier, 0, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierOn, 1, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierOff, 2, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetStereoSound, 3, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetSurroundSound, 4, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetVolume, 5, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetTuner, 6, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetDVD, 7, 1, 1, 1);
        gridPaneButtons.add(buttonAmplifierSetCD, 8, 1, 1, 1);
        gridPaneButtons.add(labelTuner, 0, 2, 1, 1);
        gridPaneButtons.add(buttonTunerOn, 1, 2, 1, 1);
        gridPaneButtons.add(buttonTunerOff, 2, 2, 1, 1);
        gridPaneButtons.add(buttonTunerSetFrequency, 3, 2, 1, 1);
        gridPaneButtons.add(buttonTunerSetAM, 4, 2, 1, 1);
        gridPaneButtons.add(buttonTunerSetFM, 5, 2, 1, 1);
        gridPaneButtons.add(labelDVD, 0, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerOn, 1, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerOff, 2, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerEject, 3, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerPlay, 4, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerStop, 5, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerPause, 6, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerSetTwoChannelAudio, 7, 3, 1, 1);
        gridPaneButtons.add(buttonDvdPlayerSetSurroundAudio, 8, 3, 1, 1);
        gridPaneButtons.add(labelCD, 0, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerOn, 1, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerOff, 2, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerEject, 3, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerPlay, 4, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerStop, 5, 4, 1, 1);
        gridPaneButtons.add(buttonCdPlayerPause, 6, 4, 1, 1);
        gridPaneButtons.add(labelProjector, 0, 5, 1, 1);
        gridPaneButtons.add(buttonProjectorOn, 1, 5, 1, 1);
        gridPaneButtons.add(buttonProjectorOff, 2, 5, 1, 1);
        gridPaneButtons.add(buttonProjectorWideScreenMode, 3, 5, 1, 1);
        gridPaneButtons.add(buttonProjectorTvMode, 4, 5, 1, 1);
        gridPaneButtons.add(labelLights, 0, 6, 1, 1);
        gridPaneButtons.add(buttonLightsOn, 1, 6, 1, 1);
        gridPaneButtons.add(buttonLightsOff, 2, 6, 1, 1);
        gridPaneButtons.add(buttonLightsDim, 3, 6, 1, 1);
        gridPaneButtons.add(labelScreen, 0, 7, 1, 1);
        gridPaneButtons.add(buttonScreenUp, 1, 7, 1, 1);
        gridPaneButtons.add(buttonScreenDown, 2, 7, 1, 1);
        gridPaneButtons.add(labelPopcornPopper, 0, 8, 1, 1);
        gridPaneButtons.add(buttonPopcornOn, 1, 8, 1, 1);
        gridPaneButtons.add(buttonPopcornOff, 2, 8, 1, 1);
        gridPaneButtons.add(buttonPopcornPop, 3, 8, 1, 1);

        // When you click the buttons, execute their actions
        buttonWatchMovie.setOnAction(e -> homeTheater.watchMovie("Raiders of the Lost Ark"));
        buttonEndMovie.setOnAction(e -> homeTheater.endMovie());

        hBox.getChildren().addAll(gridPaneDevices, gridPaneButtons);

        scene = new Scene(hBox, 1600, 600);
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