package lesson2;

import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
       //                      Задание 2.1
        long nano_startTime = System.nanoTime();
        int[] arr1 = {1, 2, 3, 4, 5, 8, 12, 24, 33, 15, 16, 17};
        int[] arr1Copy = arr1;
        String[] dogs1 = {"Шарик", "Барс", "Рыжик", "Тузик", "Лайка"};
        Arrays.sort(arr1);
        java.util.Arrays.stream(arr1).sorted();
        arr1 = new int[15];
        Random rand = new Random();
        for (int i =0; i<15; i++){
            arr1[i] = rand.nextInt(15);
        }
        long nano_endTime = System.nanoTime() - nano_startTime;
        System.out.println("Время выполнения сравнения, нс: " + nano_endTime);
//        arr1Copy = Arrays.copyOf(arr1, arr1.length);
        System.out.println("Нет массива " + dogs1.toString());
        System.out.println(java.util.Arrays.stream(arr1).sorted());
//        System.out.println("Массивы " + Arrays.toString(arr1));
//        System.out.println("Копии массивов " + Arrays.toString(arr1Copy));
        System.out.println("Сравнение " + arr1.equals(arr1Copy));
//        System.out.println("Сравнение массивов " + Arrays.equals(arr1, arr1Copy));
//
//                      Задание 2.2
        long nano_startTime2 = System.nanoTime();
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите слово: ");
        String object = scn.nextLine();
        for (int i = 0; i < dogs1.length; i++) {
            if (dogs1[i] == object)
                System.out.print("Ваш индекс" + i);
        }
//        public static int linearSearch(int arr[], int elementToSearch) {
//            int index = linearSearch(new int[]{89, 57, 91, 47, 95, 3, 27, 22, 67, 99}, 67);
//            print(67, index);
//            for (int index = 0; index < arr.length; index++) {
//                if (arr[index] == elementToSearch)
//                    return index;
//            }
//            return -1;
//        }
//        public static void print(int elementToSearch, int index) {
//            if (index == -1){
//                System.out.println(elementToSearch + " not found.");
//            }
//            else {
//                System.out.println(elementToSearch + " found at index: " + index);
//            }
//        }
//        int key = 3;
//        int res = Arrays.elementToSearch(arr, key);
//        if (res >= 0)
//            System.out.println(key + " found at index = " + res);
//        else
//            System.out.println(key + " Not found");
        long nano_endTime2 = System.nanoTime() - nano_startTime2;
        System.out.println("Время выполнения сравнения, нс: " + nano_endTime2);

        //        Задание 2.3
        long nano_startTime3 = System.nanoTime();
        int[] arr3 = new int[400];
        int arrayLength = arr3.length;
        Random rand1 = new Random();
        Arrays.sort(arr3);
        long nano_endTime3 = System.nanoTime() - nano_startTime3;
        System.out.println("Время выполнения сравнения, нс: " + nano_endTime3);
    }

       //        Задание 2.4
       private static void sort(int[] arr3) {
           long nano_startTime4 = System.nanoTime();
           int dataLength = arr3.length;
           int swap;
           boolean sorted;
           for (int i = 0; i < dataLength; i++) {
               sorted = true;
               for (int a = 1; a < (dataLength - i); a++) {
                   if (arr3[a - 1] > arr3[a]) {
                       swap = arr3[a - 1];
                       arr3[a - 1] = arr3[a];
                       arr3[a] = swap;
                       sorted = false;
                   }
               }
               if (sorted) break;// если отсортировано, выходим, пропуская ненужный цикл.
           }
           long nano_endTime4 = System.nanoTime() - nano_startTime4;
           System.out.println("Время выполнения сравнения, нс: " + nano_endTime4);
//       System.out.println("Сравнение " + nano_endTime.equals(nano_endTime4));

           //        Задание 2.5
           long nano_startTime5 = System.nanoTime();
           int[] arr4 = {10, 2, 10, 3, 1, 2, 5};
//           System.out.println(Arrays.toString(arr4));
           for (int left = 0; left < arr4.length; left++) {
               int minInd = left;
               for (int i = left; i < arr4.length; i++) {
                   if (arr4[i] < arr4[minInd]) {
                       minInd = i;
                   }
               }
//               swap(arr4, left, minInd);
           }
//           System.out.println(Arrays.toString(arr4));
           long nano_endTime5 = System.nanoTime() - nano_startTime5;
           System.out.println("Время выполнения сравнения, нс: " + nano_endTime5);
           //       System.out.println("Сравнение " + nano_endTime.equals(nano_endTime4));

           //        Задание 2.6
           long nano_startTime6 = System.nanoTime();
           int[] arr5 = {10, 2, 10, 3, 1, 2, 5};

           for (int left = 0; left < arr5.length; left++) {
               // Вытаскиваем значение элемента
               int value = arr5[left];
               // Перемещаемся по элементам, которые перед вытащенным элементом
               int i = left - 1;
               for (; i >= 0; i--) {
                   // Если вытащили значение меньшее — передвигаем больший элемент дальше
                   if (value < arr5[i]) {
                       arr5[i + 1] = arr5[i];
                   } else {
                       // Если вытащенный элемент больше — останавливаемся
                       break;
                   }
               }
               // В освободившееся место вставляем вытащенное значение
               arr5[i + 1] = value;
           }
           System.out.println(Arrays.toString(arr5));

           long nano_endTime6 = System.nanoTime() - nano_startTime6;
           System.out.println("Время выполнения сравнения, нс: " + nano_endTime6);
           //       System.out.println("Сравнение " + nano_endTime.equals(nano_endTime6));
    }

    private static boolean toString(int[] arr5) {
        return false;
    }
}