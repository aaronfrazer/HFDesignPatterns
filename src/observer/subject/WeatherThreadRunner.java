package observer.subject;

import observer.Main;
import observer.observers.CurrentConditionsDisplay;
import observer.observers.ForecastDisplay;
import observer.observers.StatisticsDisplay;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WeatherThreadRunner implements Runnable
{
    private volatile boolean running = true;

    public void terminate()
    {
        running = false;
    }

    @Override
    public void run()
    {
        Main.weatherData = new WeatherData();
        Main.currentDisplay = new CurrentConditionsDisplay(Main.weatherData);
        Main.statisticsDisplay = new StatisticsDisplay(Main.weatherData);
        Main.forecastDisplay = new ForecastDisplay(Main.weatherData);

//        Main.weatherData.setMeasurements(80, 65, 30.4f);
//        Main.weatherData.setMeasurements(82, 70, 29.2f);
//        Main.weatherData.setMeasurements(78, 90, 29.2f);

        while (running)
        {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setMeasurements();
        }
    }

    private void setMeasurements()
    {
        Random rand = new Random();

        // Temperature (78 - 82)
        float tempurature = rand.nextFloat() * (82f - 78f) + 78f;
        // Humidity (65 - 90)
        float humidity = rand.nextFloat() * (90f - 65f) + 65f;
        // Pressure (28 - 32)
        float pressure = rand.nextFloat() * (32f - 28f) + 28f;

        Main.weatherData.setMeasurements(tempurature, humidity, pressure);
        Main.weatherData.measurementsChanged();
    }
}
