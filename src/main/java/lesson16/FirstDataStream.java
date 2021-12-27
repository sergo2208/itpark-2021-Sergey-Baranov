package lesson16;

import java.io.*;
import java.util.Random;

public class FirstDataStream extends Thread {


    public FirstDataStream() {

    }

    Logger loggerMain1 = new Logger(" Сообщение 1-го потока");


    @Override
    public void run() {
        Thread.currentThread().setName("1st Thread");

        //  Вывод информации в файл
        for (long i = 0; i < 60000; ) {
            long gotSleepTime = sleepTime(); // переменная для рандомного сна
            //System.out.println("Прошло милисекунд: " + i);
            System.out.println("Статус " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
            System.out.println(loggerMain1.getMESSAGE());
            System.out.println("Время: " + getTime());

            // вывод в файл
            try (FileWriter writer = new FileWriter("logThread.txt", true)) {
                writer.write("Статус " + Thread.currentThread().getName() + ": " + Thread.currentThread().getState() + " ");
                writer.write(loggerMain1.getMESSAGE() + " ");
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

    // получения времени.
    public static String getTime() {
        return String.valueOf(java.time.LocalDateTime.now());
    }
}
