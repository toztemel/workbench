package ctci.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathsWithSumTest {

    private PathsWithSum pathsWithSum;

    @Before
    public void setUp() throws Exception {
        pathsWithSum = new PathsWithSum();
    }

    @Test
    public void findPaths() {

        BinaryTreeNode root = new BinarySearchTreeNode(1);
        root.left = new BinarySearchTreeNode(-3);
        root.left.left = new BinarySearchTreeNode(5);
        root.left.right = new BinarySearchTreeNode(-2);

        root.right = new BinarySearchTreeNode(4);
        root.right.left = new BinarySearchTreeNode(-2);
        root.right.right = new BinarySearchTreeNode(-3);

        assertEquals(2, pathsWithSum.findPaths(root, 1));
        assertEquals(3, pathsWithSum.findPaths(root, 2));
        assertEquals(2, pathsWithSum.findPaths(root, 3));
        assertEquals(1, pathsWithSum.findPaths(root, 4));
        assertEquals(2, pathsWithSum.findPaths(root, 5));
        assertEquals(0, pathsWithSum.findPaths(root, 6));
        assertEquals(0, pathsWithSum.findPaths(root, 0));
        assertEquals(0, pathsWithSum.findPaths(root, -1));
        assertEquals(3, pathsWithSum.findPaths(root, -2));
        assertEquals(2, pathsWithSum.findPaths(root, -3));
        assertEquals(1, pathsWithSum.findPaths(root, -4));
        assertEquals(1, pathsWithSum.findPaths(root, -5));
    }
}