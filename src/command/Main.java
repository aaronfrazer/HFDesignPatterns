package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    private static String imageDir = "res/images/command/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();

    private Label labelLivingRoomLight = new Label("Living Room Light");
    private Label labelKitchenLight = new Label("Kitchen Light");
    private Label labelLivingRoomCeilingFan = new Label("Living Room Ceiling Fan");
    private Label labelGarageDoor = new Label("Garage Door");
    private Label labelStereo = new Label("Stereo");
    private Label labelAllLights = new Label("All Lights");
    private Label labelPartyMode = new Label("Party Mode");

    private Button buttonLivingRoomLightOn = new Button("On");
    private Button buttonLivingRoomLightOff = new Button("Off");
    private Button buttonKitchenLightOn = new Button("On");
    private Button buttonKitchenLightOff = new Button("Off");
    private Button buttonLivingRoomCeilingFanOn = new Button("On");
    private Button buttonLivingRoomCeilingFanOff = new Button("Off");
    private Button buttonGarageDoorOn = new Button("On");
    private Button buttonGarageDoorOff = new Button("Off");
    private Button buttonStereoOn = new Button("On");
    private Button buttonStereoOff = new Button("Off");
    private Button buttonAllLightsOn = new Button("On");
    private Button buttonAllLightsOff = new Button("Off");
    private Button buttonPartyModeOn = new Button("On");
    private Button buttonPartyModeOff = new Button("Off");

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

        // Labels
        gridPane.add(labelLivingRoomLight, 0, 0, 1, 1);
        gridPane.add(labelKitchenLight, 0, 1, 1, 1);
        gridPane.add(labelLivingRoomCeilingFan, 0, 2, 1, 1);
        gridPane.add(labelGarageDoor, 0, 3, 1, 1);
        gridPane.add(labelStereo, 0, 4, 1, 1);
        gridPane.add(labelAllLights, 0, 5, 1, 1);
        gridPane.add(labelPartyMode, 0, 6, 1, 1);

        // Buttons
        gridPane.add(buttonLivingRoomLightOn, 1, 0, 1, 1);
        gridPane.add(buttonLivingRoomLightOff, 2, 0, 1, 1);
        gridPane.add(buttonKitchenLightOn, 1, 1, 1, 1);
        gridPane.add(buttonKitchenLightOff, 2, 1, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanOn, 1, 2, 1, 1);
        gridPane.add(buttonLivingRoomCeilingFanOff, 2, 2, 1, 1);
        gridPane.add(buttonGarageDoorOn, 1, 3, 1, 1);
        gridPane.add(buttonGarageDoorOff, 2, 3, 1, 1);
        gridPane.add(buttonStereoOn, 1, 4, 1, 1);
        gridPane.add(buttonStereoOff, 2, 4, 1, 1);
        gridPane.add(buttonAllLightsOn, 1, 5, 1, 1);
        gridPane.add(buttonAllLightsOff, 2, 5, 1, 1);
        gridPane.add(buttonPartyModeOn, 1, 6, 1, 1);
        gridPane.add(buttonPartyModeOff, 2, 6, 1, 1);

        scene = new Scene(gridPane, 800, 400);
        window.setScene(scene);
        window.show();
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        window.close();
    }
}