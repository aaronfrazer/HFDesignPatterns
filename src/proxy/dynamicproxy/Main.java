package proxy.dynamicproxy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class Main extends Application
{
    HashMap<String, PersonBean> datingDB = new HashMap<>();

    private Stage window;
    private GridPane gridPane1 = new GridPane();
    private GridPane gridPane2 = new GridPane();

    private Label labelName1 = new Label("Name: ");
    private Label labelGender1 = new Label("Gender: ");
    private Label labelInterests1 = new Label("Interests: ");
    private Label labelHotOrNotRating1 = new Label("Rating: ");
    private Label labelName2 = new Label("Name: ");
    private Label labelGender2 = new Label("Gender: ");
    private Label labelInterests2 = new Label("Interests: ");
    private Label labelHotOrNotRating2 = new Label("Rating: ");

    private Button buttonNext = new Button("Next");
    private Button buttonPrevious = new Button("Previous");

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Hot or Not");
        window.setOnCloseRequest(e -> closeProgram());

        initializeDatabase();

        PersonBean joe = getPersonFromDatabase("Joe Javabean");
        PersonBean ownerProxy = getOwnerProxy(joe);
//        ownerProxy.setInterests("bowling, Go");

        PersonBean kelly = getPersonFromDatabase("Kelly Klosure");
        PersonBean nonOwnerProxy = getNonOwnerProxy(kelly);

        TextField textFieldName1 = new TextField(ownerProxy.getName());
        TextField textFieldGender1 = new TextField(ownerProxy.getGender());
        TextField textFieldInterests1 = new TextField(ownerProxy.getInterests());
        TextField textFieldHotOrNotRating1 = new TextField("" + ownerProxy.getHotOrNotRating());

        TextField textFieldName2 = new TextField(nonOwnerProxy.getName());
        TextField textFieldGender2 = new TextField(nonOwnerProxy.getGender());
        TextField textFieldInterests2 = new TextField(nonOwnerProxy.getInterests());
        TextField textFieldHotOrNotRating2 = new TextField("" + nonOwnerProxy.getHotOrNotRating());

        gridPane1.add(labelName1, 0, 0, 1, 1);
        gridPane1.add(textFieldName1, 1, 0, 1, 1);
        gridPane1.add(labelGender1, 0, 1, 1, 1);
        gridPane1.add(textFieldGender1, 1, 1, 1, 1);
        gridPane1.add(labelInterests1, 0, 2, 1, 1);
        gridPane1.add(textFieldInterests1, 1, 2, 1, 1);
        gridPane1.add(labelHotOrNotRating1, 0, 3, 1, 1);
        gridPane1.add(textFieldHotOrNotRating1, 1, 3, 1, 1);
        gridPane1.add(buttonNext, 0, 4, 2, 1);

        gridPane2.add(labelName2, 0, 0, 1, 1);
        gridPane2.add(textFieldName2, 1, 0, 1, 1);
        gridPane2.add(labelGender2, 0, 1, 1, 1);
        gridPane2.add(textFieldGender2, 1, 1, 1, 1);
        gridPane2.add(labelInterests2, 0, 2, 1, 1);
        gridPane2.add(textFieldInterests2, 1, 2, 1, 1);
        gridPane2.add(labelHotOrNotRating2, 0, 3, 1, 1);
        gridPane2.add(textFieldHotOrNotRating2, 1, 3, 1, 1);
        gridPane2.add(buttonPrevious, 0, 4, 2, 1);

        Scene scene1 = new Scene(gridPane1, 600, 400);
        Scene scene2 = new Scene(gridPane2, 600, 400);

        textFieldName1.textProperty().addListener((observable, oldValue, newValue) -> {
            try
            {
                ownerProxy.setName(newValue);
            } catch (Exception e)
            {
                System.out.println("Can't set name from owner proxy");
            }
        });

//        textFieldName2.textProperty().addListener((observable, oldValue, newValue) -> {
//
//            try {
//                    nonOwnerProxy.setName(newValue);
//                } catch (Exception e) {
//                    System.out.println("Can't set name from non-owner proxy: " + oldValue);
//                    textFieldName2.setText(oldValue);
//                    nonOwnerProxy.setName(oldValue);
//                }
//        });

        textFieldName2.setDisable(true);
        textFieldGender2.setDisable(true);
        textFieldInterests2.setDisable(true);
        textFieldHotOrNotRating2.setDisable(true);

        buttonNext.setOnAction(e -> window.setScene(scene2));
        buttonPrevious.setOnAction(e -> window.setScene(scene1));

        gridPane1.setVgap(20);
        gridPane1.setHgap(20);
        gridPane2.setVgap(20);
        gridPane2.setHgap(20);

        window.setScene(scene1);
        window.show();
    }

    private void initializeDatabase()
    {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe Javabean");
        joe.setGender("Male");
        joe.setInterests("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBean kelly = new PersonBeanImpl();
        kelly.setName("Kelly Klosure");
        kelly.setGender("Female");
        kelly.setInterests("ebay, movies, music");
        kelly.setHotOrNotRating(6);
        datingDB.put(kelly.getName(), kelly);
    }

    private PersonBean getPersonFromDatabase(String name)
    {
        return datingDB.get(name);
    }

    private PersonBean getOwnerProxy(PersonBean person)
    {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    private PersonBean getNonOwnerProxy(PersonBean person)
    {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new NonOwnerInvocationHandler(person));
    }

    /**
     * Closes the clientWindow of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}