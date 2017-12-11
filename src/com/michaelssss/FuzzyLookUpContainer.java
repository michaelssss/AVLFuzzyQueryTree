package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public interface FuzzyLookUpContainer {
    TestObject[] lookUp(TestObject value);

    boolean put(TestObject t);
}
