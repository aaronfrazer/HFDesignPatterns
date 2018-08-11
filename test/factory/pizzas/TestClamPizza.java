package factory.pizzas;

import factory.factories.ChicagoPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClamPizza
{
    @Test
    public void testCreateClamPizza()
    {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        ClamPizza clamPizza = new ClamPizza(ingredientFactory);

        clamPizza.setName("Clam Pizza");
        clamPizza.prepare();

        assertEquals(clamPizza.getName(), "Clam Pizza");
        assertEquals(clamPizza.getDough().toString(), "ThickCrust style extra thick crust dough");
        assertEquals(clamPizza.getSauce().toString(), "Tomato sauce with plum tomatoes");
        assertEquals(clamPizza.toString(),
                "---- Clam Pizza ----\n" +
                        "ThickCrust style extra thick crust dough\n" +
                        "Tomato sauce with plum tomatoes\n");
    }
}