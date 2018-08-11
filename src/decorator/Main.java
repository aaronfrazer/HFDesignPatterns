package decorator;

import decorator.beverages.*;
import decorator.condiments.Milk;
import decorator.condiments.Mocha;
import decorator.condiments.Soy;
import decorator.condiments.Whip;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application
{
    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private static Beverage beverage;

    private ObservableList<Beverage> beverages = FXCollections.observableArrayList();

    private ToggleGroup sizesGroup = new ToggleGroup();
    private ToggleGroup coffeesGroup = new ToggleGroup();

    private Label labelSize = new Label("Sizes");
    private RadioButton radioButtonTall = new RadioButton("Tall ($0.10)");
    private RadioButton radioButtonGrande = new RadioButton("Grande ($0.15)");
    private RadioButton radioButtonVenti = new RadioButton("Venti ($0.20)");

    private Label labelCoffees = new Label("Coffees");
    private RadioButton radioButtonHouseBlend = new RadioButton("House Blend ($0.89)");
    private RadioButton radioButtonDarkRoast = new RadioButton("Dark Roast ($0.99)");
    private RadioButton radioButtonDecaf = new RadioButton("Decaf ($1.05)");
    private RadioButton radioButtonEspresso = new RadioButton("Espresso ($1.99)");

    private Label labelCondiments = new Label("Condiments");
    private CheckBox checkBoxMilk = new CheckBox("Milk ($0.10)");
    private CheckBox checkBoxMocha = new CheckBox("Mocha ($0.20)");
    private CheckBox checkBoxSoy = new CheckBox("Soy ($0.15)");
    private CheckBox checkBoxWhip = new CheckBox("Whip ($0.10)");

    private Label labelQuantity = new Label("Qty");
    private ChoiceBox<String> choiceBoxMilk = new ChoiceBox<>();
    private ChoiceBox<String> choiceBoxMocha = new ChoiceBox<>();
    private ChoiceBox<String> choiceBoxSoy = new ChoiceBox<>();
    private ChoiceBox<String> choiceBoxWhip = new ChoiceBox<>();

    private Label labelOrder = new Label("Description:");
    private TextField orderTextField = new TextField();

    private Button addButton = new Button("Add to Order");

    private Label labelTable = new Label("Order Breakdown:");
    private TableView<Beverage> tableBeverages;
    private TableColumn<Beverage, String> descColumn = new TableColumn<>("Description");
    private TableColumn<Beverage, Double> priceColumn = new TableColumn<>("Price");

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Starbuzz Coffee");
        window.setOnCloseRequest(e -> closeProgram());

        // Sizes first
        radioButtonTall.setSelected(true);

        radioButtonTall.setToggleGroup(sizesGroup);
        radioButtonGrande.setToggleGroup(sizesGroup);
        radioButtonVenti.setToggleGroup(sizesGroup);

        gridPane.add(labelSize, 0, 0, 1, 1);
        gridPane.add(radioButtonTall, 0, 1, 1, 1);
        gridPane.add(radioButtonGrande, 0, 2, 1, 1);
        gridPane.add(radioButtonVenti, 0, 3, 1, 1);

        sizesGroup.selectedToggleProperty().addListener(e -> createBeverage());

        // Coffees on left
        radioButtonHouseBlend.setToggleGroup(coffeesGroup);
        radioButtonDarkRoast.setToggleGroup(coffeesGroup);
        radioButtonDecaf.setToggleGroup(coffeesGroup);
        radioButtonEspresso.setToggleGroup(coffeesGroup);

        gridPane.add(labelCoffees, 1, 0, 1, 1);
        gridPane.add(radioButtonHouseBlend, 1, 1, 1, 1);
        gridPane.add(radioButtonDarkRoast, 1, 2, 1, 1);
        gridPane.add(radioButtonDecaf, 1, 3, 1, 1);
        gridPane.add(radioButtonEspresso, 1, 4, 1, 1);

        coffeesGroup.selectedToggleProperty().addListener(e -> createBeverage());

        // Condiments in center
        gridPane.add(labelCondiments, 2, 0, 1, 1);
        gridPane.add(checkBoxMilk, 2, 1, 1, 1);
        gridPane.add(checkBoxMocha, 2, 2, 1, 1);
        gridPane.add(checkBoxSoy, 2, 3, 1, 1);
        gridPane.add(checkBoxWhip, 2, 4, 1, 1);

        checkBoxMilk.selectedProperty().addListener(e -> createBeverage());
        checkBoxMocha.selectedProperty().addListener(e -> createBeverage());
        checkBoxSoy.selectedProperty().addListener(e -> createBeverage());
        checkBoxWhip.selectedProperty().addListener(e -> createBeverage());

        // Quantity on right
        choiceBoxMilk.getItems().add("1");
        choiceBoxMilk.getItems().add("2");
        choiceBoxMilk.getItems().add("3");
        choiceBoxMocha.getItems().add("1");
        choiceBoxMocha.getItems().add("2");
        choiceBoxMocha.getItems().add("3");
        choiceBoxSoy.getItems().add("1");
        choiceBoxSoy.getItems().add("2");
        choiceBoxSoy.getItems().add("3");
        choiceBoxWhip.getItems().add("1");
        choiceBoxWhip.getItems().add("2");
        choiceBoxWhip.getItems().add("3");
        choiceBoxMilk.setValue("1");
        choiceBoxMocha.setValue("1");
        choiceBoxSoy.setValue("1");
        choiceBoxWhip.setValue("1");

        choiceBoxMilk.getSelectionModel().selectedItemProperty().addListener(e -> createBeverage());
        choiceBoxMocha.getSelectionModel().selectedItemProperty().addListener(e -> createBeverage());
        choiceBoxSoy.getSelectionModel().selectedItemProperty().addListener(e -> createBeverage());
        choiceBoxWhip.getSelectionModel().selectedItemProperty().addListener(e -> createBeverage());

        gridPane.add(labelQuantity, 3, 0, 1, 1);
        gridPane.add(choiceBoxMilk, 3, 1, 1, 1);
        gridPane.add(choiceBoxMocha, 3, 2, 1, 1);
        gridPane.add(choiceBoxSoy, 3, 3, 1, 1);
        gridPane.add(choiceBoxWhip, 3, 4, 1, 1);

        // Order Breakdown on bottom
        gridPane.add(labelOrder, 0, 5, 4, 1);
        gridPane.add(orderTextField, 0, 6, 4, 1);

        // Buttons on bottom
        addButton.setOnAction(e -> addBeverage());

        gridPane.add(addButton, 0, 7, 4, 1);

        // Table on right
        // Description Column
        descColumn.setMinWidth(300);
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        // Price Column
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tableBeverages = new TableView<>();
        tableBeverages.setItems(getBeverages());
        tableBeverages.getColumns().addAll(descColumn, priceColumn);

        gridPane.add(labelTable, 4, 0, 1, 1);
        gridPane.add(tableBeverages, 4, 1, 1, 6);

        scene = new Scene(gridPane, 1000, 200);
        window.setScene(scene);
        window.show();
    }

    /**
     * Outputs the order details to the command line.
     */
    private void printOrder()
    {
        orderTextField.setText(beverage.getDescription() + " $" + beverage.getCost());
    }

    /**
     * Takes in JavaFX inputs and outputs beverage to text area.
     */
    private void createBeverage()
    {
        // Coffees
        if (coffeesGroup.getSelectedToggle() == null)
            return;

        // Coffees
        RadioButton coffee = (RadioButton) coffeesGroup.getSelectedToggle();
        switch (coffee.getText())
        {
            case "House Blend ($0.89)":
                beverage = new HouseBlend();
                break;
            case "Dark Roast ($0.99)":
                beverage = new DarkRoast();
                break;
            case "Decaf ($1.05)":
                beverage = new Decaf();
                break;
            case "Espresso ($1.99)":
                beverage = new Espresso();
                break;
        }

        // Sizes
        RadioButton sizeSelection = (RadioButton) sizesGroup.getSelectedToggle();
        switch ((sizeSelection.getText()))
        {
            case "Tall ($0.10)":
                beverage.setSize("TALL");
                break;
            case "Grande ($0.15)":
                beverage.setSize("GRANDE");
                break;
            case "Venti ($0.20)":
                beverage.setSize("VENTI");
                break;
        }

        // Condiments
        if (checkBoxMilk.isSelected())
        {
            if (choiceBoxMilk.getValue() == null)
            {
                beverage = new Milk(beverage);
            } else
            {
                int val = Integer.parseInt(choiceBoxMilk.getSelectionModel().getSelectedItem());
                for (int i = 0; i < val; i++)
                    beverage = new Milk(beverage);
            }
        }

        if (checkBoxMocha.isSelected())
        {
            if (choiceBoxMocha.getValue() == null)
            {
                beverage = new Mocha(beverage);
            } else
            {
                int val = Integer.parseInt(choiceBoxMocha.getSelectionModel().getSelectedItem());
                for (int i = 0; i < val; i++)
                    beverage = new Mocha(beverage);
            }
        }

        if (checkBoxSoy.isSelected())
        {
            if (choiceBoxSoy.getValue() == null)
            {
                beverage = new Soy(beverage);
            } else
            {
                int val = Integer.parseInt(choiceBoxSoy.getSelectionModel().getSelectedItem());
                for (int i = 0; i < val; i++)
                    beverage = new Soy(beverage);
            }
        }

        if (checkBoxWhip.isSelected())
        {
            if (choiceBoxWhip.getValue() == null)
            {
                beverage = new Whip(beverage);
            } else
            {
                int val = Integer.parseInt(choiceBoxWhip.getSelectionModel().getSelectedItem());
                for (int i = 0; i < val; i++)
                    beverage = new Whip(beverage);
            }
        }

        printOrder();
    }

    /**
     * Adds a beverage to the observable list.
     */
    private void addBeverage()
    {
        if (beverage != null)
            beverages.add(beverage);
    }

    /**
     * Returns an observable list of beverages on the order.
     *
     * @return beverages
     */
    private ObservableList<Beverage> getBeverages()
    {
        return beverages;
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}
