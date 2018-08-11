package factory.factories;

import factory.ingredients.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestChicagoPizzaIngredientFactory
{
    @Test
    public void testCreateIngredients()
    {
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        assertTrue(ingredientFactory.createDough() instanceof Dough);
        assertTrue(ingredientFactory.createSauce() instanceof Sauce);
        assertTrue(ingredientFactory.createCheese() instanceof Cheese);
        assertTrue(ingredientFactory.createVeggies()[0] instanceof BlackOlives);
        assertTrue(ingredientFactory.createVeggies()[1] instanceof Spinach);
        assertTrue(ingredientFactory.createVeggies()[2] instanceof Eggplant);
        assertTrue(ingredientFactory.createPepperoni() instanceof Pepperoni);
        assertTrue(ingredientFactory.createClam() instanceof Clams);

    }
}