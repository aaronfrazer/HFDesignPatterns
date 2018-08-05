package singleton.chocolate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestChocolateBoiler
{
    @Test
    public void testAGetInstance()
    {
        ChocolateBoiler boiler1 = ChocolateBoiler.getInstance();
        ChocolateBoiler boiler2 = ChocolateBoiler.getInstance();

        assertEquals(boiler1, boiler2); // two instances should be the same
    }

    @Test
    public void testBFill()
    {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());

        // Fill
        boiler.fill();
        assertFalse(boiler.isEmpty());
        assertFalse(boiler.isBoiled());

        // Fill Fill
        boiler.fill();
        assertFalse(boiler.isEmpty());
        assertFalse(boiler.isBoiled());

        // Fill Drain
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 0); // empty and not boiled

        // Fill Boil Drain
        boiler.fill();
        boiler.boil();
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 1);
    }

    @Test
    public void testCBoil()
    {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        // Boil
        boiler.boil();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());

        // Fill Boil
        boiler.fill();
        boiler.boil();
        assertFalse(boiler.isEmpty());
        assertTrue(boiler.isBoiled());

        // Boil Boil
        boiler.boil();
        assertFalse(boiler.isEmpty());
        assertTrue(boiler.isBoiled());

        // Fill Boil Drain
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 2);
    }

    @Test
    public void testDDrain()
    {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();

        // Drain Drain
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 2);

        // Fill Boil Drain
        boiler.fill();
        boiler.boil();
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 3);

        // Drain Drain
        boiler.drain();
        assertTrue(boiler.isEmpty());
        assertFalse(boiler.isBoiled());
        assertEquals(boiler.getNumChocolateBoiled(), 3);
    }
}