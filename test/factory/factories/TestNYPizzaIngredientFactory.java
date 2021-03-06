package factory.factories;

import factory.ingredients.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestNYPizzaIngredientFactory
{
    @Test
    public void testCreateIngredients()
    {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        assertTrue(ingredientFactory.createDough() instanceof Dough);
        assertTrue(ingredientFactory.createSauce() instanceof Sauce);
        assertTrue(ingredientFactory.createCheese() instanceof Cheese);
        assertTrue(ingredientFactory.createVeggies()[0] instanceof Garlic);
        assertTrue(ingredientFactory.createVeggies()[1] instanceof Onion);
        assertTrue(ingredientFactory.createVeggies()[2] instanceof Mushroom);
        assertTrue(ingredientFactory.createVeggies()[3] instanceof RedPepper);
        assertTrue(ingredientFactory.createPepperoni() instanceof Pepperoni);
        assertTrue(ingredientFactory.createClam() instanceof Clams);

    }
}