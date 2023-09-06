public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;

    }

    public void addValue(int value) {
        if(root == null){
            root = new Node();
            root.setValue(value);
            root.setFather(null);
            root.setLeft(null);
            root.setRight(null);
        }
        else {
            Node node = searchNode(root);
            node.setValue(value);
            node.setLeft(null);
            node.setRight(null);

        }
    }

    public Node searchNode(Node current) {

        if(current == null){
            current = new Node();
            return current;
        }

        if(current.getLeft() == null){
           Node resultLeft =  searchNode(current.getLeft());
           resultLeft.setFather(current.getLeft());
           return resultLeft;
        }
        else{
            Node resultRight =  searchNode(current.getRight());
            resultRight.setFather(current.getRight());
            return resultRight;
        }


    }

}