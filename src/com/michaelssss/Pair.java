package com.michaelssss;

/**
 * Created by michaelssss on 2018/1/18.
 */
public class Pair implements Comparable<Pair> {
    long lastUseTimestamp;
    Object key;
    Object value;

    @Override
    public int compareTo(Pair o) {
        return Long.compare(lastUseTimestamp, o.lastUseTimestamp);
    }
}
