package ctci.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstCommonAncestorTest {

    private FirstCommonAncestor firstCommonAncestor;
    private BinaryTreeNode root;
    private BinaryTreeNode two;
    private BinaryTreeNode nine;
    private BinaryTreeNode eleven;
    private BinaryTreeNode ten;
    private BinaryTreeNode thteen;
    private BinaryTreeNode twelve;
    private BinaryTreeNode ffteen;
    private BinaryTreeNode three;

    @Before
    public void setUp() throws Exception {

        root = new BinaryTreeNode(1);
        two = new BinaryTreeNode(2);
        three = new BinaryTreeNode(3);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode five = new BinaryTreeNode(5);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode seven = new BinaryTreeNode(7);
        BinaryTreeNode eight = new BinaryTreeNode(8);
        nine = new BinaryTreeNode(9);
        ten = new BinaryTreeNode(10);
        eleven = new BinaryTreeNode(11);
        twelve = new BinaryTreeNode(12);
        thteen = new BinaryTreeNode(13);
        BinaryTreeNode frteen = new BinaryTreeNode(14);
        ffteen = new BinaryTreeNode(15);

        root.left = two;
        root.right = three;

        two.left=four;
        two.right=five;

        four.left = eight;
        four.right = nine;
        five.left= ten;
        five.right= eleven;

        three.left=six;
        three.right=seven;
        six.left= twelve;
        six.right= thteen;
        seven.left=frteen;
        seven.right= ffteen;
        firstCommonAncestor = new FirstCommonAncestor();

    }

    @Test
    public void test() {

        assertEquals(two, firstCommonAncestor.find(root, nine, eleven));
        assertEquals(root, firstCommonAncestor.find(root, nine, thteen));
        assertEquals(three, firstCommonAncestor.find(root, twelve, ffteen));
    }

}