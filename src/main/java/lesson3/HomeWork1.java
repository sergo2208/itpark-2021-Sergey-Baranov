package lesson3;

public class HomeWork1 {
    public static void main(String[] args) {
        double a, b, c;
        double x1, x2;
        a = 1;
        b = 3;
        c = 5;
        double Discrimenant = b * b -4 * a * c;

        if (Discrimenant == 0) {
            x1 = (-b) / (2 * a);
            System.out.printf("x1 = x2 = %s", x1);
        } else if (Discrimenant >  0) {
            x1 = (-b + Math.sqrt(Discrimenant)) / (2 * a);
            x2 = (-b - Math.sqrt(Discrimenant)) / (2 * a);
            System.out.printf("x1 = %s, x2 = %s", x1, x2);
        } else {
            System.out.println("Нет целого числа так как дискреминант < 0");
        }
    }
}

