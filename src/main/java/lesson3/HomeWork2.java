package lesson3;

public class HomeWork2 {

    public static void main(String[] args) {
        // Вычисление факториала числа n!
        System.out.println(factorial(6));
    }
    private static int factorial(int n) {
        if(n ==1) return 1;
        return n * factorial(n-1);
    }
}