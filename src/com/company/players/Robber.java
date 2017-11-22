package com.company.players;

/**
 * @author Edward Kats
 */
public class Robber implements Runnable {


    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();
        while (!currentThread.isInterrupted()) {
            System.out.println(currentThread.getName() + " " + "грабит банк");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                currentThread.interrupt();
            }
        }
        System.out.println("Меня зовут " + currentThread.getName() + " и я сдаюсь!");
    }

}
