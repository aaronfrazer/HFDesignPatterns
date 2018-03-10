package factory.pizzas;

import factory.factories.NYPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import factory.ingredients.Dough;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestClamPizza
{
    @Test
    public void testCreateClamPizza()
    {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        ClamPizza clamPizza = new ClamPizza(ingredientFactory);
        assertEquals(clamPizza.getName(), "Clam Pizza");
        assertTrue(clamPizza.getDough() instanceof Dough);
        assertEquals(clamPizza.getSauce(), "White Garlic Sauce");
        assertEquals(clamPizza.toString(),
                "---- Clam Pizza ----\n" +
                "Thin Crust\n" +
                "White Garlic Sauce\n" +
                "Clams\n" +
                "Grated Parmesan Cheese\n");
    }
}