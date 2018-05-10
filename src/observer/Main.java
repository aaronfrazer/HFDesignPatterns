package observer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import observer.observers.CurrentConditionsDisplay;
import observer.observers.ForecastDisplay;
import observer.observers.Observer;
import observer.observers.StatisticsDisplay;
import observer.subject.WeatherData;
import observer.subject.WeatherThreadRunner;

import java.io.File;

public class Main extends Application
{
    public static WeatherData weatherData;
    public static CurrentConditionsDisplay currentDisplay;
    public static StatisticsDisplay statisticsDisplay;
    public static ForecastDisplay forecastDisplay;

    private static Thread thread;
    private static WeatherThreadRunner wtr;

    private static String imageDir = "res/images/";

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private StackPane stackPane = new StackPane();

    private static ImageView weatherTowerImageView = new ImageView(new Image(new File(imageDir + "WeatherTower.png").toURI().toString()));
    private static Image animationImage = new Image(new File(imageDir + "spark.gif").toURI().toString());
    private static ImageView animationImageView = new ImageView(animationImage);

    private static ImageView currentConditionsDisplayImageView = new ImageView(new Image(new File(imageDir + "CurrentConditionsDisplay.png").toURI().toString()));
    private static ImageView statisticsDisplayImageView = new ImageView(new Image(new File(imageDir + "StatisticsDisplay.png").toURI().toString()));
    private static ImageView forecastDisplayImageView = new ImageView(new Image(new File(imageDir + "ForecastDisplay.jpg").toURI().toString()));

    private static ImageView upArrowImageView = new ImageView(new Image(new File(imageDir + "Arrow.png").toURI().toString()));
    private static ImageView arrowImageView = new ImageView(new Image(new File(imageDir + "Arrow.png").toURI().toString()));
    private static ImageView downArrowImageView = new ImageView(new Image(new File(imageDir + "Arrow.png").toURI().toString()));

    public static TextArea weatherStationTextArea = new TextArea();
    public static TextArea currentConditionsTextArea = new TextArea();
    public static TextArea statisticsTextArea = new TextArea();
    public static TextArea forecastTextArea = new TextArea();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Weather-O-Rama: Weather Monitoring Station");
        window.setOnCloseRequest(e -> closeProgram());

        // Weather tower image on left
        animationImageView.setFitWidth(100);
        animationImageView.setFitHeight(100);
        weatherTowerImageView.setFitWidth(200);
        weatherTowerImageView.setFitHeight(200);
        // Images
        StackPane.setAlignment(animationImageView, Pos.TOP_CENTER);
        stackPane.getChildren().addAll(weatherTowerImageView, animationImageView);
        gridPane.add(stackPane, 0, 0, 1, 3);

        // Arrow images in center
        upArrowImageView.setFitWidth(100);
        upArrowImageView.setFitHeight(100);
        upArrowImageView.setRotate(-20);
        gridPane.add(upArrowImageView, 1, 0, 1, 1);
        arrowImageView.setFitWidth(100);
        arrowImageView.setFitHeight(100);
        gridPane.add(arrowImageView, 1, 1, 1, 1);
        downArrowImageView.setFitWidth(100);
        downArrowImageView.setFitHeight(100);
        downArrowImageView.setRotate(20);
        gridPane.add(downArrowImageView, 1, 2, 1, 1);

        // Observer images on right
        currentConditionsDisplayImageView.setFitWidth(100);
        currentConditionsDisplayImageView.setFitHeight(100);
        statisticsDisplayImageView.setFitWidth(100);
        statisticsDisplayImageView.setFitHeight(100);
        forecastDisplayImageView.setFitWidth(100);
        forecastDisplayImageView.setFitHeight(100);
        gridPane.add(currentConditionsDisplayImageView, 2, 0, 1, 1);
        gridPane.add(statisticsDisplayImageView, 2, 1, 1, 1);
        gridPane.add(forecastDisplayImageView, 2, 2, 1, 1);

        // Text areas for display elements
        VBox wsVBox = new VBox(weatherStationTextArea);
        VBox ccVBox = new VBox(currentConditionsTextArea);
        VBox sVBox = new VBox(statisticsTextArea);
        VBox fVBox = new VBox(forecastTextArea);
        gridPane.add(wsVBox, 0, 3, 1, 1);
        gridPane.add(ccVBox, 3, 0, 1, 1);
        gridPane.add(sVBox, 3, 1, 1, 1);
        gridPane.add(fVBox, 3, 2, 1, 1);

        // Checkboxes for display elements (register/remove)
        CheckBox ccCheckBox = new CheckBox("Current Conditions");
        CheckBox sCheckBox = new CheckBox("Statistics");
        CheckBox fCheckBox = new CheckBox("Forecast");
        ccCheckBox.setSelected(true);
        sCheckBox.setSelected(true);
        fCheckBox.setSelected(true);

        ccCheckBox.selectedProperty().addListener((v, oldValue, newValue) -> manageObserver(newValue, currentDisplay));
        sCheckBox.selectedProperty().addListener((v, oldValue, newValue) -> manageObserver(newValue, statisticsDisplay));
        fCheckBox.selectedProperty().addListener((v, oldValue, newValue) -> manageObserver(newValue, forecastDisplay));

        gridPane.add(ccCheckBox, 4, 0, 1, 1);
        gridPane.add(sCheckBox, 4, 1, 1, 1);
        gridPane.add(fCheckBox, 4, 2, 1, 1);

        scene = new Scene(gridPane, 1200, 400);
        window.setScene(scene);
        window.show();

        runWeatherStationThread();
    }

    /**
     * Starts and runs the weather station thread.
     */
    private static void runWeatherStationThread()
    {
        wtr = new WeatherThreadRunner();
        thread = new Thread(wtr);
        thread.start();
    }

    /**
     * Displays an animated image in front of the weather tower.
     */
    public static void displayUpdateImage()
    {
        animationImageView.setVisible(true);
    }

    /**
     * Removes animated image in front of weather tower.
     */
    public static void removeUpdateImage()
    {
        animationImageView.setVisible(false);
    }

    /**
     * Manages an observer by registering/removing them from observers.
     *
     * @param register true if this observer should be registered, false if should be removed
     */
    private static void manageObserver(boolean register, Observer observer)
    {
        if (register)
            weatherData.registerObserver(observer);
        else
            weatherData.removeObserver(observer);
    }

    /**
     * Terminates thread and closes program window.
     */
    private void closeProgram()
    {
        if (thread != null)
            wtr.terminate();

        window.close();
    }
}