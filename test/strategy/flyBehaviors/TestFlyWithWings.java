package strategy.flyBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestFlyWithWings
{
    @Test
    public void testFlyWithWings()
    {
        FlyBehavior flyWithWings = new FlyWithWings();
        assertTrue(flyWithWings instanceof FlyBehavior);
    }
}