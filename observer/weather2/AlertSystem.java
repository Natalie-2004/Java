package observer.weather2;

public class AlertSystem implements Observers {
    private WeatherStation ws;
    private float temperature;
    private float windSpeed;
    private float pressure;
    
    public AlertSystem(WeatherStation ws) {
        this.ws = ws;
        ws.registerObserver(this);
    }

    @Override
    public void update(float temperature, float windSpeed, float pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        alert();
    }

    public void alert() {

    }
    
}
