package factory.pizzas;

import factory.MainFactory;
import factory.factories.PizzaIngredientFactory;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class CheesePizza extends Pizza
{
    private PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory)
    {
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare()
    {
        // wait 2 seconds to simulate baking a pizza
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(0),
                e -> MainFactory.playPrepareAnimation(name)
        ));
        // stop animation
        MainFactory.timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(2000),
                e -> MainFactory.stopPrepareAnimation()
        ));

        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }

    public String getName()
    {
        return name;
    }

//    public CheesePizza()
//    {
//        name = "Cheese Pizza";
//        dough = "Regular Crust";
//        sauce = "Marinara Pizza Sauce";
//        toppings.add("Fresh Mozzarella");
//        toppings.add("Parmesan");
//    }
}
