package strategy.duck;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMallardDuck
{
    @Test
    public void testMallardDuck()
    {
        MallardDuck mallardDuck = new MallardDuck();
        assertTrue(mallardDuck instanceof Duck);
    }
}