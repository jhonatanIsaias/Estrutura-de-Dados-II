import binaryTree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.addValue(4);
        binaryTree.addValue(6);
        binaryTree.addValue(2);
        binaryTree.addValue(1);
        binaryTree.addValue(3);
        binaryTree.addValue(5);

        binaryTree.printNodePreOrder(binaryTree.getRoot());
    }
}