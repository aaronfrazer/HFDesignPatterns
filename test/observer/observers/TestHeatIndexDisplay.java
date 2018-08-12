package observer.observers;

import observer.subject.WeatherData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestHeatIndexDisplay
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() { System.setOut(new PrintStream(outContent)); }

    @After
    public void restoreStreams() { System.setOut(originalOut); }

    @Test
    public void testUpdateHeatIndex()
    {
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(new WeatherData());
        assertEquals(heatIndexDisplay.getHeatIndex(), 0.0f, 0);

        heatIndexDisplay.update(80, 65, 30.4f);
        assertEquals(heatIndexDisplay.getHeatIndex(), 82.95535f, 0);

        heatIndexDisplay.display();
        assertEquals("Heat index is 82.95535", outContent.toString().trim());
    }
}