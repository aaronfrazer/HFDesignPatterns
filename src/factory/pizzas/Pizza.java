package factory.pizzas;

import factory.MainFactory;
import factory.ingredients.*;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.ArrayList;

abstract public class Pizza
{
    private String style;
    String name;
    Dough dough;
    Sauce sauce;
    Veggies veggies[];
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clam;
    private ArrayList<String> toppings = new ArrayList<>();

//    public void prepare()
//    {
//        // wait 2 seconds to simulate preparing a pizza
//        MainFactory.timeline.getKeyFrames().add(
//                new KeyFrame(Duration.millis(0),
//                e -> MainFactory.playPrepareAnimation(name)
//        ));
//
//        // stop animation
//        MainFactory.timeline.getKeyFrames().add(
//                new KeyFrame(Duration.millis(2000),
//                e -> MainFactory.stopPrepareAnimation()
//        ));
//    }

    public abstract void prepare();

    public void bake()
    {
        // wait 2 seconds to simulate baking a pizza
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                e -> MainFactory.playBakeAnimation(name)
        ));

        // stop animation
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4000),
                e -> MainFactory.stopBakeAnimation()
        ));
    }

    public void cut()
    {
        // wait 2 seconds to simulate cutting a pizza
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4000),
                e -> MainFactory.playCutAnimation(name)
        ));

        // stop animation
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(6000),
                e -> MainFactory.stopCutAnimation()
        ));
    }

    public void box()
    {
        // wait 2 seconds to simulate boxing a pizza
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(6000),
                e -> MainFactory.playBoxAnimation(name)
        ));

        // stop animation
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(8000),
                e -> MainFactory.stopBoxAnimation()
        ));
    }

    public String getStyle()
    {
        return style;
    }

    public String getName()
    {
        return name;
    }

    public Dough getDough()
    {
        return dough;
    }

    public Sauce getSauce()
    {
        return sauce;
    }

    public Veggies[] getVeggies()
    {
        return veggies;
    }

    public Cheese getCheese()
    {
        return cheese;
    }

    public Pepperoni getPepperoni()
    {
        return pepperoni;
    }

    public Clams getClams()
    {
        return clam;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStyle(String style)
    {
        this.style = style;
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