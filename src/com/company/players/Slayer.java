package com.company.players;

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
            System.out.println(currentThread.getName() + " убивает прохожих");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}
