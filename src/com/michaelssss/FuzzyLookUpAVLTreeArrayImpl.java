package com.michaelssss;

/**
 * 有点难实现了啊
 * @author michaelssss
 * @since 2017/12/13
 */
@Deprecated
public class FuzzyLookUpAVLTreeArrayImpl extends FuzzyLookUpBinaryTreeArrayImpl {
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
        reBalance(root);
    }

    private void reBalance(Node root) {
        int average = calAverage(root);
        if (average == 2) {
            int leftAverage = calAverage(nodes[getLeftIndex(getNodeIndex(root))]);
            if (average * leftAverage > 0) {
                rightRotate(root);
            } else {
                rightRotate(root);
                leftRotate(root);
            }
        } else if (average == -2) {
            int rightAverage = calAverage(nodes[getRightIndex(getNodeIndex(root))]);
            if (rightAverage * average > 0) {
                leftRotate(root);
            } else {
                leftRotate(root);
                rightRotate(root);
            }
        }
    }

    private void rightRotate(Node x) {
        Node pivot = nodes[getLeftIndex(getNodeIndex(x))];
        Node pivotRight = nodes[getRightIndex(getNodeIndex(pivot))];
        nodes[getLeftIndex(getNodeIndex(x))] = pivotRight;
        Node father = findParent(x);
        if (father == x) {
            nodes[0] = pivot;
            nodes[getRightIndex(getNodeIndex(pivot))] = x;
            return;
        }
        nodes[getLeftIndex(getNodeIndex(father))] = pivot;
        nodes[getRightIndex(getNodeIndex(pivot))] = x;
    }

    private void leftRotate(Node x) {
        Node pivot = nodes[getRightIndex(getNodeIndex(x))];
        Node pivotLeft = nodes[getLeftIndex(getNodeIndex(pivot))];
        nodes[getRightIndex(getNodeIndex(x))] = pivotLeft;
        Node father = findParent(x);
        if (father == x) {
            nodes[0] = pivot;
            nodes[getLeftIndex(getNodeIndex(pivot))] = x;
            return;
        }
        nodes[getRightIndex(getNodeIndex(father))] = pivot;
        nodes[getLeftIndex(getNodeIndex(pivot))] = x;
    }

    private int calAverage(Node t) {
        return calNodeDepth(nodes[getLeftIndex(getNodeIndex(t))]) - calNodeDepth(nodes[getRightIndex(getNodeIndex(t))]);
    }

    private int calNodeDepth(Node t) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (null == t) {
            return 0;
        }
        if (nodes[getRightIndex(getNodeIndex(t))] == null && nodes[getLeftIndex(getNodeIndex(t))] == null) {
            return 1;
        }
        if (nodes[getLeftIndex(getNodeIndex(t))] != null) {
            leftDepth = 1 + calNodeDepth(nodes[getLeftIndex(getNodeIndex(t))]);
        }
        if (nodes[getRightIndex(getNodeIndex(t))] != null) {
            rightDepth = 1 + calNodeDepth(nodes[getRightIndex(getNodeIndex(t))]);
        }
        return rightDepth > leftDepth ? rightDepth : leftDepth;
    }

    private Node findParent(Node childNode) {
        int nodeIndex = getNodeIndex(childNode);
        return nodes[(nodeIndex - 1) / 2];
    }

    private void swap(int x, int y) {
        Node tem = nodes[x];
        nodes[x] = nodes[y];
        nodes[y] = tem;
    }
}
