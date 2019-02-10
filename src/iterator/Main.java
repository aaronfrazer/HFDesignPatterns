package iterator;

import iterator.menus.CafeMenu;
import iterator.menus.DinerMenu;
import iterator.menus.PancakeHouseMenu;
import iterator.waitress.Waitress;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class Main extends Application
{
	private Stage window;
	private Scene scene;
	private GridPane gridPane = new GridPane();
	private ColumnConstraints columnConstraints = new ColumnConstraints();
	private RowConstraints rowConstraints = new RowConstraints();

	private TreeView<String> tree;
	public static TreeItem<String> rootItem;

	private Label labelFirstQuestion = new Label("Customer asks, is the ");
	private Label labelSecondQuestion = new Label(" vegetarian? ");
	private Label labelAnswer = new Label();
	private ChoiceBox<String> choiceBoxMenuItem = new ChoiceBox<>();

	private GridPane paneTreeView = new GridPane();
	private GridPane paneQuestionView = new GridPane();
	private GridPane paneAnswerView = new GridPane();

	private PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
	private DinerMenu dinerMenu = new DinerMenu();
	private CafeMenu cafeMenu = new CafeMenu();

	private Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu, cafeMenu);

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

		columnConstraints.setPercentWidth(100);
		rowConstraints.setPercentHeight(90);
		gridPane.getColumnConstraints().add(columnConstraints);
		paneTreeView.getColumnConstraints().add(columnConstraints);
		gridPane.getRowConstraints().add(rowConstraints);
		paneTreeView.getRowConstraints().add(rowConstraints);

		rootItem = new TreeItem<>();
		rootItem.setExpanded(true);

		waitress.printMenu();
		waitress.printVegetarianMenu();

		tree = new TreeView<>(rootItem);
		tree.setShowRoot(false);

		for(String itemName : waitress.getMenuItemNames())
			choiceBoxMenuItem.getItems().add(itemName);

		choiceBoxMenuItem.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			if (waitress.isItemVegetarian(newValue))
			{
				labelAnswer.setText("Yes");
				labelAnswer.setTextFill(Color.GREEN);
			} else
			{
				labelAnswer.setText("No");
				labelAnswer.setTextFill(Color.RED);
			}
		});

		paneTreeView.getChildren().add(tree);
		paneQuestionView.add(labelFirstQuestion, 0, 0, 1, 1);
		paneQuestionView.add(choiceBoxMenuItem, 1, 0, 1, 1);
		paneQuestionView.add(labelSecondQuestion, 2, 0, 1, 1);
		paneQuestionView.add(labelAnswer, 3, 0, 1, 1);

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