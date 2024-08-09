package observer.weather2;

public class UserInterface implements Observers {
    private WeatherStation ws;
    private float temperature;
    private float windSpeed;
    private float pressure;
    
    public UserInterface(WeatherStation ws) {
        this.ws = ws;
        ws.registerObserver(this);
    }

    public void display() {
        System.out.println(temperature + " " + windSpeed + " " + pressure);
    }

    @Override
    public void update(float temperature, float windSpeed, float pressure) {
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        display();
    }
    
}
