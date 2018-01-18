package com.michaelssss;

/**
 * Created by michaelssss on 2018/1/18.
 */
public class CacheManager {
    private volatile Bucket[] buckets;
    private static final int BUCKET_SIZE = 5;
    private final Object lock = new Object();

    public CacheManager() {
        this.buckets = new Bucket[BUCKET_SIZE];
    }

    public void add(Object key, Object value) {
        int bucketIndex = Math.abs(key.hashCode() % BUCKET_SIZE);
        synchronized (lock) {
            if (null == buckets[bucketIndex]) {
                buckets[bucketIndex] = new Bucket();
            }
        }
        buckets[bucketIndex].add(key, value);
    }

    public Object get(Object key) {
        int bucketIndex = Math.abs(key.hashCode() % BUCKET_SIZE);
        if (null == buckets[bucketIndex])
            return null;
        return buckets[bucketIndex].get(key);
    }
}
