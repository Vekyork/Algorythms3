package lesson4;

public class Link {
    public String name;
    public  int age;
    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void display(){System.out.println("Name: " + this.name + "Age: " + this.age);}

}
