package binaryTree;

import binaryTree.AVLTree;
import binaryTree.Node;
import junit.framework.TestCase;

public class AVLTreeTest extends TestCase {

    public void testPrintTree() throws Exception {
        binaryTree.AVLTree avlTree = new AVLTree();

        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
     /*   Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();
*/
        avlTree.addValue(no30,49);
        avlTree.addValue(no40,15);
        avlTree.addValue(no20,12);
      /*  avlTree.addValue(no10,10);
        avlTree.addValue(no27,27);
        avlTree.addValue(no15,15);
        avlTree.addValue(no45,45);
        avlTree.addValue(no41,41);
        avlTree.addValue(no46,46);
        */
        avlTree.printTree();
    }
}