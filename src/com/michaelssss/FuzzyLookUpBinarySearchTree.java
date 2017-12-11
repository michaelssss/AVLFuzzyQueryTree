package com.michaelssss;

import java.util.Arrays;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpBinarySearchTree<T> extends FuzzyLookUpBinaryTree<T> {

    @Override
    protected void put2TreeInInsertOrder(Node<T> root, T t) {
        if (put2Right(root, t)) {
            if (root.getRight() == null) {
                root.setRight(new Node<>(getIndex(t), t));
            } else {
                put2TreeInInsertOrder(root.getRight(), t);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(new Node<>(getIndex(t), t));
            } else {
                put2TreeInInsertOrder(root.getLeft(), t);
            }
        }
        reBlance(root);
    }

    private void reBlance(Node<T> root) {
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

    private String getIndex(T t) {
        return Arrays.toString(accessPublicValue(t));
    }

    private boolean put2Right(Node<T> tNode, T t) {
        String compare = Arrays.toString(accessPublicValue(t));
        String nodeIndex = tNode.getIndex();
        return compare.hashCode() >= nodeIndex.hashCode();
    }

    private boolean go2Right(Node<T> tNode, String keyWord) {
        return keyWord.hashCode() >= tNode.getIndex().hashCode();
    }

    @Override
    protected Node<T> MidFirstQuery(Node<T> node, String keyWord) {
        if (null == node) return null;
        if (node.getIndex().contains(keyWord)) {
            return node;
        } else {
            if (go2Right(node, keyWord)) {
                return this.MidFirstQuery(node.getRight(), keyWord);
            } else {
                return this.MidFirstQuery(node.getLeft(), keyWord);
            }
        }
    }

    private void rightRotate(Node<T> x) {
        Node<T> pivot = x.getLeft();
        Node<T> pivotRight = pivot.getRight();
        x.setLeft(pivotRight);
        Node<T> father = findParent(root, x);
        if (father == x) {
            root = pivot;
            pivot.setRight(x);
            return;
        }
        father.setLeft(pivot);
        pivot.setRight(x);
    }

    private void leftRotate(Node<T> x) {
        Node<T> pivot = x.getRight();
        Node<T> pivotLeft = pivot.getLeft();
        x.setRight(pivotLeft);
        Node<T> father = findParent(root, x);
        if (father == x) {
            root = pivot;
            pivot.setLeft(x);

            return;
        }
        father.setRight(pivot);
        pivot.setLeft(x);
    }

    @Override
    public boolean put(T t) {
        boolean b = super.put(t);
        System.out.println("AVL session:" + calAverage(root));
        return b;
    }

    private int calAverage(Node<T> t) {
        int average = calNodeDepth(t.getLeft()) - calNodeDepth(t.getRight());
        System.out.println("Node :" + t + " average=" + average);
        return average;
    }

    private int calNodeDepth(Node<T> t) {
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

    @Override
    public String toString() {
        return "FuzzyLookUpBinarySearchTree{" +
                "root=" + root +
                '}';
    }

    private Node<T> findParent(Node<T> currentNode, Node<T> childNode) {
        if (currentNode.equals(childNode)) {
            return currentNode;
        }
        if (childNode.equals(currentNode.getRight()) || childNode.equals(currentNode.getLeft())) {
            return currentNode;
        }
        Node<T> node;
        if (go2Right(currentNode, childNode.getIndex())) {
            node = findParent(currentNode.getRight(), childNode);
        } else {
            node = findParent(currentNode.getLeft(), childNode);
        }
        return node;
    }
}
