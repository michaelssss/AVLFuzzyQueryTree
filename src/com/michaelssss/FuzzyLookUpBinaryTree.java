package com.michaelssss;

import java.util.Arrays;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpBinaryTree<T> extends AbstractFuzzyLookUp implements FuzzyLookUpContainer<T> {
    protected Node<T> root;
    private int size;

    protected void put2TreeInInsertOrder(Node<T> root, T t) {
        if (isNodeOccupy(root.getLeft())) {
            if (isNodeOccupy(root.getRight())) {
                put2TreeInInsertOrder(root.getLeft(), t);
            } else {
                root.setRight(new Node<T>(Arrays.toString(accessPublicValue(t)), t));
            }
        } else {
            root.setLeft(new Node<T>(Arrays.toString(accessPublicValue(t)), t));
        }
    }

    protected boolean isNodeOccupy(Node<T> node) {
        return null != node;
    }

    protected Node<T> MidFirstQuery(Node<T> node, String keyWord) {
        if (null == node) {
            return null;
        }
        if (node.getIndex().contains(keyWord)) {
            return node;
        } else {
            Node<T> node1 = MidFirstQuery(node.getLeft(), keyWord);
            Node<T> node2 = MidFirstQuery(node.getRight(), keyWord);
            if (node1 != null) return node1;
            if (node2 != null) return node2;
        }
        return null;
    }

    @Override
    public T[] lookUp(String value) {
        Node<T> tNode = MidFirstQuery(this.root, value);
        return (T[]) new Object[]{tNode.getO()};
    }

    @Override
    public boolean put(T t) {
        try {
            if (null == root) {
                root = new Node<>(Arrays.toString(accessPublicValue(t)), t);
            } else {
                put2TreeInInsertOrder(this.root, t);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
