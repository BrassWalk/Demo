package server.problems.datastructures.trees.core.impl;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void test_BST_insert() {
        final BinarySearchTreeNode root = new BinarySearchTreeNode(0);

        initializedTestTree(root);

        Assert.assertEquals("[0, -3, -6, -2, 4, 2, 6, 10]", root.toStringPreOrder());
        Assert.assertTrue(root.contains(10));
        Assert.assertTrue(!root.contains(-10));
    }

    @Test
    public void test_BST_delete() {
        final BinarySearchTreeNode root = new BinarySearchTreeNode(0);

        initializedTestTree(root);

        root.delete(10);
        Assert.assertTrue(!root.contains(10));
        root.print();
        Assert.assertEquals("[0, -3, -6, -2, 4, 2, 6]", root.toStringPreOrder());

        root.delete(-3);
        Assert.assertTrue(!root.contains(-3));
        root.print();
//        Assert.assertEquals("[0, -3, -6, -2, 4, 2, 6]", root.toStringPreOrder());

        root.delete(0);
        Assert.assertTrue(!root.contains(0));
        root.print();
//        Assert.assertEquals("[0, -3, -6, -2, 4, 2, 6]", root.toStringPreOrder());
    }

    private void initializedTestTree(final BinarySearchTreeNode root){
        root.insert(-3);
        root.insert(4);

        root.insert(-6);
        root.insert(-2);
        root.insert(2);
        root.insert(6);

        root.insert(10);
    }
}
