package reactive;

public class Forecast {

    private Location location;
    private Temperature temperature;

    public Forecast(Location location) {
        this.location = location;
    }

    public Forecast setTemperature(final Temperature t) {
        temperature = t;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Temperature getTemperature() {
        return temperature;
    }
}

