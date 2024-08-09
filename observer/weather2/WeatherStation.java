package observer.weather2;

import java.util.ArrayList;

public class WeatherStation implements Subject {
    private float temperature;
    private float windSpeed;
    private float pressure;
    private ArrayList<Observers> observerses;

    public WeatherStation(float temperature, float windSpeed, float pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        observerses = new ArrayList<Observers>();
    }

    @Override
    public void registerObserver(Observers o) {
        observerses.add(o);
        notifyObservers();
    }

    @Override
    public void removeObserver(Observers o) {
        observerses.remove(o);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observers o: observerses) {
            o.update(temperature, windSpeed, pressure);
        }
    }

    public float getTemperature() {
        return temperature;
    }



    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }



    public float getWindSpeed() {
        return windSpeed;
    }



    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }



    public float getPressure() {
        return pressure;
    }



    public void setPressure(float pressure) {
        this.pressure = pressure;
    }



    public ArrayList<Observers> getObserverses() {
        return observerses;
    }



    public void setObserverses(ArrayList<Observers> observerses) {
        this.observerses = observerses;
    }

    
}
