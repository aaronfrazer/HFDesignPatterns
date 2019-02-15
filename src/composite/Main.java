package composite;

import composite.menus.Menu;
import composite.menus.MenuComponent;
import composite.menus.MenuItem;
import composite.waitress.Waitress;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Main extends Application
{
    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();
    private ColumnConstraints columnConstraints = new ColumnConstraints();
    private RowConstraints rowConstraints = new RowConstraints();

    public static TreeItem<String> rootItem = new TreeItem<>();
    private static TreeView<String> tree = new TreeView<>(rootItem);

    private GridPane paneTreeView = new GridPane();
    private GridPane paneQuestionView = new GridPane();
    private GridPane paneAnswerView = new GridPane();

    private MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
    private MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
    private MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
    private MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

    private MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

    private Waitress waitress = new Waitress(allMenus);

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Objectville Diner & Pancake House");
        window.setOnCloseRequest(e -> closeProgram());

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true, 2.99));
        pancakeHouseMenu.add(new MenuItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99));
        pancakeHouseMenu.add(new MenuItem("Blueberry Pancakes", "Pancakes made with fresh blueberries, and blueberry syrup", true, 3.49));
        pancakeHouseMenu.add(new MenuItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59));
        dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99));
        dinerMenu.add(new MenuItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99));
        dinerMenu.add(new MenuItem("Soup of the day", "A bowl of the soup of the day, with a side of potato salad", false, 3.29));
        dinerMenu.add(new MenuItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05));
        dinerMenu.add(new MenuItem("Steamed Veggies and Brown Rice", "A medly of steamed vegetables over brown rice", true, 3.99));
        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
        dessertMenu.add(new MenuItem("Cheesecake", "Creamy New York cheesecake, with a chocolate graham crust", true, 1.99));
        dessertMenu.add(new MenuItem("Sorbet", "A scoop of raspberry and a scoop of lime", true, 1.89));
        cafeMenu.add(new MenuItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true, 3.99));
        cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69));
        cafeMenu.add(new MenuItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29));

        columnConstraints.setPercentWidth(100);
        rowConstraints.setPercentHeight(100);
        gridPane.getColumnConstraints().add(columnConstraints);
        paneTreeView.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        paneTreeView.getRowConstraints().add(rowConstraints);

        rootItem.setExpanded(true);

        waitress.printMenu();
        waitress.printVegetarianMenu();

        tree.setShowRoot(false);

        paneTreeView.getChildren().add(tree);

        scene = new Scene(gridPane, 800, 800);
        gridPane.add(paneTreeView, 0, 0, 1, 1);
        gridPane.add(paneQuestionView, 0, 1, 1, 1);
        gridPane.add(paneAnswerView, 0, 2, 1, 1);
        window.setScene(scene);
        window.show();
    }

    /**
     * Creates a new branch.
     * @param title  title of branch
     * @param parent parent of branch
     * @return branch
     */
    public static TreeItem<String> makeBranch(String title, TreeItem<String> parent)
    {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);

        return item;
    }

    /**
     * Closes the window of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}