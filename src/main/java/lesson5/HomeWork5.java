package lesson5;

import java.io.Serializable;
import java.util.Scanner;

public class HomeWork5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение числа n для получения значения n-ого члена последовательности Фибоначчи");
        int n = in.nextInt();
        System.out.println(n + "-й член последовательности Фибоначчи равен " + fibonacciSequence(n));
    }

    public static Serializable fibonacciSequence(int n) {
        int x0 = 0;
        int x1 = 1;
        int y = 0;
        String xn = "несуществующему значению, " +
                "т.к. в данной последовательности только положительные значения";
        if (n == 0) {
            return x0;
        } else {
            if (n == 1) {
                return x1;
            } else {
                if (n < 0) {
                    return xn;
                } else {
                    for (int z = 2; z <= n; z++) {
                        y = x0 + x1;
                        x0 = x1;
                        x1 = y;
                    }
                    return y;
                }
            }
        }
    }
}

