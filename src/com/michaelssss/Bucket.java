package com.michaelssss;

import java.util.Arrays;

/**
 * Created by michaelssss on 2018/1/18.
 */
public class Bucket {
    private int contentLength;
    private Pair[] contents;
    private final static int MAX_LEN = 16 * 1024 * 1024;
    private Object lock;

    Bucket() {
        this.contents = new Pair[MAX_LEN];
        this.contentLength = 0;
        this.lock = new Object();
    }

    boolean add(Object key, Object value) {
        synchronized (lock) {
            int i = 0;
            while (i < contentLength) {
                if (key.equals(contents[i])) {
                    contents[i].value = value;
                    contents[i].lastUseTimestamp = System.currentTimeMillis();
                }
                i++;
            }
            if (i == contentLength) {
                if (i == MAX_LEN) {
                    sorted();
                    contents[i].lastUseTimestamp = System.currentTimeMillis();
                    contents[i].key = key;
                    contents[i].value = value;
                } else {
                    Pair pair = new Pair();
                    pair.value = value;
                    pair.key = key;
                    pair.lastUseTimestamp = System.currentTimeMillis();
                    contents[i] = pair;
                    contentLength++;
                }
            }
        }
        return true;
    }


    Object get(Object key) {
        Object value = null;
        synchronized (lock) {
            for (int i = 0; i < contentLength; i++) {
                if (contents[i].key.equals(key)) {
                    value = contents[i].value;
                    contents[i].lastUseTimestamp = System.currentTimeMillis();
                    break;
                }
            }
        }
        return value;
    }

    private void sorted() {
        Arrays.sort(contents);
    }
}
