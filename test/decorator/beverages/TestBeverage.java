package decorator.beverages;

import decorator.condiments.Mocha;
import decorator.condiments.Whip;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestBeverage
{
    /**
     * Every beverage that is created is assigned a default size of TALL.
     */
    @Test
    public void testBeveragesCost()
    {
        Beverage houseBlend = new HouseBlend();
        Beverage darkRoast  = new DarkRoast();
        Beverage decaf      = new Decaf();
        Beverage espresso   = new Espresso();

        assertEquals(houseBlend.getCost(), 0.99, 0);
        assertEquals(darkRoast.getCost(), 1.09, 0);
        assertEquals(decaf.getCost(), 1.15, 0);
        assertEquals(espresso.getCost(), 2.09, 0);
    }

    @Test
    public void testBeverageDescription()
    {
        Beverage houseBlend = new HouseBlend();
        Beverage darkRoast  = new DarkRoast();
        Beverage decaf      = new Decaf();
        Beverage espresso   = new Espresso();

        assertEquals(houseBlend.getDescription(), "Tall House Blend Coffee");
        assertEquals(darkRoast.getDescription(), "Tall Dark Roast Coffee");
        assertEquals(decaf.getDescription(), "Tall Decaf Coffee");
        assertEquals(espresso.getDescription(), "Tall Espresso");
    }

    @Test
    public void testSize()
    {
        assertEquals(Beverage.Size.TALL.getName(), "Tall");
        assertEquals(Beverage.Size.TALL.getCost(), 0.10, 0);
        assertEquals(Beverage.Size.GRANDE.getName(), "Grande");
        assertEquals(Beverage.Size.GRANDE.getCost(), 0.15, 0);
        assertEquals(Beverage.Size.VENTI.getName(), "Venti");
        assertEquals(Beverage.Size.VENTI.getCost(), 0.20, 0);
    }

    @Test
    public void testBeveragesWithSize()
    {
        Beverage houseBlend = new HouseBlend();
        Beverage darkRoast  = new DarkRoast();
        Beverage decaf      = new Decaf();
        Beverage espresso   = new Espresso();

        houseBlend.setSize("GRANDE");
        assertEquals(houseBlend.getSize(), Beverage.Size.GRANDE);
        houseBlend.setSize("VENTI");
        assertEquals(houseBlend.getSize(), Beverage.Size.VENTI);
        houseBlend.setSize("TALL");
        assertEquals(houseBlend.getSize(), Beverage.Size.TALL);

        darkRoast.setSize("GRANDE");
        assertEquals(darkRoast.getSize(), Beverage.Size.GRANDE);
        darkRoast.setSize("VENTI");
        assertEquals(darkRoast.getSize(), Beverage.Size.VENTI);
        darkRoast.setSize("TALL");
        assertEquals(darkRoast.getSize(), Beverage.Size.TALL);

        decaf.setSize("GRANDE");
        assertEquals(decaf.getSize(), Beverage.Size.GRANDE);
        decaf.setSize("VENTI");
        assertEquals(decaf.getSize(), Beverage.Size.VENTI);
        decaf.setSize("TALL");
        assertEquals(decaf.getSize(), Beverage.Size.TALL);

        espresso.setSize("GRANDE");
        assertEquals(espresso.getSize(), Beverage.Size.GRANDE);
        espresso.setSize("VENTI");
        assertEquals(espresso.getSize(), Beverage.Size.VENTI);
        espresso.setSize("TALL");
        assertEquals(espresso.getSize(), Beverage.Size.TALL);
    }
}