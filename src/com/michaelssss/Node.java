package com.michaelssss;

import java.util.Objects;

/**
 * @author michaelssss
 * @since 2017/11/29
 */
public class Node<T> {
    private String index;
    private int depth;
    private T o;
    private Node<T> left;
    private Node<T> right;

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node(String index, T o) {
        this.index = index;
        this.o = o;
        this.left = null;
        this.right = null;
    }

    public String getIndex() {
        return index;
    }


    public void setIndex(String index) {
        this.index = index;
    }

    public T getO() {
        return o;
    }

    public void setO(T o) {
        this.o = o;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o1) {
        if (this == o1) return true;
        if (o1 == null || getClass() != o1.getClass()) return false;
        Node<?> node = (Node<?>) o1;
        return Objects.equals(index, node.index) &&
                Objects.equals(o, node.o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, o);
    }

    @Override
    public String toString() {
        return "Node{" +
                "index='" + index + '\'' +
                ", o=" + o +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
