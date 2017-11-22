package com.company.util;

/**
 * @author Edward Kats
 */
public class ThreadUtil {
    public static void sleep(int milliseconds) {
        Thread currentThread = Thread.currentThread();
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            currentThread.interrupt();
        }
    }
}
