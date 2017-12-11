package com.michaelssss;

import java.lang.reflect.Method;

/**
 * @author michaelssss
 * @since 2017/11/30
 */
public class AbstractFuzzyLookUp {
    protected Object[] accessPublicValue(Object t) {
        Object[] strings = new Object[]{};
        Method[] methods = t.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && !method.getName().contains("Class")) {
                try {
                    Object o = method.invoke(t);
                    if (null != o) {
                        strings = putValue2Arrays(strings, o.toString());
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return strings;
    }

    protected Object[] putValue2Arrays(Object[] strings, Object value) {
        Object[] strings1 = new Object[strings.length + 1];
        System.arraycopy(strings, 0, strings1, 0, strings.length);
        strings1[strings.length] = value;
        return strings1;
    }
}
