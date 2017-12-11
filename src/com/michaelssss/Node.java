package com.michaelssss;

import java.util.Objects;

/**
 * @author michaelssss
 * @since 2017/11/29
 */
public class Node {
    private com.michaelssss.TestObject index;
    private int depth;
    private TestObject o;
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(com.michaelssss.TestObject index, TestObject o) {
        this.index = index;
        this.o = o;
        this.left = null;
        this.right = null;
    }

    public com.michaelssss.TestObject getIndex() {
        return index;
    }


    public void setIndex(com.michaelssss.TestObject index) {
        this.index = index;
    }

    public TestObject getO() {
        return o;
    }

    public void setO(TestObject o) {
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
        Node node = (Node) o1;
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
