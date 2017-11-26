package com.company.util;

import java.util.Random;

/**
 * @author Edward Kats
 */
public class ThreadUtil {

    public static Integer getSleepTime() {
        int random = new Random().nextInt(5) + 1;
        return random * 1000;
    }
}
