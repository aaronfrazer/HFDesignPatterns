package factory.pizzas;

import factory.MainFactory;
import factory.factories.PizzaIngredientFactory;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class PepperoniPizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        // wait 2 seconds to simulate baking a pizza
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                        e -> MainFactory.playPrepareAnimation(name)
                ));
        // stop animation
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(4000),
                        e -> MainFactory.stopPrepareAnimation()
                ));

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }

//    public PepperoniPizza()
//    {
//        name = "Pepperoni Pizza";
//        dough = "Crust";
//        sauce = "Marinara Sauce";
//        toppings.add("Sliced Pepperoni");
//        toppings.add("Sliced Onion");
//        toppings.add("Grated Parmesan Cheese");
//    }
}
