# BestSeries
package series;

// Пользователь вводит числа, программа должна показывать последние 10 введенных чисел
// и 10 самых больших

import java.util.Arrays;

public class BestSeries {

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int[] arrayCopy = new int[10];
        int number = 0;

        for (int i = array.length + 10; i > 0; i--) {
            int x = getRandomNumber();
            array[array.length - 1] = x;
            number++;
            int sum = 0;
            int sum1 = 0;

            for (int j = 0; j < array.length; j++) {
                sum = sum + array[j];
            }

            for (int j = 0; j < arrayCopy.length; j++) {
                sum1 = sum1 + arrayCopy[j];
            }

            if (sum > sum1) {
                arrayCopy = array.clone();
            }

            System.out.println("Номер итерации: " + number);
            System.out.println("Последние 10 элементов: " + Arrays.toString(array));
            System.out.println("Сумма последних 10 элементов: " + sum);
            System.out.println("Наибольшая последовательность: " + Arrays.toString(arrayCopy));
            System.out.println("Наибольшая сумма элементов: " + sum1);
            System.out.println();

            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
        }
    }
}
