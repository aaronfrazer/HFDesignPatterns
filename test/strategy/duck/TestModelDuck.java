package strategy.duck;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestModelDuck
{
    @Test
    public void testModelDuck()
    {
        ModelDuck modelDuck = new ModelDuck();
        assertTrue(modelDuck instanceof Duck);
    }
}