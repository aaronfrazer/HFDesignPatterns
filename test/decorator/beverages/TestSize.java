package decorator.beverages;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSize
{
    @Test
    public void testSize()
    {
        assertEquals(Size.TALL.getName(), "Tall");
        assertEquals(Size.TALL.getCost(), 0.10, 0);
        assertEquals(Size.GRANDE.getName(), "Grande");
        assertEquals(Size.GRANDE.getCost(), 0.15, 0);
        assertEquals(Size.VENTI.getName(), "Venti");
        assertEquals(Size.VENTI.getCost(), 0.20, 0);
    }
}