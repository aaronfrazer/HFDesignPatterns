package factory.pizzas;

import factory.factories.ChicagoPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVeggiePizza
{
    @Test
    public void testCreateVeggiePizza()
    {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        VeggiePizza veggiePizza = new VeggiePizza(ingredientFactory);

        veggiePizza.setName("Veggie Pizza");
        veggiePizza.prepare();

        assertEquals(veggiePizza.getName(), "Veggie Pizza");
        assertEquals(veggiePizza.getDough().toString(), "ThickCrust style extra thick crust dough");
        assertEquals(veggiePizza.getSauce().toString(), "Tomato sauce with plum tomatoes");
        assertEquals(veggiePizza.toString(),
                "---- Veggie Pizza ----\n" +
                        "ThickCrust style extra thick crust dough\n" +
                        "Tomato sauce with plum tomatoes\n");
    }
}