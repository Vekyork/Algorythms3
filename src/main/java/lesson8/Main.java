package lesson8;

import java.util.Random;
//8.1-8.5 Хеш-таблицы
public class Main {
    public static void hash(char x){System.out.println((x>>15)^x);}
    public static void hashFunc(char key, int f){System.out.println(key % f);}//Коллизии
    public static void hashFunc2(int k, int ize){System.out.println(k % ize);}

    public static void main(String[] args) {
        String hashStr = "t";
        char hashChar = 't';
        System.out.println(hashStr.hashCode());
        hash(hashChar);
        hashFunc(hashChar, 10);

        Item aDataItem;
        int aKey;
        int size = 66;
        HashTable hTable = new HashTable(size);
        Random rand = new Random();
        for (int j=0; j<15; j++){
            aKey = rand.nextInt(999);
            aDataItem = new Item(aKey);
            hTable.insert(aDataItem);
        }
        hTable.insert(new Item(999));
        hTable.insert(new Item(203));
        hTable.display();
        hashFunc2(999, 66);
        System.out.println(hTable.find(999).getKey());
        hTable.delete(203);
        hTable.display();
    }
}