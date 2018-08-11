package strategy.quackBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMuteQuack
{
    @Test
    public void testMuteQuack()
    {
        QuackBehavior muteQuack = new MuteQuack();
        assertTrue(muteQuack instanceof QuackBehavior);
    }
}