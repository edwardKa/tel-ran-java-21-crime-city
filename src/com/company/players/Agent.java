package com.company.players;

import com.company.util.ThreadUtil;

/**
 * @author Edward Kats
 */
public class Agent extends Thread {

    public Agent(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            int random = ThreadUtil.getSleepTime() * 3;
            System.out.println(Thread.currentThread().getName() + " дает взятку полиции и засыпает на " + random);
            try {
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
