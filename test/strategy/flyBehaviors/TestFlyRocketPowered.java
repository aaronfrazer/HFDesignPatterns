package strategy.flyBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestFlyRocketPowered
{
    @Test
    public void testFlyRocketPowered()
    {
        FlyBehavior flyRocketPowered = new FlyRocketPowered();

        assertTrue(flyRocketPowered instanceof FlyBehavior);
    }
}