package strategy.duck;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestRubberDuck
{
    @Test
    public void testRubberDuck()
    {
        RubberDuck rubberDuck = new RubberDuck();
        assertTrue(rubberDuck instanceof Duck);
    }
}