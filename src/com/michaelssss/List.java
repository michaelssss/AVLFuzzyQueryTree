package com.michaelssss;

/**
 * Created by michaelssss on 2018/1/5.
 */
public class List {
    private Node1 root;

    public void reverse() {
        reverse(root, null);
    }

    public void add(int val) {
        if (null == root) {
            root = new Node1();
            root.val = val;
        } else {
            add(root, val);
        }
    }

    private void add(Node1 d, int val) {
        if (null == d.next) {
            d.next = new Node1();
            d.next.val = val;
        } else {
            add(d.next, val);
        }
    }

    private void reverse(Node1 node1, Node1 father) {
        Node1 next = node1.next;
        node1.next = father;
        if (null == next) {
            root = node1;
            return;
        }
        reverse(next, node1);
    }

    @Override
    public String toString() {
        Node1 index = root;
        String a = "[";
        while (null != index) {
            a = a + Integer.toString(index.val) + ",";
            index = index.next;
        }
        a = a + "]";
        return a;
    }

    private static class Node1 {
        private int val;
        private Node1 next;
    }

    public static void main(String[] a) {
        List list = new List();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}
