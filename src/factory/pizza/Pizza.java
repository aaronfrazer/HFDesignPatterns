package factory.pizza;

import factory.Main;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

import java.util.ArrayList;

import static factory.Main.orderTextArea;

abstract public class Pizza
{
    String name;
    String dough;
    String sauce;
    ArrayList<String> toppings = new ArrayList<>();

    public void prepare()
    {
        // wait 5 seconds to simulate preparing a pizza
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(1000),
                e -> orderTextArea.appendText("Preparing " + name + "...\n")
        ));
    }

    public void bake()
    {
        // wait 5 seconds to simulate baking a pizza
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                e -> orderTextArea.appendText("Baking " + name + "...\n")
        ));
    }

    public void cut()
    {
        // wait 5 seconds to simulate cutting a pizza
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(3000),
                e -> orderTextArea.appendText("Cutting " + name + "...\n")
        ));
    }

    public void box()
    {
        // wait 5 seconds to simulate boxing a pizza
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4000),
                e -> orderTextArea.appendText("Boxing " + name + "...\n")
        ));
    }

    public String getName()
    {
        return name;
    }

    public String getDough()
    {
        return dough;
    }

    public String getSauce()
    {
        return sauce;
    }

    public String toString()
    {
        // code to display pizza name and ingredients
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ----\n");
        display.append(dough).append("\n");
        display.append(sauce).append("\n");
        for (String topping : toppings)
        {
            display.append(topping).append("\n");
        }
        return display.toString();
    }
}