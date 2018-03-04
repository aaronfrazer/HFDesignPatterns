package factory;

import factory.pizza.*;
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

public class MainFactory extends Application
{
    private static int numPizzasBeingPrepared = 0, numPizzasBeingBaked = 0, numPizzasBeingCut = 0, numPizzasBeingBoxed = 0;

    public static final Timeline timeline = new Timeline();

    private static String imageDir = "res/images/";

    private SimplePizzaFactory factory = new SimplePizzaFactory();
    private PizzaStore pizzaStore;

    private static Pizza pizza;

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private ToggleGroup styleGroup = new ToggleGroup();
    private ToggleGroup typeGroup = new ToggleGroup();

    private Label labelType = new Label("Pizza Store:");
    private RadioButton radioButtonChicago = new RadioButton("Chicago");
    private RadioButton radioButtonNY = new RadioButton("New York");

    private Label labelPizzaMenu = new Label("--- Chicago Pizza Menu ---");

    private RadioButton radioButtonCheese = new RadioButton("Cheese");
    private RadioButton radioButtonVeggie = new RadioButton("Veggie");
    private RadioButton radioButtonClam = new RadioButton("Clam");
    private RadioButton radioButtonPepperoni = new RadioButton("Pepperoni");

    private Text textCheeseDescription = new Text();
    private Text textVeggieDescription = new Text();
    private Text textClamDescription = new Text();
    private Text textPepperoniDescription = new Text();

    private Button orderButton = new Button("Order Pizza");

    private static ImageView pizzaPrepareImageView = new ImageView();
    private static ImageView pizzaBakeImageView = new ImageView();
    private static ImageView pizzaCutImageView = new ImageView();
    private static ImageView pizzaBoxImageView = new ImageView();

    private static Image prepareAnimationImage = new Image(new File(imageDir + "PizzaPrepare.gif").toURI().toString());
    private static Image bakeAnimationImage = new Image(new File(imageDir + "PizzaBake.jpg").toURI().toString());
    private static Image cutAnimationImage = new Image(new File(imageDir + "PizzaCut.gif").toURI().toString());
    private static Image boxAnimationImage = new Image(new File(imageDir + "PizzaBox.gif").toURI().toString());

    private static Text pizzaPrepareAmount = new Text("x" + numPizzasBeingPrepared);
    private static Text pizzaBakeAmount = new Text("x" + numPizzasBeingPrepared);
    private static Text pizzaCutAmount = new Text("x" + numPizzasBeingPrepared);
    private static Text pizzaBoxAmount = new Text("x" + numPizzasBeingPrepared);

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Pizza Store");
        window.setOnCloseRequest(e -> closeProgram());

        radioButtonChicago.setToggleGroup(styleGroup);
        radioButtonNY.setToggleGroup(styleGroup);

        radioButtonChicago.setOnAction(e -> showChicagoButton());
        radioButtonNY.setOnAction(e -> showNYButton());

        radioButtonCheese.setToggleGroup(typeGroup);
        radioButtonVeggie.setToggleGroup(typeGroup);
        radioButtonClam.setToggleGroup(typeGroup);
        radioButtonPepperoni.setToggleGroup(typeGroup);

        pizzaPrepareImageView.setImage(prepareAnimationImage);
        pizzaBakeImageView.setImage(bakeAnimationImage);
        pizzaCutImageView.setImage(cutAnimationImage);
        pizzaBoxImageView.setImage(boxAnimationImage);

        pizzaPrepareImageView.setVisible(false);
        pizzaBakeImageView.setVisible(false);
        pizzaCutImageView.setVisible(false);
        pizzaBoxImageView.setVisible(false);

        pizzaPrepareImageView.setFitWidth(200);
        pizzaPrepareImageView.setFitHeight(200);
        pizzaBakeImageView.setFitWidth(200);
        pizzaBakeImageView.setFitHeight(200);
        pizzaCutImageView.setFitWidth(200);
        pizzaCutImageView.setFitHeight(200);
        pizzaBoxImageView.setFitWidth(200);
        pizzaBoxImageView.setFitHeight(200);

        textCheeseDescription.setWrappingWidth(200);
        textVeggieDescription.setWrappingWidth(200);
        textClamDescription.setWrappingWidth(200);
        textPepperoniDescription.setWrappingWidth(200);

        gridPane.add(labelType, 0, 0, 1, 1);
        gridPane.add(radioButtonChicago, 0, 1,1, 1);
        gridPane.add(radioButtonNY, 0, 2,1, 1);

        gridPane.add(labelPizzaMenu, 0, 3, 1, 1);

        gridPane.add(radioButtonCheese, 0, 4,1, 1);
        gridPane.add(textCheeseDescription, 0, 5, 1, 1);
        gridPane.add(radioButtonVeggie, 0, 6,1, 1);
        gridPane.add(textVeggieDescription, 0, 7, 1, 1);
        gridPane.add(radioButtonClam, 0, 8,1, 1);
        gridPane.add(textClamDescription, 0, 9, 1, 1);
        gridPane.add(radioButtonPepperoni, 0, 10,1, 1);
        gridPane.add(textPepperoniDescription, 0, 11, 1, 1);

        gridPane.add(orderButton, 0, 12, 1, 1);

        gridPane.add(pizzaPrepareImageView, 0, 13, 1, 1);
        gridPane.add(pizzaBakeImageView, 1, 13, 1, 1);
        gridPane.add(pizzaCutImageView, 2, 13, 1, 1);
        gridPane.add(pizzaBoxImageView, 3, 13, 1, 1);

        gridPane.add(pizzaPrepareAmount, 0, 14,1, 1);
        gridPane.add(pizzaBakeAmount, 1, 14,1, 1);
        gridPane.add(pizzaCutAmount, 2, 14,1, 1);
        gridPane.add(pizzaBoxAmount, 3, 14,1, 1);

        orderButton.setOnAction(e -> orderPizza());

        scene = new Scene(gridPane, 1000, 600);
        window.setScene(scene);
        window.show();
    }

    /**
     * Orders a pizza depending on the radio button selected.
     */
    private void orderPizza()
    {
        RadioButton pizzaStore = (RadioButton) styleGroup.getSelectedToggle();
        switch(pizzaStore.getText()) {
            case "New York":
                this.pizzaStore = new NYPizzaStore(factory);
                break;
            case "Chicago":
                this.pizzaStore = new ChicagoPizzaStore(factory);
                break;
        }

        RadioButton pizzaType = (RadioButton) typeGroup.getSelectedToggle();
        switch (pizzaType.getText()) {
            case "Cheese":
                pizza = this.pizzaStore.orderPizza("cheese");
                break;
            case "Pepperoni":
                pizza = this.pizzaStore.orderPizza("pepperoni");
                break;
            case "Clam":
                pizza = this.pizzaStore.orderPizza("clam");
                break;
            case "Veggie":
                pizza = this.pizzaStore.orderPizza("veggie");
                break;
        }

        pizza.setStyle(pizzaStore.getText());

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(8000),
                e -> printOrder()
        ));

        timeline.play();
    }

    /**
     * Outputs the order details to the command line.
     */
    private void printOrder()
    {
//        orderTextArea.appendText("\nWe ordered a " + pizza.getName() + "\n");
//        orderTextArea.appendText(String.valueOf(pizza));

        System.out.println("\nWe ordered a " + pizza.getStyle() + " " + pizza.getName());
        System.out.println(String.valueOf(pizza));
    }

    private void showChicagoButton()
    {
        labelPizzaMenu.setText("--- Chicago Pizza Menu ---");
        textCheeseDescription.setText("Plum Tomato Sauce, Mozzarella, Parmesan, Oregano");
        textVeggieDescription.setText("Plum Tomato Sauce, Mozzarella, Parmesan, Eggplant, Spinach, Black Olives");
        textClamDescription.setText("Plum Tomato Sauce, Mozzarella, Parmesan, Clams");
        textPepperoniDescription.setText("Plum Tomato Sauce, Mozzarella, Parmesan, Eggplant, Spinach, Black Olives, Pepperoni");
    }

    private void showNYButton()
    {
        labelPizzaMenu.setText("--- New York Pizza Menu ---");
        textCheeseDescription.setText("Marinara Sauce, Reggiano, Garlic");
        textVeggieDescription.setText("Marinara Sauce, Reggiano, Mushrooms, Onions, Red Peppers");
        textClamDescription.setText("Marinara Sauce, Reggiano, Fresh Clams");
        textPepperoniDescription.setText("Marinara Sauce, Reggiano, Mushrooms, Onions, Red Peppers, Pepperoni");
    }

    public static void playPrepareAnimation(String name)
    {
        System.out.println("Preparing " + name + "...");
        pizzaPrepareImageView.setVisible(true);
        numPizzasBeingPrepared++;
        pizzaPrepareAmount.setText("x" + numPizzasBeingPrepared);
    }

    public static void stopPrepareAnimation()
    {
        pizzaPrepareImageView.setVisible(false);
        numPizzasBeingPrepared--;
        pizzaPrepareAmount.setText("x" + numPizzasBeingPrepared);
    }

    public static void playBakeAnimation(String name)
    {
        System.out.println("Baking " + name + "...");
        pizzaBakeImageView.setVisible(true);
        numPizzasBeingBaked++;
        pizzaBakeAmount.setText("x" + numPizzasBeingBaked);
    }

    public static void stopBakeAnimation()
    {
        pizzaBakeImageView.setVisible(false);
        numPizzasBeingBaked--;
        pizzaBakeAmount.setText("x" + numPizzasBeingBaked);
    }

    public static void playCutAnimation(String name)
    {
        System.out.println("Cutting " + name + "...");
        pizzaCutImageView.setVisible(true);
        numPizzasBeingCut++;
        pizzaCutAmount.setText("x" + numPizzasBeingCut);
    }

    public static void stopCutAnimation()
    {
        pizzaCutImageView.setVisible(false);
        numPizzasBeingCut--;
        pizzaCutAmount.setText("x" + numPizzasBeingCut);
    }

    public static void playBoxAnimation(String name)
    {
        System.out.println("Boxing " + name + "...");
        pizzaBoxImageView.setVisible(true);
        numPizzasBeingBoxed++;
        pizzaBoxAmount.setText("x" + numPizzasBeingBoxed);
    }

    public static void stopBoxAnimation()
    {
        pizzaBoxImageView.setVisible(false);
        numPizzasBeingBoxed--;
        pizzaBoxAmount.setText("x" + numPizzasBeingBoxed);
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}
