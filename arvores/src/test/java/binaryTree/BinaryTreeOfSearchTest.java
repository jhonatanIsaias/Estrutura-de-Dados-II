package binaryTree;

import exceptions.NoInexistenteException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLOutput;

public class BinaryTreeOfSearchTest extends TestCase {
@Test
    public void testAddValue() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no = new Node();


        binaryTreeOfSearch.addValue(no,4);

        Assert.assertEquals(4,no.getValue());
    }

    public void testRemove() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();

        binaryTreeOfSearch.addValue(no30,30);
        binaryTreeOfSearch.addValue(no40,40);
        binaryTreeOfSearch.addValue(no20,20);
        binaryTreeOfSearch.addValue(no10,10);
        binaryTreeOfSearch.addValue(no27,27);
        binaryTreeOfSearch.addValue(no15,15);
        binaryTreeOfSearch.addValue(no45,45);
        binaryTreeOfSearch.addValue(no41,41);
        binaryTreeOfSearch.addValue(no46,46);

        Assert.assertEquals(20, binaryTreeOfSearch.remove(no20).getValue());

        Exception exception = Assert.assertThrows(NoInexistenteException.class, () -> {
            binaryTreeOfSearch.find(no20);
        });

        Assert.assertEquals("nó não existe", exception.getMessage());
        Assert.assertEquals(30,binaryTreeOfSearch.remove(no30).getValue());
        Assert.assertEquals(binaryTreeOfSearch.getRoot().getValue(),27);

    }
@Test
    public void testFind() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no1 = new Node();
        Node no2 = new Node();
        Node no3 = new Node();
        Node no4 = new Node();
        Node no5 = new Node();
        no5.setValue(10);

        binaryTreeOfSearch.addValue(no1,4);
        binaryTreeOfSearch.addValue(no2,9);
        binaryTreeOfSearch.addValue(no3,8);
        binaryTreeOfSearch.addValue(no4,5);

        Assert.assertEquals(8, binaryTreeOfSearch.find(no3).getValue());

    Exception exception = Assert.assertThrows(NoInexistenteException.class, () -> {
        binaryTreeOfSearch.find(no5);
    });

    Assert.assertEquals("nó não existe", exception.getMessage());
}
    public void testVisit() {
    }

    public void testIsEmpty() {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Assert.assertTrue(binaryTreeOfSearch.isEmpty());
    }

    public void testIsComplete() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no35 = new Node();

        binaryTreeOfSearch.addValue(no30,50);
        binaryTreeOfSearch.addValue(no40,44);
        binaryTreeOfSearch.addValue(no20,80);
        binaryTreeOfSearch.addValue(no10,35);
        binaryTreeOfSearch.addValue(no27,49);
        binaryTreeOfSearch.addValue(no15,25);
        binaryTreeOfSearch.addValue(no45,75);
        binaryTreeOfSearch.addValue(no35,90);


        Assert.assertTrue( binaryTreeOfSearch.isComplete());
    }

    public void testHeight() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();

        binaryTreeOfSearch.addValue(no30,30);
        binaryTreeOfSearch.addValue(no40,40);
        binaryTreeOfSearch.addValue(no20,20);
        binaryTreeOfSearch.addValue(no10,10);
        binaryTreeOfSearch.addValue(no27,27);
        binaryTreeOfSearch.addValue(no15,15);
        binaryTreeOfSearch.addValue(no45,45);
        binaryTreeOfSearch.addValue(no41,41);
        binaryTreeOfSearch.addValue(no46,46);

        Assert.assertEquals(3,binaryTreeOfSearch.height());
    }

    public void testPrintTree() {
    }
    @Test
    public void testPreOrdem() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();

        binaryTreeOfSearch.addValue(no30,30);
        binaryTreeOfSearch.addValue(no40,40);
        binaryTreeOfSearch.addValue(no20,20);
        binaryTreeOfSearch.addValue(no10,10);
        binaryTreeOfSearch.addValue(no27,27);
        binaryTreeOfSearch.addValue(no15,15);
        binaryTreeOfSearch.addValue(no45,45);
        binaryTreeOfSearch.addValue(no41,41);
        binaryTreeOfSearch.addValue(no46,46);
        System.out.println("TESTE PRE-ORDEM");
        System.out.println("esperado: 30 20 10 15 27 40 45 41 46");
        System.out.print("resultado: ");
        binaryTreeOfSearch.preOrdem(binaryTreeOfSearch.getRoot());
        System.out.println();



    }
    @Test
    public void testINoderdem() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();

        binaryTreeOfSearch.addValue(no30,30);
        binaryTreeOfSearch.addValue(no40,40);
        binaryTreeOfSearch.addValue(no20,20);
        binaryTreeOfSearch.addValue(no10,10);
        binaryTreeOfSearch.addValue(no27,27);
        binaryTreeOfSearch.addValue(no15,15);
        binaryTreeOfSearch.addValue(no45,45);
        binaryTreeOfSearch.addValue(no41,41);
        binaryTreeOfSearch.addValue(no46,46);
        System.out.println("TESTE ODREM SIMETRICA");
        System.out.println("esperado: 10 15 20 27 30 40 41 45 46");
        System.out.print("resultado: ");
        binaryTreeOfSearch.iNoderdem(binaryTreeOfSearch.getRoot());
        System.out.println();

    }

    public void testPosOrdem() throws Exception {
        BinaryTreeOfSearch binaryTreeOfSearch = new BinaryTreeOfSearch();
        Node no30 = new Node();
        Node no40 = new Node();
        Node no20 = new Node();
        Node no10 = new Node();
        Node no27 = new Node();
        Node no15 = new Node();
        Node no45 = new Node();
        Node no41= new Node();
        Node no46 = new Node();

        binaryTreeOfSearch.addValue(no30,30);
        binaryTreeOfSearch.addValue(no40,40);
        binaryTreeOfSearch.addValue(no20,20);
        binaryTreeOfSearch.addValue(no10,10);
        binaryTreeOfSearch.addValue(no27,27);
        binaryTreeOfSearch.addValue(no15,15);
        binaryTreeOfSearch.addValue(no45,45);
        binaryTreeOfSearch.addValue(no41,41);
        binaryTreeOfSearch.addValue(no46,46);
        System.out.println("TESTE POS-ORDEM");
        System.out.println("esperado: 15 10 27 20 41 46 45 40 30");
        System.out.print("resultado: ");
        binaryTreeOfSearch.posOrdem(binaryTreeOfSearch.getRoot());
        System.out.println();

    }

}

