package lesson10;

public interface TemperatureConvertable {

    static double fahrenheit(double gradus) {
        return ((9 / 5.0) * gradus) + 32;
    }

    static double celsius(double gradus) {
        return (gradus - 32) * 5 / 9;
    }

    default void scaleTemperature(TemperatureScale temperatureScale) {
        switch (temperatureScale) {
            case CELSIUS -> System.out.println("Перевод из Цельсия в Фаренгейт:");
            case FAHRENHEIT -> System.out.println("Перевод из Фаренгейта в Цельсий");
        }
    }
}


