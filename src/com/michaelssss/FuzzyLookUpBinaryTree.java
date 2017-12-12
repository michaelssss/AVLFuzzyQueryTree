package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpBinaryTree extends AbstractFuzzyLookUp implements FuzzyLookUpContainer {
    protected Node root;

    protected void put2TreeInInsertOrder(Node root, TestObject testObject) {
        if (go2Right(root, testObject)) {
            if (isNodeOccupy(root.getRight())) {
                put2TreeInInsertOrder(root.getRight(), testObject);
            } else {
                root.setRight(new Node(testObject, testObject));
            }
        } else {
            if (isNodeOccupy(root.getLeft())) {
                put2TreeInInsertOrder(root.getLeft(), testObject);
            } else {
                root.setLeft(new Node(testObject, testObject));
            }
        }
    }

    protected boolean isNodeOccupy(Node node) {
        return null != node;
    }

    protected Node MidFirstQuery(Node node, TestObject keyWord) {
        if (null == node) return null;
        if (node.getIndex().getA().contains(keyWord.getA())) {
            return node;
        } else {
            if (go2Right(node, keyWord)) {
                return this.MidFirstQuery(node.getRight(), keyWord);
            } else {
                return this.MidFirstQuery(node.getLeft(), keyWord);
            }
        }
    }

    protected boolean go2Right(Node tNode, TestObject keyWord) {
        return keyWord.hashCode() >= tNode.getIndex().hashCode();
    }

    @Override
    public TestObject[] lookUp(TestObject value) {
        Node tNode = MidFirstQuery(this.root, value);
        if (null == tNode) {
            return null;
        }
        return new TestObject[]{tNode.getO()};
    }

    @Override
    public boolean put(TestObject testObject) {
        try {
            if (null == root) {
                root = new Node(testObject, testObject);
            } else {
                put2TreeInInsertOrder(this.root, testObject);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
