package state;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import state.gumballmachine.GumballMachine;

import java.io.File;

public class Main extends Application
{
	private static GumballMachine gumballMachine = new GumballMachine(17);

	private static String imageDir = "res/images/state/";

	private Stage window;
	private GridPane gridPane = new GridPane();

	private Button insertQuarterButton = new Button("Insert Quarter");
	private Button ejectQuarterButton = new Button("Eject Quarter");
	private Button turnCrankButton = new Button("Turn Crank");
	private Button refillButton = new Button("Refill");

	private static Label labelGumballsRemaining = new Label("Gumballs Remaining: " + gumballMachine.getCount());

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
		Scene scene;
		window = primaryStage;
		window.setTitle("Mighty Gumball, Inc.: Where the Gumball Machine is Never Half Empty");
		window.setOnCloseRequest(e -> closeProgram());

		quarterImageView.setVisible(false);

		HBox hbox = new HBox();
		allImages.getChildren().addAll(gumballMachineImageView, crankImageView, quarterImageView, gumballsImageView, hbox);

		allImages.setAlignment(Pos.CENTER_LEFT);

		gridPane.setVgap(20);
		gridPane.setHgap(20);

		gridPane.add(allImages, 1, 0, 4, 1);
		gridPane.add(insertQuarterButton, 0, 1, 1, 1);
		gridPane.add(ejectQuarterButton, 1, 1, 1, 1);
		gridPane.add(turnCrankButton, 2, 1, 1, 1);
		gridPane.add(refillButton, 3, 1, 1, 1);
		gridPane.add(labelGumballsRemaining, 0, 2, 4, 1);

		insertQuarterButton.setOnAction(e -> insertQuarter());
		ejectQuarterButton.setOnAction(e -> ejectQuarter());
		turnCrankButton.setOnAction(e -> turnCrank());
		refillButton.setOnAction(e -> refill());

		scene = new Scene(gridPane, 1050, 800);
		window.setScene(scene);
		window.show();
	}

	/**
	 * Inserts a quarter into the machine.
	 */
	private void insertQuarter()
	{
		gumballMachine.insertQuarter();
		quarterImageView.setVisible(true);
	}

	/**
	 * Ejects a quarter out of the machine.
	 */
	private void ejectQuarter()
	{
		gumballMachine.ejectQuarter();
		quarterImageView.setVisible(false);
	}

	/**
	 * Turns the crank on the machine.
	 */
	private void turnCrank()
	{
		gumballMachine.turnCrank();

		if(crankImageView.getImage().equals(crankOpenImage))
			crankImageView.setImage(crankCloseImage);
		else
			crankImageView.setImage(crankOpenImage);

		if (quarterImageView.getImage().equals(quarterImage))
		{
			quarterImageView.setVisible(false);

			// remove gumball image from machine
			gumballsImage = new Image(new File(imageDir + + gumballMachine.getCount() + "Gumballs.png").toURI().toString());
			gumballsImageView.setImage(gumballsImage);

			// update gumball count
			labelGumballsRemaining.setText("Gumballs Remaining: " + gumballMachine.getCount());
		}
	}

	/**
	 * Refills the machine (admin method)
	 */
	private void refill()
	{
		gumballMachine.refill(17);
		gumballsImage = new Image(new File(imageDir + "17Gumballs.png").toURI().toString());
		gumballsImageView.setImage(gumballsImage);
		labelGumballsRemaining.setText("Gumballs Remaining: " + gumballMachine.getCount());
	}

	/**
	 * Closes the window of the program.
	 */
	private void closeProgram()
	{
		window.close();
	}
}