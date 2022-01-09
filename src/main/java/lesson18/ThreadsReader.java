package lesson18;

import java.io.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThreadsReader {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // основной код для работы с файлом, обёрнутый в отдельный поток
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                File file = new File("src/main/resources/lesson18.txt");
                //создаем объект FileReader для объекта File
                FileReader fr = new FileReader(file);
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();

                // Создадим переменную для инкремента имён файлов
                int fileName = 1;

                while (line != null) {
                    // Это чисто для себя, для контроля, что строки выводятся. Можно закомментить строку кода ниже:
                    System.out.println("Запись строки: " + line);

                    // Сконвертируем переменную в строку:
                    String nameIncrement = intToString(fileName);

                    // Запишем в файл считанную строку
                    try (FileWriter writer = new FileWriter("src/main/resources/file" + nameIncrement + ".txt", true)) {
                        writer.write(line);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    // считываем остальные строки в цикле
                    line = reader.readLine();
                    fileName++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // Вывод результатов вычислений:
        future.get();

    }

    // Метод для преобразования числа в строку для имени файла
    public static String intToString(int nameInc) {
        return Integer.toString(nameInc);
    }


}