import java.util.Arrays;

public class HomeWork05 {
    public static void main(String[] args) {
        HomeWork05 homeWork05 = new HomeWork05();

        System.out.println(homeWork05.task1());

        homeWork05.task2();

        System.out.println(homeWork05.task3());

        System.out.println(homeWork05.task4(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(homeWork05.task4(new int[]{1, 2, 3, 1, 5, 4, 3, 2, 1, 2}));
        System.out.println(homeWork05.task4(new int[]{23, 2, 42, 2, 33, 22, 99, 33, 23, 2}));
        System.out.println(homeWork05.task4(new int[]{5, 2, 3, 3, 1, 4, 5, 2, 2, 2}));

        homeWork05.task5();

        homeWork05.task6(5);
        homeWork05.task6(6);
        homeWork05.task6(9);
        homeWork05.task6(4);
    }

    /*
    —оздайте переменную дл€ массива из 10 элементов.
    «аполните его произвольными значени€ми целочисленного
    типа и выведите последний элемент массива на экран.
     */
    public int task1() {
        int[] ten = new int[10];
        for (int i = 0; i < 10; i++) {
            ten[i] = (int) (Math.random() * 20);
        }
        return ten[9];
    }

    /*
    —оздайте переменную дл€ массива из 10 элементов (другим способом).
    «аполните его произвольными значени€ми целочисленного типа и выведите
    на экран элементы, сто€щие на четных позици€х.
     */
    public void task2() {
        int[] mass = {10, 13, 19, 28, 1, 23, 35, 94, 78, 46};
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print(mass[i] + " ");
            }
        }
        System.out.println();
    }

    /*
    —оздайте переменную дл€ массива из 10 элементов.
    «аполните его произвольными значени€ми целочисленного типа.
    Ќайдите максимальный элемент и выведите его индекс.
     */
    public int task3() {
        int[] mass3 = new int[10];
        for (int i = 0; i < 10; i++) {
            mass3[i] = (int) (Math.random() * 20);
        }
        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, mass3[i]);
        }
        return max;
    }

    /*
    —оздайте переменную дл€ массива из 10 элементов.
    «аполните его произвольными значени€ми целочисленного типа.
    ќпределите сумму элементов массива, расположенных между минимальным и максимальным значени€ми.
    ≈сли значений максимальных и минимальных несколько, то необходимо вз€ть максимальное
    значение разницы индексов между максимальным и минимальным значени€ми.
     */
    public int task4(int[] mass4) {
        int max = mass4[0];
        int min = mass4[0];
        for (int j : mass4) {
            if (max < j) {
                max = j;
            }
            if (min > j) {
                min = j;
            }
        }
        int[] max_indexes = new int[mass4.length];
        int[] min_indexes = new int[mass4.length];
        int max_inx = 0;
        int min_inx = 0;
        for (int i = 0; i < mass4.length; i++) {
            if (mass4[i] == max) {
                max_indexes[max_inx] = i;
                max_inx++;
            }
            if (mass4[i] == min) {
                min_indexes[min_inx] = i;
                min_inx++;
            }
        }
        int len = 0;
        int index_max = 0;
        int index_min = 0;
        for (int i = 0; i < max_inx; i++) {
            for (int j = 0; j < min_inx; j++) {
                int abs = Math.abs(max_indexes[i] - min_indexes[j]);
                if (len < abs) {
                    len = abs;
                    index_max = max_indexes[i];
                    index_min = min_indexes[j];
                }
            }
        }
        int sum = 0;
        for (int i = Math.min(index_max, index_min); i <= Math.max(index_max, index_min); i++) {
            sum += mass4[i];
        }
        return sum;
    }

    /*
    —оздайте переменную дл€ массива из 10 элементов.
    «аполните его произвольными значени€ми целочисленного типа.
    ¬ыведите на экран, переверните и снова выведите на экран
    (при переворачивании нежелательно создавать еще один массив).
     */
    public void task5() {
        int[] mass5 = new int[10];
        for (int i = 0; i < 10; i++) {
            mass5[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(mass5));
        System.out.print("[");
        for (int i = mass5.length - 1; i >= 0; i--) {
            System.out.print(mass5[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /*
    —оздать двухмерный квадратный массив и заполнить его Ђбабочкойї,, то есть таким образом:
     1 1 1 1 1
     0 1 1 1 0
     0 0 1 0 0
     0 1 1 1 0
     1 1 1 1 1
    */
    public void task6(int n) {
        int[][] mass6 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j && n - j > i || n - j - 1 <= i && n - j >= n - i) {
                    mass6[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mass6[i][j] + " ");
            }
            System.out.println();
        }
    }
}