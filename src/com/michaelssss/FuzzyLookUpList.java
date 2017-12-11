package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class FuzzyLookUpList<T> extends AbstractFuzzyLookUp implements FuzzyLookUpContainer<T> {
    private Object[] ts;

    public FuzzyLookUpList() {
        ts = new Object[0];
    }

    @Override
    public T[] lookUp(String value) {
        Object[] objects = new Object[0];
        for (Object o : ts) {
            Object[] attributes = accessPublicValue(o);
            for (Object attribute : attributes) {
                if (((String) attribute).contains(value)) {
                    objects = putValue2Arrays(objects, o);
                }
            }
        }
        return (T[]) objects;
    }

    @Override
    public boolean put(T t) {
        try {
            ts = putValue2Arrays(ts, t);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
