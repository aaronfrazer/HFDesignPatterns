package factory.pizzas;

import factory.factories.NYPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCheesePizza
{
    @Test
    public void testCreateCheesePizza()
    {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        CheesePizza cheesePizza = new CheesePizza(ingredientFactory);

        cheesePizza.setName("Cheese Pizza");
        cheesePizza.prepare();

        assertEquals(cheesePizza.getName(), "Cheese Pizza");
        assertEquals(cheesePizza.getDough(), "Regular Crust");
        assertEquals(cheesePizza.getSauce(), "Marinara Pizza Sauce");
        assertEquals(cheesePizza.toString(),
                "---- Cheese Pizza ----\n" +
                "Regular Crust\n" +
                "Marinara Pizza Sauce\n" +
                "Fresh Mozzarella\n" +
                "Parmesan\n");
    }
}