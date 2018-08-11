package factory.pizzaStores;

import factory.pizzas.Pizza;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestChicagoPizzaStore
{
    @Test
    public void testCreatePizza()
    {
        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        assertTrue(chicagoPizzaStore.createPizza("cheese") instanceof Pizza);
    }
}