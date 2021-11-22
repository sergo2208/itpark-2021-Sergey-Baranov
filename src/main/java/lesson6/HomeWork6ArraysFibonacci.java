package lesson6;

import java.util.Scanner;

public class HomeWork6ArraysFibonacci {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Введите целое положительное число индекса n менее 92");
        //Последовательность Фибоначчи только положительные числа.
        //Тип long имеет свои границы.
        System.out.print("для расчёта значения его числа Фибоначчи: ");
        int n = console.nextInt();

        // Проверка n на корректность
        for (; n < 0 || n > 91; ) {
            System.out.print("Введите корректное число n (см. выше): ");
            n = console.nextInt();
        }

        long[] fibArray = new long[92];
        for (int i = 1; i <= 92; i++) {
            fibArray[i - 1] = fibonacciCalculate(i);

        }
        // При n <=50 на печать выводится число Фибоначчи из массива.
        // При 50 < n < 91, число Фибоначчи рассчитывается через метод и выводится на экран.
        if (n > 50 & n < 91) {
            long i = n;
            System.out.println("Для числа n = " + n + " число Фибоначчи = " + fibonacciCalculate(i));

        } else {
            System.out.println("Для числа n = " + n + " число Фибоначчи = " + fibArray[n]);
        }
    }

    public static long fibonacciCalculate(long i) {
        long fN = 0;
        // Проверки для n == 1; 2; 3
        if (i == 1) {
            fN = 0;
            return fN;

        }

        if (i == 2) {
            fN = 1;
            return fN;
        }

        if (i == 3) {
            fN = 1;
            return fN;
        }

        for (long fN2 = 0, fN1 = 1, slipperyN = 3; slipperyN <= i; slipperyN++) {
            fN = fN1 + fN2;
            fN2 = fN1;
            fN1 = fN;

            if (slipperyN == i) {
                return fN;
            }
        }
        return fN;
    }
}

