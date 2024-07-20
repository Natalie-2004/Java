package observer.weather;

class ForecastDisplay implements Observer {
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Forecast: " + pressure + " pressure");
    }
}