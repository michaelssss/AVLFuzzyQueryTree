package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpList extends AbstractFuzzyLookUp implements FuzzyLookUpContainer {
    private Object[] ts;

    public FuzzyLookUpList() {
        ts = new Object[0];
    }

    @Override
    public TestObject[] lookUp(TestObject value) {
        Object[] objects = new Object[0];
        for (Object o : ts) {
            Object[] attributes = accessPublicValue(o);
            for (Object attribute : attributes) {
                if (value.getA().contains(((TestObject) attribute).getA())) {
                    objects = putValue2Arrays(objects, o);
                }
            }
        }
        return (TestObject[]) objects;
    }

    @Override
    public boolean put(TestObject t) {
        try {
            ts = putValue2Arrays(ts, t);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
