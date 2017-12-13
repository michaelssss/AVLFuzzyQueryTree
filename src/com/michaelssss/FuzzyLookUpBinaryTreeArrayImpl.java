package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/12/12
 */
public class FuzzyLookUpBinaryTreeArrayImpl extends FuzzyLookUpBinaryTree {
    protected Node[] nodes;


    public FuzzyLookUpBinaryTreeArrayImpl() {
        nodes = new Node[64];
        root = nodes[0];
    }

    @Override
    protected Node MidFirstQuery(Node node, TestObject keyWord) {
        if (null == node) return null;
        if (node.getIndex().getA().contains(keyWord.getA())) {
            return node;
        } else {
            if (go2Right(node, keyWord)) {
                return MidFirstQuery(nodes[getRightIndex(getNodeIndex(node))], keyWord);
            } else {
                return MidFirstQuery(nodes[getLeftIndex(getNodeIndex(node))], keyWord);
            }
        }
    }

    @Override
    public boolean put(TestObject testObject) {
        try {
            if (null == nodes[0]) {
                nodes[0] = new Node(testObject, testObject);
            } else {
                put2TreeInInsertOrder(nodes[0], testObject);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    protected void put2TreeInInsertOrder(Node root, TestObject testObject) {
        if (go2Right(nodes[getNodeIndex(root)], testObject)) {
            if (isNodeOccupy(nodes[getRightIndex(getNodeIndex(root))])) {
                put2TreeInInsertOrder(nodes[getRightIndex(getNodeIndex(root))], testObject);
            } else {
                nodes[getRightIndex(getNodeIndex(root))] = new Node(testObject, testObject);
            }
        } else {
            if (isNodeOccupy(nodes[getLeftIndex(getNodeIndex(root))])) {
                put2TreeInInsertOrder(nodes[getLeftIndex(getNodeIndex(root))], testObject);
            } else {
                nodes[getLeftIndex(getNodeIndex(root))] = new Node(testObject, testObject);
            }
        }
    }

    protected int getNodeIndex(Node node) {
        int i = 0;
        for (Node node1 : nodes) {
            if (node1 == node) {
                break;
            }
            i++;
        }
        return i;
    }

    private void resize() {
        Node[] nodes = new Node[this.nodes.length * 2];
        System.arraycopy(this.nodes, 0, nodes, 0, this.nodes.length);
        this.nodes = nodes;
    }

    protected int getLeftIndex(int nodeIndex) {
        while (2 * nodeIndex > nodes.length) {
            resize();
        }
        return 2 * nodeIndex + 1;
    }

    protected int getRightIndex(int nodeIndex) {
        while (2 * nodeIndex + 2 > nodes.length) {
            resize();
        }
        return 2 * nodeIndex + 2;
    }
}
