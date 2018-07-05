package ctci.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTSuccessorTest {

    DoubleBSTNode parent;
    private BSTSuccessor bstSuccessor;

    @Before
    public void setUp() throws Exception {
        parent = new DoubleBSTNode(15);

        DoubleBSTNode one = new DoubleBSTNode(1);
        one.setLeft(new DoubleBSTNode(0));
        one.setRight(new DoubleBSTNode(2));

        DoubleBSTNode thirteen = new DoubleBSTNode(13);
        thirteen.setLeft(new DoubleBSTNode(11));
        thirteen.setRight(new DoubleBSTNode(14));

        DoubleBSTNode ten = new DoubleBSTNode(10, parent);
        ten.setLeft(one);
        ten.setRight(thirteen);

        parent.setLeft(ten);

        DoubleBSTNode eighteen = new DoubleBSTNode(18);
        eighteen.setLeft(new DoubleBSTNode(16));
        eighteen.setRight(new DoubleBSTNode(19));

        DoubleBSTNode tFive = new DoubleBSTNode(25);
        tFive.setLeft(new DoubleBSTNode(22));
        tFive.setRight(new DoubleBSTNode(28));

        DoubleBSTNode twenty = new DoubleBSTNode(20);
        twenty.setLeft(eighteen);
        twenty.setRight(tFive);

        parent.setRight(twenty);
        bstSuccessor = new BSTSuccessor();
    }

    @Test
    public void findSuccessor() throws Exception {
        assertEquals(1, bstSuccessor.findSuccessor(of(0)));
        assertEquals(2, bstSuccessor.findSuccessor(of(1)));
        assertEquals(10, bstSuccessor.findSuccessor(of(2)));
        assertEquals(11, bstSuccessor.findSuccessor(of(10)));
        assertEquals(13, bstSuccessor.findSuccessor(of(11)));
        assertEquals(14, bstSuccessor.findSuccessor(of(13)));
        assertEquals(15, bstSuccessor.findSuccessor(of(14)));
        assertEquals(16, bstSuccessor.findSuccessor(of(15)));
        assertEquals(18, bstSuccessor.findSuccessor(of(16)));
        assertEquals(19, bstSuccessor.findSuccessor(of(18)));
        assertEquals(20, bstSuccessor.findSuccessor(of(19)));
        assertEquals(22, bstSuccessor.findSuccessor(of(20)));
        assertEquals(25, bstSuccessor.findSuccessor(of(22)));
        assertEquals(28, bstSuccessor.findSuccessor(of(25)));
        assertEquals(-1, bstSuccessor.findSuccessor(of(28)));

        DoubleBSTNode tNine = new DoubleBSTNode(29);
        tNine.setLeft(parent);
        assertEquals(29, bstSuccessor.findSuccessor(of(28)));
    }

    private DoubleBSTNode of(int i) {
        BinaryTreeNode result = parent;
        while (result.data != i) {
            result = (result.data < i) ? result.right : result.left;
        }
        return (DoubleBSTNode) result;
    }

}