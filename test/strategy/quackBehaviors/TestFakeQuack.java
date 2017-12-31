package strategy.quackBehaviors;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestFakeQuack
{
    @Test
    public void testFakeQuack()
    {
        QuackBehavior fakeQuack = new FakeQuack();
        assertTrue(fakeQuack instanceof QuackBehavior);
    }
}