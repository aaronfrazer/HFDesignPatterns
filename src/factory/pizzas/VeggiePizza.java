package factory.pizzas;

import factory.Main;
import factory.factories.PizzaIngredientFactory;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class VeggiePizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory)
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
        veggies = ingredientFactory.createVeggies();
    }

//    public VeggiePizza()
//    {
//        name = "Veggie Pizza";
//        dough = "Crust";
//        sauce = "Marinara Sauce";
//        toppings.add("Shredded Mozzarella");
//        toppings.add("Grated Parmesan");
//        toppings.add("Diced Onion");
//        toppings.add("Sliced Mushrooms");
//        toppings.add("Sliced Red Pepper");
//        toppings.add("Sliced Black Olives");
//    }
}
