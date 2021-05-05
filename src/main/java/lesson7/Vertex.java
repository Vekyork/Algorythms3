package lesson7;

import java.util.*;

class Vertex {
    public char label;//Метка вершины
    public boolean wasVisited;//Отметка о прохождении вершины

    public Vertex(char label){
        this.label = label;
        this.wasVisited = false;
    }
}
