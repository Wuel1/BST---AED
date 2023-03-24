package tree;

import lista.EstruturaDeDados;

public class BST implements EstruturaDeDados{

    private Node root;

    @Override
    public void insert(int key) {
        if (root == null){
            root = new Node(key);
        } else{
            insertNode(root, key);   
        }
    }

    private void insertNode(Node n, int key){
        if (key >= n.getValue()){
            //inserir na direita
            if (n.getRight() == null){
                Node newN = new Node(key);
                n.setRight(newN);
            } else {
                insertNode(n.getRight(), key);
            }
        } else {
            //inserir na esquerda
            if (n.getLeft() == null){
                Node newN = new Node(key);
                n.setLeft(newN);
            } else {
                insertNode(n.getLeft(), key);
            }
        }
    }

    @Override
    public void delete(int chave) {
        
    }

    private void deleteNode(Node n, int key){
        if (key >= n.getValue()){
            Node r = n.getRight();
            if (r.getValue() == key){
                //verificar se r é folha
                if (r.getRight() == null && r.getLeft() == null){
                    //Caso 1
                    n.setRight(null);
                } else if (r.getRight() == null){
                    //Caso 2
                    n.setRight(r.getLeft());
                } else if (r.getLeft() == null){
                    //Caso 2
                    n.setRight(r.getRight());
                } else{
                    n.setright(r.getright());
                }               
                
            }

        }
    }

    public Node minNo(Node n){
        n.atual = n;
        while(n.atual.getLeft() != null){
            n.atual = n.atual.getLeft();
        }
        return n.atual;
    }

    @Override
    public boolean search(int key) {
        if (root == null){
            return false;
        }
        return searchNode(root, key);
    }

    private boolean searchNode(Node n, int key){
        if (n.getValue() == key){
            return true;
        } else if (key > n.getValue()){
            if (n.getRight() == null){
                return false;
            } else {
                return searchNode(n.getRight(),key);
            }
        } else {
            if (n.getLeft() == null){
                return false;
            } else {
                return searchNode(n.getLeft(),key);
            }
        }
    }

    @Override
    public int minimum() {
        return 0;
    }

    @Override
    public int maximum() {
        return 0;
    }

    @Override
    public int sucessor(int chave) {
        return 0;
    }

    @Override
    public int prodessor(int chave) {
        return 0;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        System.out.println(tree.search(7));
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(6);
        System.out.println(tree.search(5));
        System.out.println(tree.search(7));
    }
}
