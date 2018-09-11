package command;

import command.commands.*;
import command.devices.*;
import command.remoteControl.RemoteControlWithUndo;
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

import static command.devices.CeilingFan.*;

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
    private static ImageView imageViewGarageDoor = new ImageView(new Image(new File(imageDir + "GarageDoorClosed.jpg").toURI().toString()));
    private static ImageView imageViewStereo = new ImageView(new Image(new File(imageDir + "StereoOff.gif").toURI().toString()));
    private static ImageView imageViewHottub = new ImageView(new Image(new File(imageDir + "HotTubOff.jpg").toURI().toString()));
    private static ImageView imageViewTV = new ImageView(new Image(new File(imageDir + "TVOff.jpg").toURI().toString()));

    private Label labelLivingRoomLight = new Label("Living Room Light");
    private Label labelKitchenLight = new Label("Kitchen Light");
    private Label labelCeilingFanLow = new Label("Ceiling Fan Low");
    private Label labelCeilingFanMedium = new Label("Ceiling Fan Medium");
    private Label labelCeilingFanHigh = new Label("Ceiling Fan High");
    private Label labelGarageDoor = new Label("Garage Door");
    private Label labelStereo = new Label("Stereo");
    private Label labelHottub = new Label("Hot Tub");
    private Label labelTV = new Label("TV");
    private Label labelAllLights = new Label("All Lights");
    private Label labelPartyMode = new Label("Party Mode");
    private Label labelUndo = new Label("Undo");

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
    private Button buttonGarageDoorUp = new Button("On");
    private Button buttonGarageDoorDown = new Button("Off");
    private Button buttonStereoOn = new Button("On");
    private Button buttonStereoOff = new Button("Off");
    private Button buttonHottubOn = new Button("On");
    private Button buttonHottubOff = new Button("Off");
    private Button buttonTVOn = new Button("On");
    private Button buttonTVOff = new Button("Off");
    private Button buttonAllLightsOn = new Button("On");
    private Button buttonAllLightsOff = new Button("Off");
    private Button buttonPartyModeOn = new Button("On");
    private Button buttonPartyModeOff = new Button("Off");
    private Button buttonUndo = new Button("Undo");

    // Appliances
    private Light livingRoomLight = new Light("Living Room");
    private Light kitchenLight = new Light("Kitchen");
    private CeilingFan ceilingFan = new CeilingFan("Living Room");
    private GarageDoor garageDoor = new GarageDoor("Garage");
    private Stereo stereo = new Stereo("Garage");
    private Hottub hottub = new Hottub();
    private TV tv = new TV("Living Room");

    // Commands
    private LightOnCommand livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
    private LightOffCommand livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);
    private LightOnCommand kitchenLightOnCommand = new LightOnCommand(kitchenLight);
    private LightOffCommand kitchenLightOffCommand = new LightOffCommand(kitchenLight);
    private CeilingFanLowCommand ceilingFanLowCommand = new CeilingFanLowCommand(ceilingFan);
    private CeilingFanMediumCommand ceilingFanMediumCommand = new CeilingFanMediumCommand(ceilingFan);
    private CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
    private CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
    private GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(garageDoor);
    private GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(garageDoor);
    private StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
    private StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
    private HottubOnCommand hottubOnCommand = new HottubOnCommand(hottub);
    private HottubOffCommand hottubOffCommand = new HottubOffCommand(hottub);
    private TVOnCommand tvOnCommand = new TVOnCommand(tv);
    private TVOffCommand tvOffCommand = new TVOffCommand(tv);

    // All Lights Command
    private Command[] allLightsOn = {livingRoomLightOnCommand, kitchenLightOnCommand};
    private Command[] allLightsOff = {livingRoomLightOffCommand, kitchenLightOffCommand};
    private MacroCommand allLightsOnMacro = new MacroCommand(allLightsOn);
    private MacroCommand allLightsOffMacro = new MacroCommand(allLightsOff);

    // Party Command
    private Command[] partyOn = {livingRoomLightOnCommand, kitchenLightOnCommand, ceilingFanMediumCommand, garageDoorUpCommand, stereoOnCommand, hottubOnCommand, tvOnCommand};
    private Command[] partyOff = {livingRoomLightOffCommand, kitchenLightOffCommand, ceilingFanOffCommand, garageDoorDownCommand, stereoOffCommand, hottubOffCommand, tvOffCommand};
    private MacroCommand partyOnMacro = new MacroCommand(partyOn);
    private MacroCommand partyOffMacro = new MacroCommand(partyOff);

    // Remote Control
    private RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

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

        imageViewLivingRoom.setFitHeight(80);
        imageViewLivingRoom.setPreserveRatio(true);
        imageViewKitchen.setFitHeight(80);
        imageViewKitchen.setPreserveRatio(true);
        imageViewCeilingFan.setFitHeight(80);
        imageViewCeilingFan.setPreserveRatio(true);
        imageViewGarageDoor.setFitHeight(80);
        imageViewGarageDoor.setPreserveRatio(true);
        imageViewStereo.setFitHeight(80);
        imageViewStereo.setPreserveRatio(true);
        imageViewHottub.setFitHeight(80);
        imageViewHottub.setPreserveRatio(true);
        imageViewTV.setFitHeight(80);
        imageViewTV.setPreserveRatio(true);

        // Set remote control with commands
        remoteControl.setCommand(0, livingRoomLightOnCommand, livingRoomLightOffCommand);
        remoteControl.setCommand(1, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteControl.setCommand(2, ceilingFanLowCommand, ceilingFanOffCommand);
        remoteControl.setCommand(3, ceilingFanMediumCommand, ceilingFanOffCommand);
        remoteControl.setCommand(4, ceilingFanHighCommand, ceilingFanOffCommand);
        remoteControl.setCommand(5, garageDoorUpCommand, garageDoorDownCommand);
        remoteControl.setCommand(6, stereoOnCommand, stereoOffCommand);
        remoteControl.setCommand(7, hottubOnCommand, hottubOffCommand);
        remoteControl.setCommand(8, tvOnCommand, tvOffCommand);

        // Labels and buttons
        gridPane.add(labelLivingRoomLight, 0, 0, 1, 1);
        gridPane.add(buttonLivingRoomLightOn, 1, 0, 1, 1);
        gridPane.add(buttonLivingRoomLightOff, 2, 0, 1, 1);
        gridPane.add(imageViewLivingRoom, 3, 0, 1, 1);
        gridPane.add(labelKitchenLight, 0, 1, 1, 1);
        gridPane.add(buttonKitchenLightOn, 1, 1, 1, 1);
        gridPane.add(buttonKitchenLightOff, 2, 1, 1, 1);
        gridPane.add(imageViewKitchen, 3, 1, 1, 1);
        gridPane.add(labelCeilingFanLow, 0, 2, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanLow, 1, 2, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanLowOff, 2, 2, 1, 1);
        gridPane.add(imageViewCeilingFan, 3, 2, 1, 1);
        gridPane.add(labelCeilingFanMedium, 0, 3, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanMedium, 1, 3, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanMediumOff, 2, 3, 1, 1);
        gridPane.add(labelCeilingFanHigh, 0, 4, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanHigh, 1, 4, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanHighOff, 2, 4, 1, 1);
        gridPane.add(labelGarageDoor, 0, 5, 1, 1);
        gridPane.add(buttonGarageDoorUp, 1, 5, 1, 1);
        gridPane.add(buttonGarageDoorDown, 2, 5, 1, 1);
        gridPane.add(imageViewGarageDoor, 3, 5, 1, 1);
        gridPane.add(labelStereo, 0, 6, 1, 1);
        gridPane.add(buttonStereoOn, 1, 6, 1, 1);
        gridPane.add(buttonStereoOff, 2, 6, 1, 1);
        gridPane.add(imageViewStereo, 3, 6, 1, 1);
        gridPane.add(labelHottub, 0, 7, 1, 1);
        gridPane.add(buttonHottubOn, 1, 7, 1, 1);
        gridPane.add(buttonHottubOff, 2, 7, 1, 1);
        gridPane.add(imageViewHottub, 3, 7, 1, 1);
        gridPane.add(labelTV, 0, 8, 1, 1);
        gridPane.add(buttonTVOn, 1, 8, 1, 1);
        gridPane.add(buttonTVOff, 2, 8, 1, 1);
        gridPane.add(imageViewTV, 3, 8, 1, 1);
        gridPane.add(labelAllLights, 0, 9, 1, 1);
        gridPane.add(buttonAllLightsOn, 1, 9, 1, 1);
        gridPane.add(buttonAllLightsOff, 2, 9, 1, 1);
        gridPane.add(labelPartyMode, 0, 10, 1, 1);
        gridPane.add(buttonPartyModeOn, 1, 10, 1, 1);
        gridPane.add(buttonPartyModeOff, 2, 10, 1, 1);
        gridPane.add(labelUndo, 0, 11, 1, 1);
        gridPane.add(buttonUndo, 1, 11, 1, 1);

        // When you click the buttons, execute their actions
        buttonLivingRoomLightOn.setOnAction(e -> remoteControl.onButtonWasPushed(0));
        buttonLivingRoomLightOff.setOnAction(e -> remoteControl.offButtonWasPushed(0));
        buttonKitchenLightOn.setOnAction(e -> remoteControl.onButtonWasPushed(1));
        buttonKitchenLightOff.setOnAction(e -> remoteControl.offButtonWasPushed(1));
        buttonLivingRoomCeilingFanLow.setOnAction(e -> remoteControl.onButtonWasPushed(2));
        buttonLivingRoomCeilingFanLowOff.setOnAction(e -> remoteControl.offButtonWasPushed(2));
        buttonLivingRoomCeilingFanMedium.setOnAction(e -> remoteControl.onButtonWasPushed(3));
        buttonLivingRoomCeilingFanMediumOff.setOnAction(e -> remoteControl.offButtonWasPushed(3));
        buttonLivingRoomCeilingFanHigh.setOnAction(e -> remoteControl.onButtonWasPushed(4));
        buttonLivingRoomCeilingFanHighOff.setOnAction(e -> remoteControl.offButtonWasPushed(4));
        buttonGarageDoorUp.setOnAction(e -> remoteControl.onButtonWasPushed(5));
        buttonGarageDoorDown.setOnAction(e -> remoteControl.offButtonWasPushed(5));
        buttonStereoOn.setOnAction(e -> remoteControl.onButtonWasPushed(6));
        buttonStereoOff.setOnAction(e -> remoteControl.offButtonWasPushed(6));
        buttonHottubOn.setOnAction(e -> remoteControl.onButtonWasPushed(7));
        buttonHottubOff.setOnAction(e -> remoteControl.offButtonWasPushed(7));
        buttonTVOn.setOnAction(e -> remoteControl.onButtonWasPushed(8));
        buttonTVOff.setOnAction(e -> remoteControl.offButtonWasPushed(8));
        buttonAllLightsOn.setOnAction(e -> allLightsOnMacro.execute());
        buttonAllLightsOff.setOnAction(e -> allLightsOffMacro.execute());
        buttonPartyModeOn.setOnAction(e -> partyOnMacro.execute());
        buttonPartyModeOff.setOnAction(e -> partyOffMacro.execute());
        buttonUndo.setOnAction(e -> remoteControl.undoButtonWasPushed());

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

        if (location.equals("Living Room"))
            imageViewLivingRoom.setImage(new Image(file.toURI().toString()));
        if (location.equals("Kitchen"))
            imageViewKitchen.setImage(new Image(file.toURI().toString()));
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

        if (file != null)
            imageViewCeilingFan.setImage(new Image(file.toURI().toString()));
    }

    public static void openCloseGarageDoor(boolean up)
    {
        File file;

        if (up)
            file = new File(imageDir + "GarageDoorOpen.jpg");
        else
            file = new File(imageDir + "GarageDoorClosed.jpg");

        imageViewGarageDoor.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffStereo(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "StereoOn.gif");
        else
            file = new File(imageDir + "StereoOff.gif");

        imageViewStereo.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffHuttub(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "HotTubOn.jpg");
        else
            file = new File(imageDir + "HotTubOff.jpg");

        imageViewHottub.setImage(new Image(file.toURI().toString()));
    }

    public static void turnOnOffTV(boolean on)
    {
        File file;

        if (on)
            file = new File(imageDir + "TVOn.gif");
        else
            file = new File(imageDir + "TVOff.jpg");

        imageViewTV.setImage(new Image(file.toURI().toString()));
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        window.close();
    }
}