package factory.pizzas;

import factory.factories.NYPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPepperoniPizza
{
    @Test
    public void testCreatePepperoniPizza()
    {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        PepperoniPizza pepperoniPizza = new PepperoniPizza(ingredientFactory);
        assertEquals(pepperoniPizza.getName(), "Pepperoni Pizza");
        assertEquals(pepperoniPizza.getDough(), "Crust");
        assertEquals(pepperoniPizza.getSauce(), "Marinara Sauce");
        assertEquals(pepperoniPizza.toString(),
                "---- Pepperoni Pizza ----\n" +
                "Crust\n" +
                "Marinara Sauce\n" +
                "Sliced Pepperoni\n" +
                "Sliced Onion\n" +
                "Grated Parmesan Cheese\n");
    }
}