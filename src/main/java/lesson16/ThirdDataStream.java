package lesson16;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ThirdDataStream extends Thread {


    public ThirdDataStream() {

    }

    Logger loggerMain3 = new Logger(" Сообщение 3-го потока");


    @Override
    public void run() {
        Thread.currentThread().setName("3rd Thread");

        // Вывода информации в файл
        for (long i = 0; i < 60000; ) {
            long gotSleepTime = sleepTime(); // переменная для рандомного сна
            //System.out.println("Прошло милисекунд: " + i);
            System.out.println("Статус " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
            System.out.println(loggerMain3.getMESSAGE());
            System.out.println("Время: " + getTime());

            // Вывод в файл
            try (FileWriter writer = new FileWriter("logThread.txt", true)) {
                writer.write("Статус " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState() + " ");
                writer.write(loggerMain3.getMESSAGE() + " ");
                writer.write("Время: " + getTime() + " ");
                //writer.write(text);
                writer.flush();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

            try {
                sleep(gotSleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i = i + gotSleepTime;
        }

        // Стоп потока:
        Thread.currentThread().interrupt();

    }

    private static long sleepTime() {
        Random random = new Random();
        return random.nextLong(3000);
    }

    // Получение времени.
    public static String getTime() {
        return String.valueOf(java.time.LocalDateTime.now());
    }
}
