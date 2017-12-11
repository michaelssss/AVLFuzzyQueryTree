package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpList extends AbstractFuzzyLookUp implements FuzzyLookUpContainer {
    private TestObject[] testObjects;

    public FuzzyLookUpList() {
        testObjects = new TestObject[64];
    }

    @Override
    public TestObject[] lookUp(TestObject value) {
        for (TestObject o : testObjects) {
            if (value.getA().contains(o.getA())) {
                testObjects = new TestObject[]{
                        o
                };
                break;
            }
        }
        return testObjects;
    }

    @Override
    public boolean put(TestObject t) {
        int length = 0;
        int capacity = testObjects.length;
        for (; length < capacity; length++) {
            if (testObjects[length] == null) break;
        }
        if (length == capacity) {
            TestObject[] testObjects = new TestObject[capacity * 2];
            System.arraycopy(this.testObjects, 0, testObjects, 0, length);
            testObjects[length + 1] = t;
            this.testObjects = testObjects;
        } else {
            testObjects[length] = t;
        }
        return true;
    }
}
