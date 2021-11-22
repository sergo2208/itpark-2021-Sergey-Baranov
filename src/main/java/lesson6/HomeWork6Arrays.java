package lesson6;

import java.util.Scanner;

public class HomeWork6Arrays {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int n = console.nextInt();
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Math.random();
            System.out.println(array[i]);
        }
        System.out.println("Максимальное число в массиве: " + maxArray(array));
        System.out.println("Минимальное число в массиве: " + minArray(array));
        System.out.println("Среднее число в массиве: " + avgArray(array, n));
    }
    public static double maxArray(double[] array) {
        double max = array[0];
        int i = 1;
        while (i < array.length) {
            if (max < array[i]) {
                max = array[i];
            }
            i++;
        }
        return max;
    }

    public static double minArray(double[] array) {
        double min = array[0];
        int i = 1;
        while (i < array.length) {
            if (min > array[i]) {
                min = array[i];
            }
            i++;
        }
        return min;
    }

    public static double avgArray(double[] array, int n) {
        double avg = 0;
        int i = 0;
        while (i < array.length) {
            avg += array[i];
            i++;
        }
        avg = avg / n;
        return avg;
    }
}
