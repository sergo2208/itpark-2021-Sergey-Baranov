package lesson10;

public class TemperatureConverter implements TemperatureConvertable {

    public static void main(String[] args) {
        double gradus = 50;
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        temperatureConverter.scaleTemperature(TemperatureScale.as(1));
        System.out.println(gradus + " градусов по Цельсию равно " + TemperatureConvertable.fahrenheit(gradus) +
                " градусов по Фаренгейту");
        temperatureConverter.scaleTemperature(TemperatureScale.as(2));
        System.out.println(gradus + " градусов по Фаренгейту равно " + TemperatureConvertable.celsius(gradus) +
                " градусов по Цельсию");
    }
}


