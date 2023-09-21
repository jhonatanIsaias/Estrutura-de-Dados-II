package binaryTree;

import exceptions.ArvoreVaziaException;
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
    public Node remove(Node node, Node current) throws NoInexistenteException, ArvoreVaziaException {


        if(isEmpty()){
            throw new ArvoreVaziaException("arvore vazia");
        }
        Node nodeRemove = find(node,current);
        Node nodeFather = nodeRemove.getFather();
        nodeFather.setLeft(nodeRemove.getLeft());
        nodeFather.setRight(nodeRemove.getRight());

        return nodeRemove;



    }

    @Override
    public Node find(Node node,Node current) throws NoInexistenteException, ArvoreVaziaException {

        if(isEmpty()){
            throw new ArvoreVaziaException("arvore vazia");
        }else{
            return findRecursive(node,current);
        }


    }
    private Node findRecursive(Node node ,Node current) throws NoInexistenteException {
        if (current != null) {
            if (current.compareTo(node) == 0) {
                return current;
            } else if (current.compareTo(node) > 0) {

                return findRecursive(node, current.getLeft());
            } else if (current.compareTo(node) < 0) {
                return findRecursive(node, current.getRight());
            }

        }

            throw new NoInexistenteException("nó não existe");


    }
    @Override
    public Node visit(Node Node) throws NoInexistenteException {
        return null;
    }

    @Override
    public boolean isEmpty()  {
        if(root == null){
            return true;
        }
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