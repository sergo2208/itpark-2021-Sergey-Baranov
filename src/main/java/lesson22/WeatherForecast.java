package lesson22;

import com.ibm.icu.text.Transliterator;

import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherForecast {

    public static void main(String[] args) throws Exception {
        System.out.println("Введите Город для вывода прогноза погоды");
        Scanner in = new Scanner(System.in);
        String str = in.next();
        var cyrillicToLatin = "Russian-Latin/BGN";
        Transliterator toLatinTrans = Transliterator.getInstance(cyrillicToLatin);
        String city = toLatinTrans.transliterate(str);
        URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=ceafa220a9f48bec14988a72100a5a33&units=metric&mode=xml");
        URL url = uri.toURL();
        URLConnection urlConnection = url.openConnection();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNextLine()) System.out.println(scanner.nextLine());
    }

}
