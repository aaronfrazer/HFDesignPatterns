package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;

import static command.CeilingFan.*;

public class Main extends Application
{
    private static String imageDir = "res/images/command/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();

    private static ImageView imageViewLivingRoom = new ImageView(new Image(new File(imageDir + "LightOff.jpg").toURI().toString()));
    private static ImageView imageViewKitchen = new ImageView(new Image(new File(imageDir + "LightOff.jpg").toURI().toString()));
    private static ImageView imageViewCeilingFan = new ImageView(new Image(new File(imageDir + "CeilingFanOff.gif").toURI().toString()));

    private Label labelLivingRoomLight = new Label("Living Room Light");
    private Label labelKitchenLight = new Label("Kitchen Light");
    private Label labelCeilingFanLow = new Label("Ceiling Fan Low");
    private Label labelCeilingFanMedium = new Label("Ceiling Fan Medium");
    private Label labelCeilingFanHigh = new Label("Ceiling Fan High");
    private Label labelGarageDoor = new Label("Garage Door");
    private Label labelStereo = new Label("Stereo");
    private Label labelAllLights = new Label("All Lights");
    private Label labelPartyMode = new Label("Party Mode");

    private Button buttonLivingRoomLightOn = new Button("On");
    private Button buttonLivingRoomLightOff = new Button("Off");
    private Button buttonKitchenLightOn = new Button("On");
    private Button buttonKitchenLightOff = new Button("Off");
    private Button buttonLivingRoomCeilingFanLow = new Button("On");
    private Button buttonLivingRoomCeilingFanLowOff = new Button("Off");
    private Button buttonLivingRoomCeilingFanMedium = new Button("On");
    private Button buttonLivingRoomCeilingFanMediumOff = new Button("Off");
    private Button buttonLivingRoomCeilingFanHigh = new Button("On");
    private Button buttonLivingRoomCeilingFanHighOff = new Button("Off");
    private Button buttonGarageDoorOn = new Button("On");
    private Button buttonGarageDoorOff = new Button("Off");
    private Button buttonStereoOn = new Button("On");
    private Button buttonStereoOff = new Button("Off");
    private Button buttonAllLightsOn = new Button("On");
    private Button buttonAllLightsOff = new Button("Off");
    private Button buttonPartyModeOn = new Button("On");
    private Button buttonPartyModeOff = new Button("Off");


    // Remote Control
    private RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

    // Appliances
    private Light livingRoomLight = new Light("Living Room");
    private Light kitchenLight = new Light("Kitchen");
    private CeilingFan ceilingFan = new CeilingFan("Living Room");

    // Commands
    private LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
    private LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
    private LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
    private LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
    private CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
    private CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
    private CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
    private CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Home Automation or Bust, Inc. : Home Automation Remote Control");
        window.setOnCloseRequest(e -> closeProgram());

        gridPane.setHgap(40);
        gridPane.setVgap(20);

        imageViewLivingRoom.setFitHeight(100);
        imageViewLivingRoom.setPreserveRatio(true);
        imageViewKitchen.setFitHeight(100);
        imageViewKitchen.setPreserveRatio(true);
        imageViewCeilingFan.setFitHeight(100);
        imageViewCeilingFan.setPreserveRatio(true);

        // Labels
        gridPane.add(labelLivingRoomLight, 0, 0, 1, 1);
        gridPane.add(labelKitchenLight, 0, 1, 1, 1);
        gridPane.add(labelCeilingFanLow, 0, 2, 1, 1);
        gridPane.add(labelCeilingFanMedium, 0, 3, 1, 1);
        gridPane.add(labelCeilingFanHigh, 0, 4, 1, 1);
        gridPane.add(labelGarageDoor, 0, 5, 1, 1);
        gridPane.add(labelStereo, 0, 6, 1, 1);
        gridPane.add(labelAllLights, 0, 7, 1, 1);
        gridPane.add(labelPartyMode, 0, 8, 1, 1);

        // Buttons
        gridPane.add(buttonLivingRoomLightOn, 1, 0, 1, 1);
        gridPane.add(buttonLivingRoomLightOff, 2, 0, 1, 1);
        gridPane.add(imageViewLivingRoom, 3, 0, 1, 1);
        gridPane.add(buttonKitchenLightOn, 1, 1, 1, 1);
        gridPane.add(buttonKitchenLightOff, 2, 1, 1, 1);
        gridPane.add(imageViewKitchen, 3, 1, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanLow, 1, 2, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanLowOff, 2, 2, 1, 1);
        gridPane.add(imageViewCeilingFan, 3, 2, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanMedium, 1, 3, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanMediumOff, 2, 3, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanHigh, 1, 4, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanHighOff, 2, 4, 1, 1);
        gridPane.add(buttonGarageDoorOn, 1, 5, 1, 1);
        gridPane.add(buttonGarageDoorOff, 2, 5, 1, 1);
        gridPane.add(buttonStereoOn, 1, 6, 1, 1);
        gridPane.add(buttonStereoOff, 2, 6, 1, 1);
        gridPane.add(buttonAllLightsOn, 1, 7, 1, 1);
        gridPane.add(buttonAllLightsOff, 2, 7, 1, 1);
        gridPane.add(buttonPartyModeOn, 1, 8, 1, 1);
        gridPane.add(buttonPartyModeOff, 2, 8, 1, 1);

        // When you click the buttons, show their image
        buttonLivingRoomLightOn.setOnAction(e -> livingRoomLightOnCommand.execute());
        buttonLivingRoomLightOff.setOnAction(e -> livingRoomLightOffCommand.execute());
        buttonKitchenLightOn.setOnAction(e -> kitchenLightOnCommand.execute());
        buttonKitchenLightOff.setOnAction(e -> kitchenLightOffCommand.execute());
        buttonLivingRoomCeilingFanLow.setOnAction(e -> ceilingFanLowCommand.execute());
        buttonLivingRoomCeilingFanLowOff.setOnAction(e -> ceilingFanOffCommand.execute());
        buttonLivingRoomCeilingFanMedium.setOnAction(e -> ceilingFanMediumCommand.execute());
        buttonLivingRoomCeilingFanMediumOff.setOnAction(e -> ceilingFanOffCommand.execute());
        buttonLivingRoomCeilingFanHigh.setOnAction(e -> ceilingFanHighCommand.execute());
        buttonLivingRoomCeilingFanHighOff.setOnAction(e -> ceilingFanOffCommand.execute());
        // ...

        scene = new Scene(gridPane, 600, 800);
        window.setScene(scene);
        window.show();
    }

    static void displayImage(String location, boolean on)
    {
        File file;
        if (on)
            file = new File(imageDir + "LightOn.jpg");
        else
            file = new File(imageDir + "LightOff.jpg");

        if (location.equals("Living Room"))
            imageViewLivingRoom.setImage(new Image(file.toURI().toString()));
        if (location.equals("Kitchen"))
            imageViewKitchen.setImage(new Image(file.toURI().toString()));
    }

    static void turnOnCeilingFan(int speed)
    {
        File file = null;

        switch (speed)
        {
            case OFF:       file = new File(imageDir + "CeilingFanOff.gif");
                            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
                            break;
            case LOW:       file = new File(imageDir + "CeilingFanLow.gif");
                            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
                            break;
            case MEDIUM:    file = new File(imageDir + "CeilingFanMedium.gif");
                            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
                            break;
            case HIGH:      file = new File(imageDir + "CeilingFanHigh.gif");
                            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
                            break;
        }

        if (file != null)
            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        window.close();
    }
}