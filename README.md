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
        int[] array = new int[11];

        for (int i = array.length + 10; i > 0; i--) {
            int x = getRandomNumber();
            array[array.length - 1] = x;
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

IN THE WORK
