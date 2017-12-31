package strategy.duck;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestDecoyDuck
{
    @Test
    public void testDecoyDuck()
    {
        DecoyDuck decoyDuck = new DecoyDuck();
        assertTrue(decoyDuck instanceof Duck);
    }
}