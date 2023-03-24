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
        if(root.getRight() == null && root.getLeft() == null){
            root = null;
        }
        else{
            deleteNode(root, chave);
        }
    }

    private Node deleteNode(Node n, int key){
        if (n == null) {
            return null;
        }    
        if (key < n.getValue()) {
            n.setLeft(deleteNode(n.getLeft(), key));
        } else if (key > n.getValue()) {
            n.setRight(deleteNode(n.getRight(), key));
        } else {
            if (n.getLeft() == null) {
                return n.getRight();
            } else if (n.getRight() == null) {
                return n.getLeft();
            }
    
            Node temporario = minNo(n.getRight());
            n.setValue(temporario.getValue());
            n.setRight(deleteNode(n.getRight(), temporario.getValue()));
        }
    
        return n;
    }
    
    public Node minNo(Node n){
        Node nAtual = n;
        while(nAtual.getLeft() != null){
            nAtual = nAtual.getLeft();
        }
        return nAtual;
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

    // public Node buscarPai(Node raiz, int valorBuscado) {
    //     if (raiz == null || raiz.getValue() == valorBuscado) {
    //         return null; // árvore vazia ou valor encontrado na raiz
    //     }
        
    //     if ((raiz.getLeft() != null && raiz.getLeft().getValue() == valorBuscado) || 
    //         (raiz.getRight() != null && raiz.getRight().getValue() == valorBuscado)) {
    //         return raiz; // encontramos o nó filho com o valor buscado, retornamos o pai
    //     }
        
    //     Node pai = buscarPai(raiz.getLeft(), valorBuscado); // busca recursiva no filho esquerdo
        
    //     if (pai == null) {
    //         pai = buscarPai(raiz.getRight(), valorBuscado); // busca recursiva no filho direito
    //     }
        
    //     return pai;
    // }
     

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
        System.out.println(tree.search(7)); // false
        tree.insert(8);
        tree.insert(5);
        tree.insert(11);
        tree.insert(10);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        System.out.println(tree.search(10)); //true
        tree.delete(10);
        System.out.println(tree.search(10)); // false
        System.out.println(tree.search(6)); // true
        tree.delete(6);
        System.out.println(tree.search(6)); // false
        
    }
}