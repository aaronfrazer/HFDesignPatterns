package factory;

import factory.pizza.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application
{
    public static final Timeline timeline = new Timeline();

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private SimplePizzaFactory factory = new SimplePizzaFactory();
    private PizzaStore store = new PizzaStore(factory);

    private static Pizza pizza;

    private ToggleGroup typeGroup = new ToggleGroup();

    private Label labelType = new Label("Pizza Types:");
    private RadioButton radioButtonCheese = new RadioButton("Cheese");
    private RadioButton radioButtonPepperoni = new RadioButton("Pepperoni");
    private RadioButton radioButtonClam = new RadioButton("Clam");
    private RadioButton radioButtonVeggie = new RadioButton("Veggie");

    private Button orderButton = new Button("Order Pizza");

    private Label labelOrder = new Label("Ordered Pizzas:");
    public static TextArea orderTextArea = new TextArea();

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

        // Sizes first
        radioButtonCheese.setSelected(true);

        radioButtonCheese.setToggleGroup(typeGroup);
        radioButtonPepperoni.setToggleGroup(typeGroup);
        radioButtonClam.setToggleGroup(typeGroup);
        radioButtonVeggie.setToggleGroup(typeGroup);

        gridPane.add(labelType, 0, 0, 1, 1);
        gridPane.add(radioButtonCheese, 0, 1,1, 1);
        gridPane.add(radioButtonPepperoni, 0, 2,1, 1);
        gridPane.add(radioButtonClam, 0, 3,1, 1);
        gridPane.add(radioButtonVeggie, 0, 4,1, 1);

        gridPane.add(orderButton, 1, 1, 1, 5);

        orderButton.setOnAction(e -> orderPizza());

        // Order Breakdown on right
        gridPane.add(labelOrder, 2, 0, 1, 1);
        gridPane.add(orderTextArea, 2, 1, 1, 5);

        scene = new Scene(gridPane, 800, 400);
        window.setScene(scene);
        window.show();
    }

    /**
     * Outputs the order details to the command line.
     */
    private void printOrder()
    {
        orderTextArea.appendText("\nWe ordered a " + pizza.getName() + "\n");
        orderTextArea.appendText(String.valueOf(pizza));
    }

    /**
     * Orders a pizza depending on the radio button selected.
     */
    private void orderPizza()
    {
        RadioButton pizzaType = (RadioButton) typeGroup.getSelectedToggle();
        switch (pizzaType.getText()) {
            case "Cheese":
                pizza = store.orderPizza("cheese");
                break;
            case "Pepperoni":
                pizza = store.orderPizza("pepperoni");
                break;
            case "Clam":
                pizza = store.orderPizza("clam");
                break;
            case "Veggie":
                pizza = store.orderPizza("veggie");
                break;
        }

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(5000),
                e -> printOrder()
        ));

        timeline.play();
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}