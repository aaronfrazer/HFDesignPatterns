package template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application
{
	private static int numBeveragesBeingBoiled = 0, numBeveragesBeingBrewed = 0, numBeveragesBeingPouredIntoCup = 0, numBeveragesBeingCondimented = 0;

	private static final Timeline timeline = new Timeline();

	private static String imageDir = "res/images/template/";

	private Stage window;
	private Scene scene;
	private GridPane gridPane = new GridPane();

	private CheckBox teaCondimentsCheckBox = new CheckBox("Condiments");
	private CheckBox coffeeCondimentsCheckBox = new CheckBox("Condiments");

	private Button teaButton = new Button("Make Tea");
	private Button coffeeButton = new Button("Make Coffee");

	private static ImageView boilWaterImageView = new ImageView();
	private static ImageView brewImageView = new ImageView();
	private static ImageView pourInCupImageView = new ImageView();
	private static ImageView addCondimentsImageView = new ImageView();

	private static Image boilWaterAnimationImage = new Image(new File(imageDir + "BoilWater.gif").toURI().toString());
	private static Image steepTeaAnimationImage = new Image(new File(imageDir + "SteepTea.gif").toURI().toString());
	private static Image filterCoffeeAnimationImage = new Image(new File(imageDir + "FilterCoffee.jpg").toURI().toString());
	private static Image pourIntoCupAnimationImage = new Image(new File(imageDir + "PourIntoCup.gif").toURI().toString());
	private static Image addLemonAnimationImage = new Image(new File(imageDir + "AddLemon.gif").toURI().toString());
	private static Image addSugarAndMilkAnimationImage = new Image(new File(imageDir + "AddSugarAndMilk.gif").toURI().toString());

	private static Text beverageBoilAmount = new Text("x" + numBeveragesBeingBoiled);
	private static Text beverageBrewAmount = new Text("x" + numBeveragesBeingBrewed);
	private static Text beveragePourAmount = new Text("x" + numBeveragesBeingPouredIntoCup);
	private static Text beverageCondimentsAmount = new Text("x" + numBeveragesBeingCondimented);

	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage)
	{
		window = primaryStage;
		window.setTitle("StarBuzz: Tea and Coffee");
		window.setOnCloseRequest(e -> closeProgram());

		boilWaterImageView.setImage(boilWaterAnimationImage);
//		brewImageView.setImage(brewAnimationImage);
		pourInCupImageView.setImage(pourIntoCupAnimationImage);
//		addCondimentsImageView.setImage(addCondimentAnimationImage);

		boilWaterImageView.setVisible(false);
		brewImageView.setVisible(false);
		pourInCupImageView.setVisible(false);
		addCondimentsImageView.setVisible(false);

		boilWaterImageView.setFitWidth(200);
		boilWaterImageView.setFitHeight(200);
		brewImageView.setFitWidth(200);
		brewImageView.setFitHeight(200);
		pourInCupImageView.setFitWidth(200);
		pourInCupImageView.setFitHeight(200);
		addCondimentsImageView.setFitWidth(200);
		addCondimentsImageView.setFitHeight(200);

		gridPane.add(teaButton, 0, 0, 1, 1);
		gridPane.add(teaCondimentsCheckBox, 0, 2, 1, 1);
		gridPane.add(coffeeButton, 1, 0, 1, 1);
		gridPane.add(coffeeCondimentsCheckBox, 1, 2, 1, 1);

		gridPane.add(boilWaterImageView, 0, 13, 1, 1);
		gridPane.add(brewImageView, 1, 13, 1, 1);
		gridPane.add(pourInCupImageView, 2, 13, 1, 1);
		gridPane.add(addCondimentsImageView, 3, 13, 1, 1);

		gridPane.add(beverageBoilAmount, 0, 14, 1, 1);
		gridPane.add(beverageBrewAmount, 1, 14, 1, 1);
		gridPane.add(beveragePourAmount, 2, 14, 1, 1);
		gridPane.add(beverageCondimentsAmount, 3, 14, 1, 1);

		teaButton.setOnAction(e -> prepareTea());
		coffeeButton.setOnAction(e -> prepareCoffee());

		scene = new Scene(gridPane, 1000, 600);
		window.setScene(scene);
		window.show();

		// Initialize prepareTimeline: wait 2 seconds to simulate baking a pizza
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(0),
						e -> playBoilWaterAnimation()
				));
		// stop animation
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(2000),
						e -> stopBoilWaterAnimation()
				));

		// Initialize bakeTimeline: wait 2 seconds to simulate baking a pizza
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(2000),
						e -> playBrewAnimation()
				));

		// stop animation
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(4000),
						e -> stopBrewAnimation()
				));

		// Initialize cutTimeline: wait 2 seconds to simulate cutting a pizza
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(4000),
						e -> playPourAnimation()
				));

		// stop animation
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(6000),
						e -> stopPourAnimation()
				));

		// Initialize boxTimeline: wait 2 seconds to simulate boxing a pizza
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(6000),
						e -> playAddCondimentsAnimation()
				));

		// stop animation
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(8000),
						e -> stopAddCondimentsAnimation()
				));

		// Initialize orderPizzaTimeline
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(8000),
						e -> printOrder()
				));
	}

	/**
	 * Prepares tea with condiments (if selected).
	 */
	private void prepareTea()
	{
		if (teaCondimentsCheckBox.isSelected())
		{

		}

		timeline.play();
	}

	/**
	 * Prepares coffee with condiments (if selected).
	 */
	private void prepareCoffee()
	{
		if (coffeeCondimentsCheckBox.isSelected())
		{

		}

		timeline.play();
	}

	/**
	 * Outputs the order details to the command line.
	 */
	private void printOrder()
	{
		System.out.println("\nWe prepared a beverage");
	}

	private static void playBoilWaterAnimation()
	{
		System.out.println("Boiling Water...");
		boilWaterImageView.setVisible(true);
		numBeveragesBeingBoiled++;
		beverageBoilAmount.setText("x" + numBeveragesBeingBoiled);
	}

	private static void stopBoilWaterAnimation()
	{
		boilWaterImageView.setVisible(false);
		numBeveragesBeingBoiled--;
		beverageBoilAmount.setText("x" + numBeveragesBeingBoiled);
	}

	private static void playBrewAnimation()
	{
		System.out.println("Brewing Beverage...");
		brewImageView.setVisible(true);
		numBeveragesBeingBrewed++;
		beverageBrewAmount.setText("x" + numBeveragesBeingBrewed);
	}

	private static void stopBrewAnimation()
	{
		brewImageView.setVisible(false);
		numBeveragesBeingBrewed--;
		beverageBrewAmount.setText("x" + numBeveragesBeingBrewed);
	}

	private static void playPourAnimation()
	{
		System.out.println("Pouring Into Cup...");
		pourInCupImageView.setVisible(true);
		numBeveragesBeingPouredIntoCup++;
		beveragePourAmount.setText("x" + numBeveragesBeingPouredIntoCup);
	}

	private static void stopPourAnimation()
	{
		pourInCupImageView.setVisible(false);
		numBeveragesBeingPouredIntoCup--;
		beveragePourAmount.setText("x" + numBeveragesBeingPouredIntoCup);
	}

	private static void playAddCondimentsAnimation()
	{
		System.out.println("Adding Condiments...");
		addCondimentsImageView.setVisible(true);
		numBeveragesBeingCondimented++;
		beverageCondimentsAmount.setText("x" + numBeveragesBeingCondimented);
	}

	private static void stopAddCondimentsAnimation()
	{
		addCondimentsImageView.setVisible(false);
		numBeveragesBeingCondimented--;
		beverageCondimentsAmount.setText("x" + numBeveragesBeingCondimented);
	}

	/**
	 * Closes the window of the program.
	 */
	private void closeProgram()
	{
		window.close();
	}
}