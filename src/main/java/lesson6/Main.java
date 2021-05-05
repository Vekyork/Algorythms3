package lesson6;

import java.util.*;
import java.util.Arrays;
import java.util.Random;
//6.1-6.7
public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Tree theTree = new Tree();
        theTree.insert(new Person(4, "Ivan, ", 35));
        theTree.insert(new Person(2, "Mark, ", 78));
        theTree.insert(new Person(3, "Sofia, ", 24));
        theTree.insert(new Person(4, "Kirill, ", 21));
        System.out.println("Вывод максимума:");
        theTree.max().display();
        System.out.println("Вывод минимума:");
        theTree.min().display();
        System.out.println("Вывод ключа 3:");
        theTree.find(3).display();
        theTree.delete(2);
        System.out.println();
        theTree.displayTree();
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения задания, нс: " + endTime);
        //Реализация Кучи(Пирамиды)
        int[] arr;
        Random rand = new Random();
        arr = new int[10];
        for (int i = 0; i<arr.length; i++){
            arr[i]=rand.nextInt(10);
        }
        long startTime2 = System.nanoTime();
        System.out.println("Вывод неотсортированного массива" + Arrays.toString(arr));//Вывод неотсортированного массива
        HeapSort arrSort = new HeapSort();
        arrSort.sort(arr);
        System.out.println("Вывод сортированного массива" + Arrays.toString(arr));//Вывод сортированного массива
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("Время выполнения задания, нс: " + endTime2);
        System.out.println("Сравнение результатов вычислений методов: ");
        System.out.println(endTime == endTime2);
    }
}