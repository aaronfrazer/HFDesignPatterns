package strategy.duck;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRedHeadDuck
{
    @Test
    public void testRedHeadDuck()
    {
        RedHeadDuck redHeadDuck = new RedHeadDuck();
        assertTrue(redHeadDuck instanceof Duck);
    }
}