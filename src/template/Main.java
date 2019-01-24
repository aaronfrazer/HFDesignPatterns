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
import template.beverages.CaffeineBeverage;
import template.beverages.Tea;
import template.beverages.Coffee;

import java.io.File;

public class Main extends Application
{
	private static CaffeineBeverage currentBeverage;

	private static int numBeveragesBeingBoiled = 0, numBeveragesBeingBrewed = 0, numBeveragesBeingPouredIntoCup = 0, numBeveragesBeingCondimented = 0;

	private Tea tea = new Tea();
	private Coffee coffee = new Coffee();

	public static final Timeline boilTimeline = new Timeline();
	public static final Timeline brewTimeline = new Timeline();
	public static final Timeline pourTimeline = new Timeline();
	public static final Timeline condimentsTimeline = new Timeline();

	private static String imageDir = "res/images/template/";

	private Stage window;
	private Scene scene;
	private GridPane gridPane = new GridPane();

	private static CheckBox teaCondimentsCheckBox = new CheckBox("Condiments");
	private static CheckBox coffeeCondimentsCheckBox = new CheckBox("Condiments");

	private Button teaButton = new Button("Make Tea");
	private Button coffeeButton = new Button("Make Coffee");

	private static ImageView boilWaterImageView = new ImageView();
	private static ImageView brewImageView = new ImageView();
	private static ImageView pourInCupImageView = new ImageView();
	private static ImageView addCondimentsImageView = new ImageView();

	private static Image boilWaterAnimationImage = new Image(new File(imageDir + "BoilWater.gif").toURI().toString());
	private static Image steepTeaAnimationImage = new Image(new File(imageDir + "SteepTea.gif").toURI().toString());
	private static Image filterCoffeeAnimationImage = new Image(new File(imageDir + "FilterCoffee.gif").toURI().toString());
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
		boilTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(0),
						e -> playBoilWaterAnimation()
				));
		// stop animation
		boilTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(2000),
						e -> stopBoilWaterAnimation()
				));

		// Initialize bakeTimeline: wait 2 seconds to simulate baking a pizza
		brewTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(2000),
						e -> playBrewAnimation()
				));

		// stop animation
		brewTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(4000),
						e -> stopBrewAnimation()
				));

		// Initialize cutTimeline: wait 2 seconds to simulate cutting a pizza
		pourTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(4000),
						e -> playPourAnimation()
				));

		// stop animation
		pourTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(6000),
						e -> stopPourAnimation()
				));

		// Initialize boxTimeline: wait 2 seconds to simulate boxing a pizza
		condimentsTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(6000),
						e -> playAddCondimentsAnimation()
				));

		// stop animation
		condimentsTimeline.getKeyFrames().add(
				new KeyFrame(Duration.millis(8000),
						e -> stopAddCondimentsAnimation()
				));
	}

	/**
	 * Prepares tea with condiments (if selected).
	 */
	private void prepareTea()
	{
		currentBeverage = tea;
		boolean teaCondiments = false;
		if (teaCondimentsCheckBox.isSelected())
			teaCondiments = true;

		tea.prepareRecipe(tea.toString(), teaCondiments);
	}

	/**
	 * Prepares coffee with condiments (if selected).
	 */
	private void prepareCoffee()
	{
		currentBeverage = coffee;
		boolean coffeeCondiments = false;
		if (coffeeCondimentsCheckBox.isSelected())
			coffeeCondiments = true;

		coffee.prepareRecipe(coffee.toString(), coffeeCondiments);
	}

	private static void printOrder()
	{
		System.out.println("We made " + currentBeverage.toString() + "!\n");
	}

	private static void playBoilWaterAnimation()
	{
		System.out.println("Boiling Water...");
		boilWaterImageView.setImage(boilWaterAnimationImage);
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
		if (currentBeverage instanceof Tea)
		{
			System.out.println("Steeping " + currentBeverage.toString() + "...");
			brewImageView.setImage(steepTeaAnimationImage);
		} else if (currentBeverage instanceof Coffee)
		{
			System.out.println("Dripping " + currentBeverage.toString() + " Through Filter...");
			brewImageView.setImage(filterCoffeeAnimationImage);
		}

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
		pourInCupImageView.setImage(pourIntoCupAnimationImage);
		pourInCupImageView.setVisible(true);
		numBeveragesBeingPouredIntoCup++;
		beveragePourAmount.setText("x" + numBeveragesBeingPouredIntoCup);
	}

	private static void stopPourAnimation()
	{
		pourInCupImageView.setVisible(false);
		numBeveragesBeingPouredIntoCup--;
		beveragePourAmount.setText("x" + numBeveragesBeingPouredIntoCup);

		if (currentBeverage instanceof Tea && !teaCondimentsCheckBox.isSelected())
			printOrder();

		if (currentBeverage instanceof Coffee && !coffeeCondimentsCheckBox.isSelected())
			printOrder();
	}

	private static void playAddCondimentsAnimation()
	{
		if (currentBeverage instanceof Tea)
		{
			System.out.println("Adding Lemon to " + currentBeverage.toString() + "...");
			addCondimentsImageView.setImage(addLemonAnimationImage);
		} else if (currentBeverage instanceof Coffee)
		{
			System.out.println("Adding Sugar and Milk to " + currentBeverage.toString() + "...");
			addCondimentsImageView.setImage(addSugarAndMilkAnimationImage);
		}

		addCondimentsImageView.setVisible(true);
		numBeveragesBeingCondimented++;
		beverageCondimentsAmount.setText("x" + numBeveragesBeingCondimented);
	}

	private static void stopAddCondimentsAnimation()
	{
		addCondimentsImageView.setVisible(false);
		numBeveragesBeingCondimented--;
		beverageCondimentsAmount.setText("x" + numBeveragesBeingCondimented);
		printOrder();
	}

	/**
	 * Closes the window of the program.
	 */
	private void closeProgram()
	{
		window.close();
	}
}