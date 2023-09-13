package binaryTree;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;

    }

    public Node getRoot() {
        return root;
    }

    public void addValue(int value) {
        if(root == null){
            root = new Node(value);
        }
        else {
            root = searchNode(root,value);
        }
    }

    public Node searchNode(Node current, int value) {

       if(current == null){
           current = new Node(value);
       }
      else if(value < current.getValue()){
           current.setLeft(searchNode(current.getLeft(),value));
       }
       else if(value > current.getValue()){
           current.setRight(searchNode(current.getRight(),value));
       }

        return current;
    }

    public void printNodePreOrder(Node node){
        if(node!= null) {
            System.out.print(node.getValue());
            printNodePreOrder(node.getLeft());
            printNodePreOrder(node.getRight());
        }


    }
    public void printNodeSimetricOrder(Node node){
        if(node != null) {
            printNodePreOrder(node.getLeft());
            System.out.print(node.getValue());
            printNodePreOrder(node.getRight());
        }
    }
    public void printNodePosOrder(Node node){
        if(node != null) {
            printNodePreOrder(node.getLeft());
            printNodePreOrder(node.getRight());
            System.out.print(node.getValue());
        }
    }


}