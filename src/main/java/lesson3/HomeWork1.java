package lesson3;

public class HomeWork1 {
    public static void main(String[] args) {
        double a, b, c;
        double x1, x2;
        a = 2;
        b = 4;
        c = 2;
        double discrimenant = b * b -4 * a * c;
        if (discrimenant == 0) {
            x1 = (-b) / (2 * a);
            System.out.printf("x = %s", x1);
        } else if (discrimenant >  0) {
            x1 = (-b + Math.sqrt(discrimenant)) / (2 * a);
            x2 = (-b - Math.sqrt(discrimenant)) / (2 * a);
            System.out.printf("x1 = %s x2 = %s", x1, x2);
        } else {
            System.out.println("Нет действительных решений уравнения");
        }
    }
}

