package factory.pizzas;

import factory.Main;
import factory.factories.PizzaIngredientFactory;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class ClamPizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        // wait 2 seconds to simulate baking a pizza
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                        e -> Main.playPrepareAnimation(name)
                ));
        // stop animation
        Main.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4000),
                        e -> Main.stopPrepareAnimation()
                ));

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clam = ingredientFactory.createClam();
    }

//    public ClamPizza()
//    {
//        name = "Clam Pizza";
//        dough = "Thin Crust";
//        sauce = "White Garlic Sauce";
//        toppings.add("Clams");
//        toppings.add("Grated Parmesan Cheese");
//    }
}
