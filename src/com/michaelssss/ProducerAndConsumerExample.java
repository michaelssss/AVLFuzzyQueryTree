package com.michaelssss;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author michaelssss
 * @since 2017/12/28
 */
public class ProducerAndConsumerExample {
    private volatile AtomicInteger count = new AtomicInteger(0);
    private final Object readLock = new Object();

    public void get() {
        if (count.get() > 0) {
            int a = count.decrementAndGet();
            System.out.println("consumer| get count=" + a);
        } else {
            try {
                synchronized (readLock) {
                    readLock.wait();
                }
            } catch (InterruptedException e) {
                int a = count.decrementAndGet();
                System.out.println("consumer| get count=" + a);
            }
        }
    }

    public void set() {
        if (count.get() < 5000) {
            int a = count.incrementAndGet();
            synchronized (readLock) {
                readLock.notifyAll();
            }
            System.out.println("producer | set count=" + a);
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] a) {
        ProducerAndConsumerExample lock = new ProducerAndConsumerExample();
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true)
                    lock.set();
            }
        };
        Runnable producer1 = new Runnable() {
            @Override
            public void run() {
                while (true)
                    lock.set();
            }
        };
        Runnable producer2 = new Runnable() {
            @Override
            public void run() {
                while (true)
                    lock.set();
            }
        };
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true)
                    lock.get();
            }
        };
        Thread consumerThread = new Thread(consumer);
        System.out.println("consumer start");
        consumerThread.start();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }
        System.out.println("producer start");
        Thread producerThread = new Thread(producer);
        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        producerThread.start();
        producerThread1.start();
        producerThread2.start();
        try {
            Thread.sleep(50000L);
        } catch (InterruptedException e) {
            System.out.println("end");
        }
    }
}
