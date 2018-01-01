package observer.observers;

import observer.subject.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestForecastDisplay
{
    @Test
    public void testUpdatePressure()
    {
        ForecastDisplay forecastDisplay = new ForecastDisplay(new WeatherData());
        assertEquals(forecastDisplay.getCurrentPressure(), 29.92f, 0);
        forecastDisplay.update(80, 65, 30.4f);
        assertEquals(forecastDisplay.getLastPressure(), 29.92f, 0);
        assertEquals(forecastDisplay.getCurrentPressure(), 30.4f, 0);

    }
}