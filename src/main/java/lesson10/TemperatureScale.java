package lesson10;

public enum TemperatureScale {
    CELSIUS(1), FAHRENHEIT(2);
    public int index;

    TemperatureScale(int index) {
        this.index = index;
    }

    public static TemperatureScale as(int index) {
        for (TemperatureScale temperatureScale : values()) {
            if (temperatureScale.index == index) {
                return temperatureScale;
            }
        }
        return TemperatureScale.CELSIUS;
    }
}
