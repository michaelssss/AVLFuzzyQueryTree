package com.michaelssss;

import java.security.SecureRandom;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        final CacheManager cacheManager = new CacheManager();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Random random = new SecureRandom();
                for (int i = 0; i < Integer.MAX_VALUE; i++)
                    cacheManager.add(random.nextInt(), random.nextInt());
            }
        };
        Runnable readRun = new Runnable() {
            @Override
            public void run() {
                Random random = new SecureRandom();
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    cacheManager.get(random.nextInt());
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(readRun);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("done");
        Thread.sleep(50000L);
    }
}
