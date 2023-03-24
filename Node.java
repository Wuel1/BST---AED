package tree;

public class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public void setValue(int chave){
        value = chave;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node n) {
        right = n;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node n) {
        left = n;
    }
}
