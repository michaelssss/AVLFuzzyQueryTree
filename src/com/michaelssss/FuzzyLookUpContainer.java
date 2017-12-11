package com.michaelssss;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public interface FuzzyLookUpContainer<T> {
    T[] lookUp(String value);

    boolean put(T t);
}
