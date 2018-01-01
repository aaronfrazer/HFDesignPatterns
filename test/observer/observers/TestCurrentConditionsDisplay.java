package observer.observers;

import observer.observers.CurrentConditionsDisplay;
import observer.subject.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCurrentConditionsDisplay
{
    @Test
    public void testUpdateTemperatureAndHumidity()
    {
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(new WeatherData());

        currentConditionsDisplay.update(80, 65, 30.4f);
        assertEquals(currentConditionsDisplay.getTemperature(), 80, 0);
        assertEquals(currentConditionsDisplay.getHumidity(), 65, 0);
    }
}