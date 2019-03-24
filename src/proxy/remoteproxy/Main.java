package proxy.remoteproxy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application
{
    private static GumballMachineReal gumballMachineReal = new GumballMachineReal(17);
    private GumballMachineProxy gumballMachineProxy = new GumballMachineProxy(gumballMachineReal);

    private static String imageDir = "res/images/state/";

    private Stage clientWindow, gumballWindow;
    private GridPane gridPane1 = new GridPane();
    private GridPane gridPane2 = new GridPane();

    private Button buttonGumballMachine = new Button("Update");

    private static Label labelGumballMachine = new Label("Gumball Machine: ");
    private static Label labelCurrentInventory = new Label("Current Inventory: ");
    private static Label labelCurrentState = new Label("Current State: ");


    private Button insertQuarterButton = new Button("Insert Quarter");
    private Button ejectQuarterButton = new Button("Eject Quarter");
    private Button turnCrankButton = new Button("Turn Crank");
    private Button refillButton = new Button("Refill");

    private static Label labelGumballsRemaining = new Label("Gumballs Remaining: " + gumballMachineReal.getCount());

    private static Image gumballMachineImage = new Image(new File(imageDir + "GumballMachineShell.png").toURI().toString());
    private static Image crankOpenImage = new Image(new File(imageDir + "CrankLeft.png").toURI().toString());
    private static Image crankCloseImage = new Image(new File(imageDir + "CrankRight.png").toURI().toString());
    private static Image quarterImage = new Image(new File(imageDir + "Quarter.png").toURI().toString());
    private static Image gumballsImage = new Image(new File(imageDir + "17Gumballs.png").toURI().toString());

    private static ImageView gumballMachineImageView = new ImageView(gumballMachineImage);
    private static ImageView crankImageView = new ImageView(crankOpenImage);
    private static ImageView quarterImageView = new ImageView(quarterImage);
    private static ImageView gumballsImageView = new ImageView(gumballsImage);

    private StackPane allImages = new StackPane();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Stage stage2 = new Stage();
        Scene scene1, scene2;
        clientWindow = primaryStage;
        clientWindow.setTitle("Mighty Gumball, Inc. CEO Desktop (Client Machine)");
        clientWindow.setOnCloseRequest(e -> closeProgram());
        gumballWindow = stage2;
        gumballWindow.setTitle("Remote Gumball Machine");
        gumballWindow.setOnCloseRequest(e -> closeProgram());

        buttonGumballMachine.setOnAction(e -> {
            labelCurrentInventory.setText("Current Inventory: " + gumballMachineProxy.getCount());
            labelCurrentState.setText("Current State: " + gumballMachineProxy.getState().toString());
        });

        gridPane1.add(labelGumballMachine, 0, 0, 1, 1);
        gridPane1.add(buttonGumballMachine, 1, 0, 1, 1);
        gridPane1.add(labelCurrentInventory, 0, 1, 1, 1);
        gridPane1.add(labelCurrentState, 0, 2, 1, 1);

        quarterImageView.setVisible(false);

        HBox hbox = new HBox();
        allImages.getChildren().addAll(gumballMachineImageView, crankImageView, quarterImageView, gumballsImageView, hbox);

        allImages.setAlignment(Pos.CENTER_LEFT);

        gridPane2.setVgap(20);
        gridPane2.setHgap(20);

        gridPane2.add(allImages, 1, 0, 4, 1);
        gridPane2.add(insertQuarterButton, 0, 1, 1, 1);
        gridPane2.add(ejectQuarterButton, 1, 1, 1, 1);
        gridPane2.add(turnCrankButton, 2, 1, 1, 1);
        gridPane2.add(refillButton, 3, 1, 1, 1);
        gridPane2.add(labelGumballsRemaining, 0, 2, 4, 1);

        insertQuarterButton.setOnAction(e -> insertQuarter());
        ejectQuarterButton.setOnAction(e -> ejectQuarter());
        turnCrankButton.setOnAction(e -> turnCrank());
        refillButton.setOnAction(e -> refill());

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double screenWidth = primaryScreenBounds.getWidth();
        double screenHeight = primaryScreenBounds.getHeight();

        clientWindow.setX(screenWidth / 10);
        clientWindow.setY(screenHeight / 3);
        gumballWindow.setX(screenWidth / 2.5);
        gumballWindow.setY(screenHeight / 10);
        scene1 = new Scene(gridPane1, screenWidth / 4, 200);
        clientWindow.setScene(scene1);
        clientWindow.show();
        scene2 = new Scene(gridPane2, screenWidth / 2, 700);
        gumballWindow.setScene(scene2);
        gumballWindow.show();
    }

    /**
     * Inserts a quarter into the machine.
     */
    private void insertQuarter()
    {
        gumballMachineReal.insertQuarter();
        quarterImageView.setVisible(true);
    }

    /**
     * Ejects a quarter out of the machine.
     */
    private void ejectQuarter()
    {
        gumballMachineReal.ejectQuarter();
        quarterImageView.setVisible(false);
    }

    /**
     * Turns the crank on the machine.
     */
    private void turnCrank()
    {
        gumballMachineReal.turnCrank();

        if (crankImageView.getImage().equals(crankOpenImage))
            crankImageView.setImage(crankCloseImage);
        else
            crankImageView.setImage(crankOpenImage);

        if (quarterImageView.getImage().equals(quarterImage))
        {
            quarterImageView.setVisible(false);

            // remove gumball image from machine
            gumballsImage = new Image(new File(imageDir + +gumballMachineReal.getCount() + "Gumballs.png").toURI().toString());
            gumballsImageView.setImage(gumballsImage);

            // update gumball count
            labelGumballsRemaining.setText("Gumballs Remaining: " + gumballMachineReal.getCount());
        }
    }

    /**
     * Refills the machine (admin method)
     */
    private void refill()
    {
        gumballMachineReal.refill(17);
        gumballsImage = new Image(new File(imageDir + "17Gumballs.png").toURI().toString());
        gumballsImageView.setImage(gumballsImage);
        labelGumballsRemaining.setText("Gumballs Remaining: " + gumballMachineReal.getCount());
    }

    /**
     * Closes the clientWindow of the program.
     */
    private void closeProgram()
    {
        clientWindow.close();
    }
}