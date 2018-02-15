package factory.pizzas;

import factory.pizza.CheesePizza;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCheesePizza
{
    @Test
    public void testCreateCheesePizza()
    {
        CheesePizza cheesePizza = new CheesePizza();
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