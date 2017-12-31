package strategy.quackBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSqueak
{
    @Test
    public void testSqueak()
    {
        QuackBehavior squeak = new Squeak();
        assertTrue(squeak instanceof QuackBehavior);
    }
}