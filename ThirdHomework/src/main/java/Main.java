import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        int[] arr1 = new int[] {0,1,1,1,0,0,1,0,0,1,1,0};
        for (int a = 0; a < arr1.length; a++) {
            arr1[a] = arr1[a] == 1 ? 0 : 1;
        }
        /**
        for (int a = 0; a < arr1.length; a++) {
           System.out.print(arr1[a]);
        }
         */


        // Задание 2
        int[] arr2 = new int[100];
        for (int a = 0; a < arr2.length; a++) {
            arr2[a] = a;
        }
        /**
        for (int a = 0; a < arr2.length; a++) {
            System.out.print(arr2[a]);
        }
         */


        // Задание 3
        int[] arr3 = new int[] {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int a = 0; a < arr3.length; a++) {
            arr3[a] = arr3[a] < 6 ? arr3[a] * 2 : arr3[a];
        }
        /**
        for (int a = 0; a < arr3.length; a++) {
            System.out.print(arr3[a]);
        }
         */


        // Задание 4
        int[][] arr4 = new int[25][25];
        for (int a = 0; a < arr4.length; a++) {
            for (int b = 0; b < arr4[a].length; b++) {
                arr4[a][b] = a == b ? 1 : 0;
            }
        }
        int j = arr4[0].length-1;
        for (int a = 0; a < arr4.length; a++) {
            arr4[a][j] = 1;
            j--;
        }
        /**
        for (int a = 0; a < arr4.length; a++) {
            for (int b = 0; b < arr4[a].length; b++) {
                System.out.print(arr4[a][b]);
            }
            System.out.print("\n");
        }
         */


        // Задание 5
        int[] arr5 = fillArray(100, 7);
        /**
        for (int a = 0; a < arr5.length; a++) {
            System.out.print(arr5[a]);
        }
         */


        // Задание 6
        int[] arr6 = new int[40];
        // Заполняем массив случайными числами
        for (int a = 0; a < arr6.length; a++) {
            arr6[a] = (int) (Math.random() * 201) - 100;
        }
        int max = arr6[0];
        int min = arr6[0];
        for (int a : arr6) {
            max = a > max ? a : max;
            min = a < min ? a : min;
        }
        /**
        for (int a = 0; a < arr6.length; a++) {
            System.out.print(arr6[a] + " ");
        }
        System.out.println();
        System.out.println(max);
        System.out.println(min);
         */


        // Задание 7
        int[] arr7 = new int[] {1,1,1,2,1};
        /**
        System.out.print(checkBalance(arr7));
         */


        // Задание 8
        int[] arr8 = replaceArrayValues(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14}, 1);
        /**
        for (int a = 0; a < arr8.length; a++) {
            System.out.print(arr8[a] + " ");
        }
         */
    }

    /**
     * Метод задания 5
     * @param len длина массива
     * @param initialValue заполняемое значение
     * @return Массив заполненный значением initialValue и длиной len
     */
    public static int[] fillArray(int len, int initialValue) {
        int[] a = new int[len];
        Arrays.fill(a, initialValue);
        return a;
    }

    /**
     * Метод задания 7
     * @param array массив чисел
     * @return true, если в массиве есть место, в котором сумма левой и правой части массива равны
     */
    public static boolean checkBalance(int[] array) {

        for (int c = 0; c < array.length; c++) {
            int firstValue = 0;
            int secondValue = 0;
            for (int a = 0; a < c; a++) {
                firstValue += array[a];
            }
            for (int b = c; b < array.length; b++) {
                secondValue += array[b];
            }

            if (firstValue == secondValue) {
                return true;
            }
        }

        return false;
    }

    /**
     * Метод задания 8
     * @param array массив
     * @param n число на которое надо сменить значения массива
     * @return массив со смещенными значениями
     */
    public static int[] replaceArrayValues(int[] array, int n) {

        if (n > 0) {
            for (int c = 0; c < n; c++) {
                int lastNum = array[array.length-1];

                for (int a = array.length - 1; a >= 0; a--) {
                    array[a] = a != 0 ? array[a-1] : lastNum;
                }
            }
        } else if (n < 0) {
            for (int c = 0; c > n; c--) {
                int firstNum = array[0];

                for (int a = 0; a < array.length; a++) {
                    array[a] = a != array.length-1 ? array[a+1] : firstNum;
                }
            }
        }


        return array;
    }
}
