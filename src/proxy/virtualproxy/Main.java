package proxy.virtualproxy;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Hashtable;

public class Main extends Application
{
    private Hashtable<String, String> cds = new Hashtable<>();

    private Stage window;
    private Scene scene;
    private GridPane gridPane = new GridPane();

    private static Image image = new Image("http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
    protected static ImageView imageView = new ImageView(image);

    private ChoiceBox choiceBoxImage = new ChoiceBox();

    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("CD Cover Viewer");
        window.setOnCloseRequest(e -> closeProgram());

        cds.put("Buddha Bar", "http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
        cds.put("Ima", "http://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
        cds.put("Karma", "http://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
        cds.put("MCMXC A.D.", "http://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
        cds.put("Northern Exposure", "http://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
        cds.put("Selected Ambient Works, Vol. 2", "http://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");

        cds.forEach((k, v) -> choiceBoxImage.getItems().add(k));

        choiceBoxImage.setValue("Selected Ambient Works, Vol. 2");

        choiceBoxImage.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) ->
            cds.forEach((key, value) -> {
                if (newValue == key)
                    ImageProxy.paintIcon(value);
        }));

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);
        gridPane.add(imageView, 0, 0, 1, 1);
        gridPane.add(choiceBoxImage, 0, 1, 1, 1);

        scene = new Scene(gridPane, 600, 600);
        window.setScene(scene);
        window.show();
    }

    /**
     * Closes the clientWindow of the program.
     */
    private void closeProgram()
    {
        window.close();
    }
}