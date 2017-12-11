package com.michaelssss;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        TestObject testObject = new TestObject("5");
        TestObject testObject1 = new TestObject("4");
        TestObject testObject2 = new TestObject("3");
        TestObject testObject3 = new TestObject("2");
        TestObject testObject4 = new TestObject("1");
        TestObject testObject5 = new TestObject("0");
        TestObject testObject6 = new TestObject("6");
        TestObject testObject7 = new TestObject("7");
        TestObject testObject8 = new TestObject("8");
        TestObject testObject9 = new TestObject("9");

        FuzzyLookUpContainer<TestObject> fuzzyLookUpContainer = new FuzzyLookUpBinarySearchTree<>();
//        SimpleMap<String, TestObject> map = new SimpleMap<>(64, 0.001f);
        fuzzyLookUpContainer.put(testObject);
        fuzzyLookUpContainer.put(testObject1);
        fuzzyLookUpContainer.put(testObject2);
        fuzzyLookUpContainer.put(testObject3);
        fuzzyLookUpContainer.put(testObject4);
        fuzzyLookUpContainer.put(testObject5);
        fuzzyLookUpContainer.put(testObject6);
        fuzzyLookUpContainer.put(testObject7);
        fuzzyLookUpContainer.put(testObject8);
        fuzzyLookUpContainer.put(testObject9);

//        map.put("1", testObject);
//        map.put("2", testObject1);
//        map.put("3", testObject2);
//        map.put("4", testObject3);
//        map.put("5", testObject4);
//        map.put("6", testObject5);
//        System.out.println(map.get("1").equals(testObject));
//        System.out.println(map.get("2").equals(testObject1));
//        System.out.println(map.get("3").equals(testObject2));
//        System.out.println(map.get("4").equals(testObject3));
//        System.out.println(map.get("5").equals(testObject4));
//        System.out.println(map.get("6").equals(testObject5));
        System.out.println(fuzzyLookUpContainer);
    }

    private static class TestObject {
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
}
