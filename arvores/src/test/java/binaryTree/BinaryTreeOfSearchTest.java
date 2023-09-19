package binaryTree;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeOfSearchTest extends TestCase {
    @Test
    public void testAddValue() throws Exception {

        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no = new Node();


        binaryTreeOfSearch.addValue(no,4);

        Assert.assertEquals(4,no.getValue());
    }
    @Test
    public void testFind() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no1 = new Node();
        Node no2 = new Node();
        Node no3 = new Node();
        Node no4 = new Node();



        binaryTreeOfSearch.addValue(no1,4);
        binaryTreeOfSearch.addValue(no2,9);
        binaryTreeOfSearch.addValue(no3,8);
        binaryTreeOfSearch.addValue(no4,5);


        Assert.assertEquals(8,binaryTreeOfSearch.find(no3,no1).getValue());
    }
}