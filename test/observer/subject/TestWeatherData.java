package observer.subject;

import observer.observers.CurrentConditionsDisplay;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestWeatherData
{
    @Test
    public void testSetMeasurements()
    {
        WeatherData weatherData = new WeatherData();

        weatherData.setMeasurements(80, 65, 30.4f);
        assertEquals(weatherData.getTemperature(), 80, 0);
        assertEquals(weatherData.getHumidity(), 65, 0);
        assertEquals(weatherData.getPressure(), 30.4f, 0);
    }

    @Test
    public void testAddRemoveObservers()
    {
        WeatherData subject = new WeatherData();
        CurrentConditionsDisplay observer = new CurrentConditionsDisplay(subject);

        subject.registerObserver(observer);
        subject.removeObserver(observer);
    }
}