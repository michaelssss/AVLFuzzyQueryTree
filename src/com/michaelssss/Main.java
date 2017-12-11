package com.michaelssss;

public class Main {

    public static void main(String[] args) {
        FuzzyLookUpContainer fuzzyLookUpContainer = new FuzzyLookUpBinarySearchTree();
        FuzzyLookUpContainer fuzzyLookUpContainer1 = new FuzzyLookUpBinaryTree();
        FuzzyLookUpContainer fuzzyLookUpContainer2 = new FuzzyLookUpList();
        int round = 50000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            TestObject testObject = new TestObject(Integer.toString(i));
            fuzzyLookUpContainer.put(testObject);
        }
        System.out.println("build avl tree cost time: " + Long.toString(System.currentTimeMillis() - begin));
        for (int i = 0; i < round; i++) {
            TestObject testObject = new TestObject(Integer.toString(i));
            fuzzyLookUpContainer1.put(testObject);
        }
        System.out.println("build binary tree cost time: " + Long.toString(System.currentTimeMillis() - begin));
        for (int i = 0; i < round; i++) {
            TestObject testObject = new TestObject(Integer.toString(i));
            fuzzyLookUpContainer2.put(testObject);
        }
        System.out.println("build FuzzyLookUpList cost time: " + Long.toString(System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            fuzzyLookUpContainer.lookUp(new TestObject(Integer.toString(i)));
        }
        System.out.println("avl queryTime:" + Long.toString(System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            fuzzyLookUpContainer1.lookUp(new TestObject(Integer.toString(i)));
        }
        System.out.println("binary queryTime:" + Long.toString(System.currentTimeMillis() - begin));
        begin = System.currentTimeMillis();
        for (int i = 0; i < round; i++) {
            fuzzyLookUpContainer2.lookUp(new TestObject(Integer.toString(i)));
        }
        System.out.println("FuzzyLookUpList queryTime:" + Long.toString(System.currentTimeMillis() - begin));
//        SimpleMap<String, TestObject> map = new SimpleMap<>(64, 0.001f);

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
    }
}
