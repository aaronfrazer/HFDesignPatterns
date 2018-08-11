package factory.pizzas;

import factory.factories.ChicagoPizzaIngredientFactory;
import factory.factories.PizzaIngredientFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCheesePizza
{
    @Test
    public void testCreateCheesePizza()
    {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        CheesePizza cheesePizza = new CheesePizza(ingredientFactory);

        cheesePizza.setName("Cheese Pizza");
        cheesePizza.prepare();

        assertEquals(cheesePizza.getName(), "Cheese Pizza");
        assertEquals(cheesePizza.getDough().toString(), "ThickCrust style extra thick crust dough");
        assertEquals(cheesePizza.getSauce().toString(), "Tomato sauce with plum tomatoes");
        assertEquals(cheesePizza.toString(),
                "---- Cheese Pizza ----\n" +
                "ThickCrust style extra thick crust dough\n" +
                "Tomato sauce with plum tomatoes\n");
    }
}