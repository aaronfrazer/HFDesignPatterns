package observer.observers;

import observer.subject.WeatherData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStatisticsDisplay
{
    @Test
    public void testUpdateTemperatureReadings()
    {
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(new WeatherData());

        assertEquals(statisticsDisplay.getMaxTemp(), 0.0f, 0);
        assertEquals(statisticsDisplay.getMinTemp(), 200f, 0);
        assertEquals(statisticsDisplay.getTempSum(), 0.0f, 0);
        assertEquals(statisticsDisplay.getNumReadings(), 0, 0);

        statisticsDisplay.update(80, 65, 30.4f);

        assertEquals(statisticsDisplay.getMaxTemp(), 80f, 0);
        assertEquals(statisticsDisplay.getMinTemp(), 80f, 0);
        assertEquals(statisticsDisplay.getTempSum(), 80f, 0);
        assertEquals(statisticsDisplay.getNumReadings(), 1, 0);

        statisticsDisplay.update(82, 70, 29.2f);

        assertEquals(statisticsDisplay.getMaxTemp(), 82f, 0);
        assertEquals(statisticsDisplay.getMinTemp(), 80f, 0);
        assertEquals(statisticsDisplay.getTempSum(), 162f, 0);
        assertEquals(statisticsDisplay.getNumReadings(), 2, 0);

        statisticsDisplay.update(78, 90, 29.2f);

        assertEquals(statisticsDisplay.getMaxTemp(), 82f, 0);
        assertEquals(statisticsDisplay.getMinTemp(), 78f, 0);
        assertEquals(statisticsDisplay.getTempSum(), 240f, 0);
        assertEquals(statisticsDisplay.getNumReadings(), 3, 0);
    }
}