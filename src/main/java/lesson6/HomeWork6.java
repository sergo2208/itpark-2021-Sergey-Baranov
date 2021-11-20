package lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение n для определения длинны массива");
        int n = in.nextInt();
        System.out.println(Arrays.toString(arrayMy(n)));
        System.out.println("Минимальное значение в массиве равно " + minValue(n));
        System.out.println("Максимальное значение в массиве равно " + maxValue(n));
        System.out.println("Среднее значение в массиве равно " + averageValue(n));
    }
    public static int[] arrayMy(int n){
        int[] arrayMy = new int[n];
        for (int y = 0; y < arrayMy.length; y++) {
            arrayMy[y] = (int) (Math.random()*50);
        }
        return arrayMy;
    }
    public static int minValue(int n){
        int[] arrayMinMy = arrayMy(n);
        int min = arrayMinMy[0];
        for (int y : arrayMinMy) {
            min = Math.min(min, y);
        }
        return min;
    }
    public static int maxValue(int n) {
        int[] arrayMaxMy = arrayMy(n);
        int max = arrayMaxMy[0];
        for (int y : arrayMaxMy) {
            max = Math.max(max, y);
        }
        return max;
    }
    public static double averageValue(int n) {
        int[] arrayAverageMy = arrayMy(n);
        double average;
        double sum = 0;
        for (int y : arrayAverageMy) {
            sum += y;
        }
        average = sum / n;
        return average;
    }

}
