package observer;

import java.util.ArrayList;

// public class WeatherStation {
//     private float temperature;
//     private float humidity;
//     private float pressure;
//     private CurrentConditionsDisplay currentConditionsDisplay;
//     private StatisticsDisplay statisticsDisplay;
//     private ForecastDisplay forecastDisplay;
//     public WeatherStation(CurrentConditionsDisplay currentConditionsDisplay, StatisticsDisplay statisticsDisplay, ForecastDisplay forecastDisplay) {
//         this.currentConditionsDisplay = currentConditionsDisplay;
//         this.statisticsDisplay = statisticsDisplay;
//         this.forecastDisplay = forecastDisplay;
//     }
//     public void measurementsChanged() {
//         currentConditionsDisplay.update(temperature, humidity, pressure);
//         statisticsDisplay.update(temperature, humidity, pressure);
//         forecastDisplay.update(temperature, humidity, pressure);
//     }
//     public void setMeasurements(float temperature, float humidity, float pressure) {
//         this.temperature = temperature;
//         this.humidity = humidity;
//         this.pressure = pressure;
//         measurementsChanged();
//     }
// }
// this code has bad smell because:
    // it is tightly coupled
    // adding or removing display elemtns requires modifying the WeatherStation class.
// we first define interface Subject and Observer
// then modify this class with Subject interface
// then implement the display elements with observers in
// CurrentConditionDisplay/Forecast/Statistic class

public class WeatherStation implements Subject {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}

// it decoupled from display elements, following thr ocp
// the observers can be added/removed at runtime -> flexible
// the WeatherStation notifies all registered observers whenever the measurements change,
// so that avoid directly calling methods to update each display elements
