package strategy.flyBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestFlyNoWay
{
    @Test
    public void testFlyNoWay()
    {
        FlyBehavior flyNoWay = new FlyNoWay();
        assertTrue(flyNoWay instanceof FlyBehavior);
    }
}