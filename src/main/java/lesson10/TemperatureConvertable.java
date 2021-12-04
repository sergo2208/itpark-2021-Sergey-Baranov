package lesson10;

public interface TemperatureConvertable {

    static double fahrenheit(double gradus) {
        double fahrehheit = ((9 / 5.0) * gradus) + 32;
        return fahrehheit;
    }

    static double celsius(double gradus) {
        double celsius = (gradus - 32) * 5 / 9;
        return celsius;
    }

    default void scaleTemperature(TemperatureScale temperatureScale) {
        String result;
        switch (temperatureScale) {
            case CELSIUS -> {
                System.out.println("Перевод из Цельсия в Фаренгейт:");
            }
            case FAHRENHEIT -> {
                System.out.println("Перевод из Фаренгейта в Цельсий");
            }
        }
    }
}


