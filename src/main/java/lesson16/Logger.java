package lesson16;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    public String MESSAGE;

    public String getMESSAGE() {
        return MESSAGE;
    }

    public Logger(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public static void main(String[] args) throws InterruptedException {

        // Не могу добавить логирование


        FirstDataStream thread1 = new FirstDataStream();
        SecondDataStream thread2 = new SecondDataStream();
        ThirdDataStream thread3 = new ThirdDataStream();

        // очистка файла
        try (FileWriter writer = new FileWriter("logThread.txt", false)) {
            String text = "";
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Запуск потоков
        threadStarter(thread1);
        threadStarter(thread2);
        threadStarter(thread3);

        // Создаём поток, который ниже ждёт завершения первых трёх потоков, затем активируется и выводит файл на печать
        Printer threadPrinter = new Printer();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPrinter.start();
    }

    // метод, вкотором запускаются потоки
    public static synchronized void threadStarter(Thread thread) throws InterruptedException {
        thread.join();
        thread.start();
    }


}
