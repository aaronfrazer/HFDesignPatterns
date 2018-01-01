package observer.observers;

import observer.Main;
import observer.subject.WeatherData;

public class StatisticsDisplay implements Observer, DisplayElement
{
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData)
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure)
    {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp)
            maxTemp = temp;

        if (temp < minTemp)
            minTemp = temp;
    }

    public void display()
    {
        Main.statisticsTextArea.setText("Avg/Max/Min temperature = " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }

    public float getMaxTemp()
    {
        return maxTemp;
    }

    public float getMinTemp()
    {
        return minTemp;
    }

    public float getTempSum()
    {
        return tempSum;
    }

    public float getNumReadings()
    {
        return numReadings;
    }
}
