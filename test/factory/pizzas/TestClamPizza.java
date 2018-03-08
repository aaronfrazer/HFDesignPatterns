package factory.pizzas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClamPizza
{
    @Test
    public void testCreateClamPizza()
    {
        ClamPizza clamPizza = new ClamPizza();
        assertEquals(clamPizza.getName(), "Clam Pizza");
        assertEquals(clamPizza.getDough(), "Thin Crust");
        assertEquals(clamPizza.getSauce(), "White Garlic Sauce");
        assertEquals(clamPizza.toString(),
                "---- Clam Pizza ----\n" +
                "Thin Crust\n" +
                "White Garlic Sauce\n" +
                "Clams\n" +
                "Grated Parmesan Cheese\n");
    }
}