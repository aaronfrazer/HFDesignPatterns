package factory.pizzas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVeggiePizza
{
    @Test
    public void testCreateVeggiePizza()
    {
        VeggiePizza veggiePizza = new VeggiePizza();
        assertEquals(veggiePizza.getName(), "Veggie Pizza");
        assertEquals(veggiePizza.getDough(), "Crust");
        assertEquals(veggiePizza.getSauce(), "Marinara Sauce");
        assertEquals(veggiePizza.toString(),
                "---- Veggie Pizza ----\n" +
                "Crust\n" +
                "Marinara Sauce\n" +
                "Shredded Mozzarella\n" +
                "Grated Parmesan\n" +
                "Diced Onion\n" +
                "Sliced Mushrooms\n" +
                "Sliced Red Pepper\n" +
                "Sliced Black Olives\n");
    }
}