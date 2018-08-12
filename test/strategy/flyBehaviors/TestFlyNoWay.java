package strategy.flyBehaviors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TestFlyNoWay
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before public void setUpStreams() { System.setOut(new PrintStream(outContent)); }

    @After public void restoreStreams() { System.setOut(originalOut); }

    @Test
    public void testFlyNoWay()
    {
        FlyBehavior flyNoWay = new FlyNoWay();

        assertTrue(flyNoWay instanceof FlyBehavior);
        flyNoWay.fly();
        assertEquals("I can't fly", outContent.toString().trim());
        assertNull(flyNoWay.getFlyingImage());
    }
}