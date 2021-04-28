package lesson1;

public class Animal {
    public String animals;
    public String name;
    public int age;

    public Animal(String animals, String name, int age) {//конструктор класса Animal
        this.animals = animals;
        this.name = name;
        this.age = age;
    }
    public String getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void showInfo() { //метод отображения данных
        System.out.printf("Вид животного: %s, кличка: %s, возраст: %d\n", getAnimals(), getName(), getAge());
    }
}