package binaryTree;

public class Node implements INo {
    private Integer value;
    private Node right;
    private Node left;
    private Node father;
    private int balance;

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public Node getFather() {
        return this.father;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void setFather(Node node) {
        this.father = node;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }
    @Override
    public int compareTo(Node o) {
        return this.value.compareTo(o.value);
    }
}
