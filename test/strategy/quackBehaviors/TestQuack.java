package strategy.quackBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestQuack
{
    @Test
    public void testQuack()
    {
        QuackBehavior quack = new Quack();
        assertTrue(quack instanceof QuackBehavior);
    }
}