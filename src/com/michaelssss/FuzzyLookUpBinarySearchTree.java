package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpBinarySearchTree extends FuzzyLookUpBinaryTree {

    @Override
    protected void put2TreeInInsertOrder(Node root, TestObject t) {
        super.put2TreeInInsertOrder(root, t);
        reBalance(root);
    }

    private void reBalance(Node root) {
        int average = calAverage(root);
        if (average == 2) {
            int leftAverage = calAverage(root.getLeft());
            if (average * leftAverage > 0) {
                rightRotate(root);
            } else {
                rightRotate(root);
                leftRotate(root);
            }
        } else if (average == -2) {
            int rightAverage = calAverage(root.getRight());
            if (rightAverage * average > 0) {
                leftRotate(root);
            } else {
                leftRotate(root);
                rightRotate(root);
            }
        }
    }

    private TestObject getIndex(TestObject t) {
        return t;
    }

    private boolean put2Right(Node tNode, TestObject t) {
        String compare = t.getA();
        String nodeIndex = tNode.getIndex().getA();
        return compare.hashCode() >= nodeIndex.hashCode();
    }


    private void rightRotate(Node x) {
        Node pivot = x.getLeft();
        Node pivotRight = pivot.getRight();
        x.setLeft(pivotRight);
        Node father = findParent(root, x);
        if (father == x) {
            root = pivot;
            pivot.setRight(x);
            return;
        }
        father.setLeft(pivot);
        pivot.setRight(x);
    }

    private void leftRotate(Node x) {
        Node pivot = x.getRight();
        Node pivotLeft = pivot.getLeft();
        x.setRight(pivotLeft);
        Node father = findParent(root, x);
        if (father == x) {
            root = pivot;
            pivot.setLeft(x);

            return;
        }
        father.setRight(pivot);
        pivot.setLeft(x);
    }

    private int calAverage(Node t) {
        return calNodeDepth(t.getLeft()) - calNodeDepth(t.getRight());
    }

    private int calNodeDepth(Node t) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (null == t) {
            return 0;
        }
        if (t.getRight() == null && t.getLeft() == null) {
            return 1;
        }
        if (t.getLeft() != null) {
            leftDepth = 1 + calNodeDepth(t.getLeft());
        }
        if (t.getRight() != null) {
            rightDepth = 1 + calNodeDepth(t.getRight());
        }
        return rightDepth > leftDepth ? rightDepth : leftDepth;
    }

    private Node findParent(Node currentNode, Node childNode) {
        if (currentNode.equals(childNode)) {
            return currentNode;
        }
        if (childNode.equals(currentNode.getRight()) || childNode.equals(currentNode.getLeft())) {
            return currentNode;
        }
        Node node;
        if (go2Right(currentNode, childNode.getIndex())) {
            node = findParent(currentNode.getRight(), childNode);
        } else {
            node = findParent(currentNode.getLeft(), childNode);
        }
        return node;
    }
}
