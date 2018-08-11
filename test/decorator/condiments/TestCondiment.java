package decorator.condiments;

import decorator.beverages.Beverage;
import decorator.beverages.HouseBlend;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCondiment
{
    /**
     * Wrap a beverage in a condiment.
     */
    @Test
    public void testWrapBeverageInCondiments()
    {
        Beverage beverage = new HouseBlend();

        // wrap it in Mocha
        beverage = new Mocha(beverage);
        assertEquals(beverage.getCost(), 1.19, 0);
        assertEquals(beverage.getDescription(), "Tall House Blend Coffee, Mocha");

        // wrap it in a second Mocha
        beverage = new Mocha(beverage);
        assertEquals(beverage.getCost(), 1.39, 0);
        assertEquals(beverage.getDescription(), "Tall House Blend Coffee, Mocha, Mocha");

        // wrap it in a Whip
        beverage = new Whip(beverage);
        assertEquals(beverage.getCost(), 1.49, 0);
        assertEquals(beverage.getDescription(), "Tall House Blend Coffee, Mocha, Mocha, Whip");

        // wrap it in a Milk
        beverage = new Milk(beverage);
        assertEquals(beverage.getCost(), 1.59, 0);
        assertEquals(beverage.getDescription(), "Tall House Blend Coffee, Mocha, Mocha, Whip, Milk");

        // wrap it in a Soy
        beverage = new Soy(beverage);
        assertEquals(beverage.getCost(), 1.74, 0);
        assertEquals(beverage.getDescription(), "Tall House Blend Coffee, Mocha, Mocha, Whip, Milk, Soy");
    }
}