package factory.pizzaStores;

import factory.pizzas.Pizza;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestNYPizzaStore
{
    @Test
    public void testCreatePizza()
    {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();

        assertTrue(nyPizzaStore.createPizza("cheese") instanceof Pizza);
    }
}