package com.company.players;

import com.company.util.ThreadUtil;

/**
 * @author Edward Kats
 */
public class Slayer extends Thread {

    public Slayer(String name) {
        super(name);
    }


    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread.isAlive()) {
            Integer sleepTime = ThreadUtil.getSleepTime();
            System.out.println(currentThread.getName() + " убивает прохожих и засыпает на " + sleepTime);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}
