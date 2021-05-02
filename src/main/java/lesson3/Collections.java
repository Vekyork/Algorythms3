package lesson3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collections {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Создаем коллекции для демонстрации
        Collection col1 = createFirstCollection();
        Collection col2 = createSecondCollection();
        // Демонстрация прохода по коллекции
        System.out.println("============= Проход по коллекции");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();
        // Демонстрация прохода по коллекции через итератор
        System.out.println("============= Проход по коллекции через итератор");
        for (Iterator it = col1.iterator(); it.hasNext(); ) {
            String s = (String)it.next();
            System.out.println("Item:" + s);
        }
        System.out.println();
        // Демонстрации групповых операций
        System.out.println();
        System.out.println("============= Групповые операции");
        // Можно проверить сожержаться ли ВСЕ элементы col2 в col
        if(col1.containsAll(col2)) {
            System.out.println("Коллекция col содержит все от col2");
        }
        System.out.println("============= Добавление всех элементов в col1 из col2");
        // Можно добавить элементы из col2 в col1
        col1.addAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("============= Удаление всех элементов col2, которые есть в col1");
        // Можно удалить ВСЕ элементы col2, которые есть в col1
        col1.removeAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        // Пересоздаем коллекции для дпальнейшей демонстрации
        col1 = createFirstCollection();
        col2 = createSecondCollection();
        System.out.println("============= Удаление элементов из col1, которых нет в col2");
        col1.retainAll(col2);
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println("============= Очистка коллекции - не будет элементов");
        col1.clear();
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        System.out.println();
        // Удаление элемента коллекции
        // Снова создаем коллекцию для демонстрации
        col1 = createFirstCollection();
        // Удаляем один элемент
        col1.remove("1");
        System.out.println("============= Удаляем элемент '1' - его не будет в списке");
        for(Object o : col1) {
            System.out.println("Item:" + o);
        }
        // Удаление коллекции через итератор
        // Снова создаем коллекцию для демонстрации
        col1 = createFirstCollection();
        System.out.println("============= Удаление через итератор");
        while(!col1.isEmpty()) {
            Iterator it = col1.iterator();
            Object o = it.next();
            System.out.println("Удаляем:" + o);
            // Удаляем элемент
            it.remove();
        }
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения операций, нс: " + endTime);
    }
    // Первая коллекция для примера
    private static Collection createFirstCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col = new ArrayList();
        // Добавление в коллекцию
        col.add("1");
        col.add("2");
        col.add("3");
        col.add("4");
        col.add("5");
        col.add("6");
        col.add("7");
        return col;
    }
    // Вторая коллекция для примера
    private static Collection createSecondCollection() {
        // Создать коллекцию на основе стандартного класса ArrayList
        Collection col2 = new ArrayList();
        col2.add("1");
        col2.add("2");
        col2.add("3");
        return col2;
    }
//    Односвязный список
    public class Node {
        //содержимое текущего элемента списка
         private int element;
         //указатель на следующий элемент списка
         private Node next;
         //вывод содержимого текущего элемента
         public int getElement(){ return element; }
        //установка содержимого для текущего элемента списка
         public void setElement(int e){ element = e; }
        //получение указателя на следующий элемент списка
         public Node getNext() { return next; }
        //установка следующего элемента списка
         public void setNext(Node n) { next = n; }
    }
    // Двусвязный список
    public class node<T> {
        public node() {
            this.setNext(null);
            this.setPrev(null);
        }
        public node(T k) {
            this.setNext(null);
            this.setPrev(null);
            this.setKey(k);
        }
        public node<T> getNext() {
            return next;
        }
        public void setNext(node<T> next) {
            this.next = next;
        }
        public node<T> getPrev() {
            return prev;
        }
        public void setPrev(node<T> prev) {
            this.prev = prev;
        }
        public T getKey() {
            return key;
        }
        public void setKey(T key) {
            this.key = key;
        }
        private node<T> next;
        private node<T> prev;
        private T key;
    }
}