package factory.pizzas;

import factory.factories.ChicagoPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPepperoniPizza
{
    @Test
    public void testCreatePepperoniPizza()
    {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        PepperoniPizza pepperoniPizza = new PepperoniPizza(ingredientFactory);

        pepperoniPizza.setName("Pepperoni Pizza");
        pepperoniPizza.prepare();

        assertEquals(pepperoniPizza.getName(), "Pepperoni Pizza");
        assertEquals(pepperoniPizza.getDough().toString(), "ThickCrust style extra thick crust dough");
        assertEquals(pepperoniPizza.getSauce().toString(), "Tomato sauce with plum tomatoes");
        assertEquals(pepperoniPizza.toString(),
                "---- Pepperoni Pizza ----\n" +
                        "ThickCrust style extra thick crust dough\n" +
                        "Tomato sauce with plum tomatoes\n");
    }
}