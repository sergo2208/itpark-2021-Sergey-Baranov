package lesson25;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorRunner {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.divide());
        final AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext("Lesson25");
        final Calculator cal = appContext.getBean(Calculator.class);
        System.out.println(cal.divide());
    }
}
