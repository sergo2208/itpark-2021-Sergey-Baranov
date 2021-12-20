package lesson13;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

public class EmployeeUtils {
    public static void main(String[] args) {

        int employeesCount; // Кол-во сотрудников
        Scanner console = new Scanner(System.in);
        System.out.print("Введите количество сотрудников, работающих в компании: ");
        employeesCount = console.nextInt();
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < employeesCount; i++) {
            list.add(employeeRandomGenerator());
        }

        int searchWorkAge; // стаж работы, по которому выводится новый список сотрудников
        System.out.print("Укажите стаж, по которому будет сформирован новый список сотрудников: ");
        searchWorkAge = console.nextInt();
        System.out.println("Список сотрудников, стаж которых составляет в годах " + searchWorkAge + ":");

        String outName; // Переменная для хранения выводимого имени сотрудника

        ListIterator<Employee> listIter = list.listIterator(); // Создаём итератор

        // Цикл для печати списка сотрудников с заданным стажем
        while (listIter.hasNext()) {
            outName = printEmployee(listIter.next(), searchWorkAge);
            if (outName != null) {
                System.out.println(outName);
            }
        }

        System.out.println("-----------------------------");
        System.out.println("Теперь программа удалит из списка сотрудников,");
        System.out.println("стоящих на нечётных позициях, начиная с конца списка.");
        System.out.println("Было элементов в списке: " + list.size()); // это чтобы показать, что элементы действительно удаляются

        // для корректной обработки чётного числа элементов в списке
        if ((list.size() % 2) == 0) {
            listIter.previous();
            System.out.println("Теперь элементов в списке: " + list.size());
        }

        // Удаление нечётных элементов с конца списка
        while (listIter.hasPrevious()) {
            try {
                listIter.previous();
            } catch (Exception e) {
            }
            try {
                listIter.remove();
            } catch (Exception e) {
            }
            try {
                listIter.previous();
            } catch (Exception e) {
            }
            // чтобы не удалить первый (нечётный) элемент на следующем проходе цикла
            if (((list.size() * 2) - 1) == employeesCount) {
                break;
            }
            System.out.println("Теперь элементов в списке: " + list.size());
        }

        System.out.println("Стало элементов в списке: " + list.size()); // это чтобы показать, что элементы действительно удаляются
        System.out.println("Готово!");
    }

    // создание объектов сотрудников со случайными параметрами
    public static Employee employeeRandomGenerator() {
        Random random = new Random();
        Employee employee = new Employee(random.nextInt(1000), getRandomName(),
                random.nextInt(42) + 1);
        System.out.println(employee);
        return employee;
    }

    // нашел метод случайной генерации строк для вывода имени сотрудника
    public static String getRandomName() {
        Random random = new Random();
        int length = random.nextInt(15) + 5;
        String str = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(30);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static String printEmployee(Employee employees, int searchWorkAge) {
        String employeeName = employees.getName();
        if (searchWorkAge == employees.getWorkAge()) {
            return employeeName;
        }
        return null;
    }
}






