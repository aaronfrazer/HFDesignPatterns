package factory.pizzaStores;

import factory.factories.NYPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import factory.pizzas.CheesePizza;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestNYPizzaStore
{
    @Test
    public void testCreateNYPizzaIngredientFactory()
    {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        CheesePizza cheesePizza = new CheesePizza(ingredientFactory);
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