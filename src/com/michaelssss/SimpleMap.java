package com.michaelssss;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michaelssss
 * @since 2017/12/7
 */
public class SimpleMap<T, P> {
    private List<Pair<T, P>>[] buckets;
    private float loadfactory = 0.75f;
    private int bucketSize;
    private int count;

    public SimpleMap() {
        bucketSize = 64;
        buckets = new ArrayList[64];
    }

    public SimpleMap(int initSize) {
        bucketSize = initSize;
        buckets = new ArrayList[initSize];
    }

    public SimpleMap(int initSize, float loadfactory) {
        this(initSize);
        this.loadfactory = loadfactory;
    }

    public void put(T key, P value) {
        int hashCode = key.hashCode();
        if (buckets[(hashCode % bucketSize)] == null || buckets[(hashCode % bucketSize)].isEmpty()) {
            buckets[(hashCode % bucketSize)] = new ArrayList<>();
            buckets[(hashCode % bucketSize)].add(new Pair<>(key, value));
            count++;
        } else {
            boolean found = false;
            for (Pair<T, P> pair : buckets[(hashCode % bucketSize)]) {
                if (pair.key.equals(key)) {
                    pair.value = value;
                    found = true;
                }
            }
            if (!found) {
                buckets[(hashCode % bucketSize)].add(new Pair<>(key, value));
                count++;
            }
        }
        if (loadfactory * count > bucketSize) {
            resize();
        }
    }

    private void resize() {
        int newBucketSeize = bucketSize * 2;
        List<Pair<T, P>>[] buckets = new ArrayList[newBucketSeize];
        for (List<Pair<T, P>> bucket : this.buckets) {
            if (null != bucket) {
                for (Pair<T, P> pair : bucket) {
                    int hashCode = pair.key.hashCode();
                    if (null == buckets[hashCode % newBucketSeize]) {
                        buckets[hashCode % newBucketSeize] = new ArrayList<>();
                    }
                    buckets[hashCode % newBucketSeize].add(pair);
                }
            }
        }
        this.buckets = buckets;
        this.bucketSize = newBucketSeize;
    }

    public P get(T t) {
        P value = null;
        int hashCode = t.hashCode();
        if (null == buckets[(hashCode % bucketSize)] || buckets[(hashCode % bucketSize)].isEmpty()) {
            return null;
        } else {
            for (Pair<T, P> pair : buckets[(hashCode % bucketSize)]) {
                if (pair.key.equals(t)) {
                    value = pair.value;
                    break;
                }
            }
        }
        return value;
    }

    private final static class Pair<T, P> {
        T key;
        P value;

        Pair(T key, P value) {
            this.key = key;
            this.value = value;
        }
    }
}
