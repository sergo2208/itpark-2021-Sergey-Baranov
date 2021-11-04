package lesson2;

public class HomeWork1 {
    public static void main(String[] args){
        System.out.println(addition(5,7));
        System.out.println(subtraction(16,15));
        System.out.println(multiplication(0,10));
        System.out.println(division(16,2));
    }

    public static int addition(int x, int y){
        return x + y;
    }
    public static int subtraction(int x, int y){
        return x - y;
    }
    public static int multiplication(int x, int y){
        return x * y;
    }
    public static double division(double x, double y){
        return x / y;
    }
}
