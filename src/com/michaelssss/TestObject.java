package com.michaelssss;

import java.util.Objects;

/**
 * Created by michaelssss on 2017/12/11.
 */
public class TestObject {
    private String a;

    public TestObject(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return Objects.equals(a, that.a);

    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "a='" + a + '\'' +
                '}';
    }
}
