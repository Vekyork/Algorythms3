package lesson7;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');

        graph.addEdge(0, 1);//Связь ребер между вершинами A и B
        graph.addEdge(1, 2);//BC
        graph.addEdge(2, 3);//CD
        graph.addEdge(3, 4);//DE
        graph.addEdge(0, 5);

//        graph.displayVertex(4);//Вывод вершины 4
        graph.dfs();//Вывод вершин
        graph.DFS(0);
        long endTime = System.nanoTime() - startTime;
        System.out.println("Время выполнения задания, нс: " + endTime);
    }
}