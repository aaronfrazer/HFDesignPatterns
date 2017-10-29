package observer.subject;

import observer.Main;
import observer.observers.Observer;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WeatherData implements Subject
{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData()
    {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o)
    {
        observers.add(o);
    }

    public void removeObserver(Observer o)
    {
        int i = observers.indexOf(o);
        if (i >= 0)
        {
            observers.remove(i);
        }
    }

    public void notifyObservers()
    {
        for (Observer observer : observers)
        {
            observer.update(temperature, humidity, pressure);
        }
    }

    private void measurementsChanged()
    {
        Main.displayUpdateImage();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Main.removeUpdateImage();
        Main.weatherStationTextArea.setText(
                "Temperature: " + getTemperature() + "\n" +
                "Humidity: " + getHumidity() + "\n" +
                "Pressure: " + getPressure()
        );

        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private float getTemperature()
    {
        return temperature;
    }

    private float getHumidity()
    {
        return humidity;
    }

    private float getPressure()
    {
        return pressure;
    }
}
