package lesson16;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Printer extends Thread {

    public Printer() {
    }

    @Override
    public void run() {
        printFile();
    }

    public static void printFile() {

        System.out.println("Выводим файл в консоль");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("logThread.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            assert in != null;
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (line != null) {
            System.out.println(line);
            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
