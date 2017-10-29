package observer.observers;

import observer.Main;
import observer.subject.WeatherData;

public class ForecastDisplay implements Observer, DisplayElement
{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData)
    {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure)
    {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }

    public void display()
    {
        Main.forecastTextArea.setText("Forecast: ");
        if (currentPressure > lastPressure)
        {
            Main.forecastTextArea.appendText("Improving weather on the way!");
        } else if (currentPressure == lastPressure)
        {
            Main.forecastTextArea.appendText("More of the same");
        } else if (currentPressure < lastPressure)
        {
            Main.forecastTextArea.appendText("Watch out for cooler, rainy weather");
        }
    }
}
