package observer.observers;

import observer.subject.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHeatIndexDisplay
{
    @Test
    public void testUpdateHeatIndex()
    {
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(new WeatherData());
        assertEquals(heatIndexDisplay.getHeatIndex(), 0.0f, 0);
        heatIndexDisplay.update(80, 65, 30.4f);
        assertEquals(heatIndexDisplay.getHeatIndex(), 82.95535f, 0);

    }
}