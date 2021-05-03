package lesson4;

import java.util.*;

public class ArObj {
    private int x;
    private int y;
    public ArObj(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void print() {System.out.println("X: " + this.x + "; Y: " + this.y + "\n");}
    public int getX() {return x;}
    public int getY() {return  y;}
}
