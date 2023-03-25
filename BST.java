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

    public Node searchPai(Node root, int key) {
        if (root == null || root.getValue() == key) {
            return null; 
        }
        
        if ((root.getLeft() != null && root.getLeft().getValue() == key) || 
            (root.getRight() != null && root.getRight().getValue() == key)) {
            return root;
        }
        
        Node pai = searchPai(root.getLeft(), key); // busca filho esquerdo
        
        if (pai == null) {
            pai = searchPai(root.getRight(), key); // busca filho direito
        }
        
        return pai;
    }

    public Node returnNo(Node n, int key) {
        if (n == null || n.getValue() == key) {
            return n;
        }
    
        if (key < n.getValue()) {
            return returnNo(n.getLeft(), key);
        }    
        return returnNo(n.getRight(), key);
    }    
     

    @Override
    public int minimum() {
        if(root != null){
            Node min = root;
            while(min.getLeft() != null){
                min = min.getLeft();
            }
            return min.getValue();
        }
        return -1;
    }
    

    @Override
    public int maximum() {
        if(root != null){
            Node max = root;
            while(max.getRight() != null){
                max = max.getRight();
            }
            return max.getValue();
        }
        return -1;
    }

    @Override
    public int sucessor(int key) {
        Node n = returnNo(root , key);
        if (n == null) {
            return -1; // nó não encontrado na árvore
        }
        if(n.getValue() == maximum()){ // Não tem sucessor
            return -1;
        }
        if (n.getRight() != null) {
            // Caso 1 - Possui filhos
            Node sucessor = n.getRight();
            while (sucessor.getLeft() != null) {
                sucessor = sucessor.getLeft();
            }
            return sucessor.getValue();
        } else {
            // Caso 2 - Não possui filhos
            Node pai = searchPai(root, n.getValue());
            while (pai != null && n == pai.getRight()) {
                n = pai;
                pai = searchPai(root, n.getValue());
            }
            return pai.getValue(); 
        }
    }    


    
    @Override
    public int prodessor(int chave) {
        return 0;
    }
    
    // private int searchNodeComp(Node n, int key){
    //     if (key > n.getValue()){
    //         if (n.getRight() == null){
    //             return false;
    //         } else {
    //             return searchNode(n.getRight(),key);
    //         }
    //     } else {
    //         if (n.getLeft() == null){
    //             return false;
    //         } else {
    //             return searchNode(n.getLeft(),key);
    //         }
    //     }
    // }

    public static void main(String[] args) {
        BST tree = new BST();
        System.out.println(tree.search(7)); // false
        tree.insert(8);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(10);
        tree.insert(1);
        tree.insert(3);
        tree.insert(13);
        tree.insert(6);
        System.out.println(tree.search(10)); //true
        tree.delete(10);
        System.out.println(tree.search(10)); // false
        System.out.println(tree.search(6)); // true
        tree.delete(6);
        System.out.println(tree.search(6)); // false
        System.out.println(tree.minimum());
        System.out.println(tree.maximum());
        System.out.println(tree.sucessor(11)); // 12
        System.out.println(tree.sucessor(3)); // 5
        
    }
}