package lesson5;

import java.util.*;
//  5.1, 5.2 - Бесконечная рекурсия, 5.3 - Обычная рекурсия с условием выхода, 5.4
public class Recurse {
    public static int countdown(int n){
        System.out.println(n);
        //  5.3
        if(n==1){
            return 1;
        }
        //  5.3
        return countdown(n-1);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        //    Для рекурсии://  5.1 - 5.4
        int n = 100;
        countdown(n);
    //    5.5 Для двоичного бинарного поиска:
        int[] arr;
        Random rand = new Random();
        arr = new int[7];
        arr[0] = 6;
        arr[1] = 5;
        arr[2] = 4;
        arr[3] = 3;
        arr[4] = 1;
        arr[5] = 2;
        arr[6] = 0;
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(recBinaryFind(4, 0, arr.length-1, arr));
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения задания, нс: " + endTime);
    }
    //    5.5 Двоичный бинарный поиск:
    public static int recBinaryFind(int searchKey, int low, int high, int[] arr){
        if (low>high)
            return arr.length;
        int mid = (low+high)/2;
        if (arr[mid] == searchKey)
            return mid;
        else if (arr[mid]<searchKey)
            return recBinaryFind(searchKey,low+1, high, arr);
        else
            return recBinaryFind(searchKey, low, high-1, arr);
    }
    //    5.6 Сортировка методом выбора
    public static int[] sortMerge(int[] arr){
    int len = arr.length;//Вычисляем длину массива
    if (len<2) return arr;
    int middle = len/2;//Вычисляем середину
    return merge(sortMerge(Arrays.copyOfRange(arr, 0, middle)), sortMerge(Arrays.copyOfRange(arr, middle, len)));//Осуществляем рекурсию
    }
    public static int[] merge(int[] a, int[] b){//Сравнение двух массивов
        long startTime2 = System.nanoTime();
        int[] result = new  int[a.length + b.length];//Промежуточный результат
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; 1<result.length; i++){
            result[i] = a[aIndex]<b[bIndex] ? a[aIndex++] : b[bIndex++];//Тернарный оператор: сравнение a и b. Если a<b, то a[aIndex++], иначе: b[bIndex++]
            if (aIndex == a.length){
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);//Слияние массивов
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);//Слияние массивов
                break;
            }
        }
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("Время выполнения задания, нс: " + endTime2);
        return result;
    }
}