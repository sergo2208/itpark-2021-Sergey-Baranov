package lesson4;

public class HomeWork4{
    public static void main(String[] args) {
        System.out.println("Квадратный корень числа n = " + squareRoot(64));
    }

    public static int squareRoot(int n) {
        int b = 1;
        while (b * b != n) {
            b++;
        }
        return b;
    }
}
