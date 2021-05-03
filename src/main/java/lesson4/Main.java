package lesson4;

import java.util.*;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        Задание 4.1
        long startTime = System.nanoTime();
        Stack<ArObj> stObj = new Stack<>();
        stObj.push(new ArObj(1, 1));
        stObj.push(new ArObj(2, 2));
        stObj.push(new ArObj(3, 3));
        stObj.push(new ArObj(4, 4));

        stObj.peek().print();
        while (!stObj.empty()){
            stObj.pop().print();
        }
        System.out.println(stObj.empty());
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения задания 4.1, нс: " + endTime);
        //        Задание 4.2
        long startTime2 = System.nanoTime();
        StackM stack = new StackM(5);
        Random rand = new Random();
        while (!stack.isFull())
            stack.push(rand.nextInt(10));
        while (!stack.isEmpty())
            System.out.println(stack.pop());
        long endTime2 = System.nanoTime() - startTime2;
        System.out.println("Время выполнения задания 4.2, нс: " + endTime2);
        //        Задание 4.3
        long startTime3 = System.nanoTime();
        Deque<ArObj>quObj = new ArrayDeque<>();
        quObj.add(new ArObj(5, 5));
        quObj.add(new ArObj(6, 6));
        quObj.add(new ArObj(7, 7));
        quObj.addFirst(new ArObj(4,4));
        quObj.addLast(new ArObj(8,8));
        while (!quObj.isEmpty())
            quObj.poll().print();
        quObj.add(new ArObj(9,9));
        quObj.addFirst(new ArObj(3,3));
        quObj.addLast(new ArObj(10,10));
        System.out.println("Poll and peek");
        quObj.pollFirst().print();
        quObj.pollLast().print();
        quObj.peekFirst().print();
        quObj.peekLast().print();
        long endTime3 = System.nanoTime() - startTime3;
        System.out.println("Время выполнения задания 4.3, нс: " + endTime3);
        //        Задание 4.4
        long startTime4 = System.nanoTime();
        StackList sl = new StackList();
        sl.push("Rinat", 25);
        sl.push("Timur", 32);
        sl.push("Tamerlan", 45);
        sl.display();
        while (!sl.isEmpty()){
            System.out.println("Элемент " + sl.pop() + " удален из стека.");
        }
        long endTime4 = System.nanoTime() - startTime4;
        System.out.println("Время выполнения задания 4.4, нс: " + endTime4);
        //        Задание 4.5
        long startTime5 = System.nanoTime();
        Queue q = new Queue();
        q.insert("Rinat", 25);
        q.insert("Timur", 32);
        q.insert("Tamerlan", 45);
        q.display();
        while (!q.isEmpty()){
            System.out.println("Элемент " + q.delete() + " удален из стека.");
        }
        long endTime5 = System.nanoTime() - startTime5;
        System.out.println("Время выполнения задания 4.5, нс: " + endTime5);
    }
}
