package binaryTree;

import exceptions.NoInexistenteException;

public class BinaryTreeOfSearch implements IArvoreBinaria {
    private Node root;
    @Override
    public void addValue(Node node, int value) throws Exception {
        node.setValue(value);
        root = addNode(root,node);
    }
    private Node addNode(Node current, Node node) {

        if(current == null){
            current = node;

        }
        else if(current.compareTo(node) > 0){
            current.setLeft(addNode(current.getLeft(),node));
        }
        else if(current.compareTo(node) < 0){
            current.setRight(addNode(current.getRight(),node));
        }

        return current;
    }

    @Override
    public Node remove(Node Node) throws NoInexistenteException {
        return null;
    }

    @Override
    public Node find(Node Node) throws NoInexistenteException {
        return null;
    }

    @Override
    public Node visit(Node Node) throws NoInexistenteException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public void printTree() {

    }

    @Override
    public void preOrdem(Node node) throws NoInexistenteException {
        if(node!= null) {
            visit(node);
            preOrdem(node.getLeft());
            preOrdem(node.getRight());
        }
    }

    @Override
    public void iNoderdem(Node node) throws NoInexistenteException {
        if(node != null) {
            iNoderdem(node.getLeft());
            visit(node);
            iNoderdem(node.getRight());
        }
    }

    @Override
    public void posOrdem(Node node) throws NoInexistenteException {
        if(node != null) {
            posOrdem(node.getLeft());
            posOrdem(node.getRight());
            visit(node);
        }
    }
}