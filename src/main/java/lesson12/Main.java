package lesson12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        Scanner console = new Scanner(System.in);
        System.out.print("Укажите количество строк массива: ");
        int i = console.nextInt();
        System.out.print("Укажите количество столбцов массива: ");
        int j = console.nextInt();

        String[][] array = new String[i][j];

        for (int i1 = 0; i1 < i; i1++) {
            for (int j1 = 0; j1 < i; j1++) {
                System.out.print("Введите число в строку " + i1 + ", столбец " + j1 + ": ");
                array[i1][j1] = console.next();
            }
        }

        int summ = arraySumm(array);
        System.out.println("Сумма элементов массива: " + summ);
    }

    private static int arraySumm(String[][] array) throws MyArrayDataException {
        int i = array.length;
        int j = array[0].length;
        try {
            if (i != 4 || j != 4) {
                throw new MyArraySizeException("Количество строк и/или столбцов отлично от 4!");
            }
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        }

        int summ = 0;

        for (int iA = 0; iA < i; iA++) {
            for (int jA = 0; jA < i; jA++) {
                if (isNumber(array[iA][jA])) {
                    summ += Integer.parseInt(array[iA][jA]);
                } else {
                    throw new MyArrayDataException("Не число: строка " + iA + " , столбец " + jA);
                }
            }
        }
        return summ;

    }

    private static boolean isNumber(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
