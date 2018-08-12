package strategy.quackBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestMuteQuack
{
    @Test
    public void testMuteQuack()
    {
        QuackBehavior muteQuack = new MuteQuack();
        muteQuack.quack();

        assertTrue(muteQuack instanceof QuackBehavior);
    }
}