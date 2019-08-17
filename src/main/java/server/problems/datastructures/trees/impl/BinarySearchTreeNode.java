package server.problems.datastructures.trees.impl;

import java.util.StringJoiner;

// http://www.cs.ust.hk/mjg_lib/Classes/COMP3711H_Fall16/lectures/BST_Revision.pdf
// Time complexity is avg log(N), worst case can be O(N) for a linear tree.
// Space complexity is O(N)
class BinarySearchTreeNode {

    BinarySearchTreeNode left;
    BinarySearchTreeNode right;
    final Integer value;

    public BinarySearchTreeNode(final Integer value) {
        this.value = value;
    }

    public void insert(final Integer value) {
        insertRecursive(this, value);
    }

    private void insertRecursive(
            final BinarySearchTreeNode binarySearchTreeNode,
            final Integer value) {
        if (value < binarySearchTreeNode.value) {
            if (binarySearchTreeNode.left == null) {
                binarySearchTreeNode.left = new BinarySearchTreeNode(value);
            } else {
                insertRecursive(binarySearchTreeNode.left, value);
            }
        } else if (value > binarySearchTreeNode.value) {
            if (binarySearchTreeNode.right == null) {
                binarySearchTreeNode.right = new BinarySearchTreeNode(value);
            } else {
                insertRecursive(binarySearchTreeNode.right, value);
            }
        } else {
            throw new RuntimeException("ERROR: DUPLICATE VALUE ON INSERT");
        }
    }

    public boolean contains(final Integer value) {
        return containsRecursive(this, value);
    }

    private boolean containsRecursive(
            final BinarySearchTreeNode binarySearchTreeNode,
            final Integer value) {
        if (binarySearchTreeNode.value.equals(value)
                || (binarySearchTreeNode.left != null && containsRecursive(binarySearchTreeNode.left, value))
                || (binarySearchTreeNode.right != null && containsRecursive(binarySearchTreeNode.right, value))) {
            return true;
        }

        return false;
    }

    public void delete(final Integer value) {
        deleteRecursive(this, value);
    }

    private void deleteRecursive(
            final BinarySearchTreeNode child,
            final Integer value) {
        if (child.value.equals(value)) {
            remove(child);
        } else if (child.value < value && child.left != null) {
            deleteRecursive(child.left, value);
        } else if (child.value > value && child.right != null) {
            deleteRecursive(child.right, value);
        }
    }

    private void remove(BinarySearchTreeNode child) {
        if (child.left == null && child.right == null) {
            child = null;
        } else if (child.left == null) {
            child = child.right;
        } else if (child.right == null) {
            child = child.left;
        } else {
            final BinarySearchTreeNode successor = child.right.getSuccessorNode();
            child.right.delete(successor.value);
            successor.left = child.left;
            successor.right = child.right;
            child = successor;
        }
    }

    public Integer getSuccessor() {
        if (this.right != null) {
            return getMinRecursive(this.right).value;
        } else {
            return null;
        }
    }

    private BinarySearchTreeNode getSuccessorNode() {
        if (this.right != null) {
            return getMinRecursive(this.right);
        } else {
            return null;
        }
    }

    public Integer getMin() {
        return getMinRecursive(this).value;
    }

    private BinarySearchTreeNode getMinRecursive(final BinarySearchTreeNode node) {
        if (node.left != null) {
            return getMinRecursive(node.left);
        } else {
            return node;
        }
    }


    public String toStringPreOrder() {
        final StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        return toStringPreOrderRecursive(this, stringJoiner).toString();
    }

    private StringJoiner toStringPreOrderRecursive(
            final BinarySearchTreeNode binarySearchTreeNode,
            final StringJoiner stringJoiner) {

        stringJoiner.add(binarySearchTreeNode.value.toString());

        if (binarySearchTreeNode.left != null) {
            toStringPreOrderRecursive(binarySearchTreeNode.left, stringJoiner);
        }

        if (binarySearchTreeNode.right != null) {
            toStringPreOrderRecursive(binarySearchTreeNode.right, stringJoiner);
        }

        return stringJoiner;
    }

    public void print() {
        System.out.println(this.toStringPreOrder());
    }
}
