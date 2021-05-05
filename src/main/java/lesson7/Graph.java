package lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    private final int MAX_VERTS = 32;//Максимальное количество вершин
    private Vertex[] vertexList;//Массив
    private int[] [] adjMat;//Матрица смежности
    private int size;
    private Stack stack;

    public Graph() {//Конструктор
        stack = new Stack[MAX_VERTS];
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];//Матрица 32х32
        size = 0;//Начальное количество вершин = 0
        for (int i =0; i<MAX_VERTS; i++){//Заполняем матрицы 0
            for (int j = 0; j<MAX_VERTS; j++){
                adjMat[i][j] = 0;//Связей графов пока нет
            }
        }
    }
    private int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i<size; i++){
            if (adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return  -1;
    }
    public void dfs(){//7.3 Метод обхода в глубину
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int v = getAdjUnvisitedVertex(stack.peek());//Самая верхняя вершина
            if (v == -1){
                stack.pop();
            }else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i<size; i++){
            vertexList[i].wasVisited = false;
        }
    }
    public void DFS(int f){//7.3_2 Рекурсивный метод обхода в глубину
        vertexList[f].wasVisited = true;
        for (int i = 0; i<size; i++){
            int v = getAdjUnvisitedVertex(f);
            if (!vertexList[i].wasVisited && v != -1){
                fullDisplayVertex(f, v);//Вершина, на которой мы находимся f и смежная вершина v
                DFS(i);
            }
        }
    }
    public void bfs(){//7.4 Метод обхода в ширину
        Queue<Integer>queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()){
            int v1 = queue.remove();
            while ((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i<size; i++)//Сброс флагов
            vertexList[i].wasVisited = false;
    }
    public void bfs2(int v){//Использование очереди при помощи массива
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;
        vertexList[0].wasVisited = true;
        queue[qT++] = v;
        displayVertex(0);
        int v2;
        while (qH<qT){
            v = queue[qH++];
            for (int i=0; i<size; i++){
                v2 = getAdjUnvisitedVertex(v);
                if(!vertexList[i].wasVisited && v2 !=-1){
                    vertexList[i].wasVisited = true;
                    displayVertex(qT);
                    queue[qT++] = i;
                }
            }
        }
        for (int i=0; i<size; i++)//Сброс флагов
            vertexList[i].wasVisited = false;
    }
    public void addVertex(char label){vertexList[size++] = new Vertex(label);}
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;//Связь от А к Б
        adjMat[end][start] = 1;//Связь от Б к А
    }
    public void displayVertex(int vertex){System.out.println(vertexList[vertex].label);}//Отображение вершины
    public void fullDisplayVertex(int vertex1, int vertex2){System.out.println("Вершины " + vertexList[vertex1].label + " - " + vertexList[vertex2].label);}
}