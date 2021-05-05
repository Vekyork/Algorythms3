package lesson6;

public class Tree {
    private Node root;
    public void insert(Person person){
        Node node = new Node();
        node.person = person;
        if (root == null)
            root = node;
        else{
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (person.id<current.person.id){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if (current == null){
                    parent.rightChild = node;
                    return;
                    }
                }
            }
        }
    }
    public Node find(int key){//Метод поиска
        Node current = root;
        while (current.person.id != key){
            if (key<current.person.id)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }
    private void preOrder(Node rootNode){//Прямой обход
        if (rootNode!=null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }
    private void postOrder(Node rootNode){//Обратный обход
        if (rootNode!=null){
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    public void inOrder(Node rootNode){//Метод симметричного обхода
        if (rootNode!=null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }
    public Node min(){
        Node current, last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }
    public Node max(){
        Node current, last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }
    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {//Узел, на котором мы находимся сейчас
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == null) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;

            }else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
            }
        return true;
    }
    public Node getSuccessor(Node node){//Возврат узла, являющегося преемником
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current!=null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor!=node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }
//6.4
    public void displayTree(){
        Node current  =root;
        System.out.println("Симметричный метод одхода дерева");
        inOrder(root);
        System.out.println("Прямой метод одхода дерева");
        preOrder(root);
        System.out.println("Обратный метод одхода дерева");
        postOrder(current);
    }
}
