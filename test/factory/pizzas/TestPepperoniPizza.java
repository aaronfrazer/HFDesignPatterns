package factory.pizzas;

import factory.pizza.PepperoniPizza;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPepperoniPizza
{
    @Test
    public void testCreatePepperoniPizza()
    {
        PepperoniPizza pepperoniPizza = new PepperoniPizza();
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