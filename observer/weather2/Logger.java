package observer.weather2;

public class Logger implements Observers {
    private WeatherStation ws;
    private float temperature;
    private float windSpeed;
    private float pressure;

    public Logger(WeatherStation ws) {
        this.ws = ws;
    }

    public void log() {

    }

    @Override
    public void update(float temperature, float windSpeed, float pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        log();
    }
    
}
