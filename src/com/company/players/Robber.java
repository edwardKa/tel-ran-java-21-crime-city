package com.company.players;

import com.company.util.ThreadUtil;

import java.util.*;


/**
 * @author Edward Kats
 */
public class Robber implements Runnable {
    public static volatile List<Agent> list = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();
        Integer sleepTime = ThreadUtil.getSleepTime();
        while (!currentThread.isInterrupted()) {
            System.out.println(currentThread.getName() + " " + "грабит банк и засыпает на " + sleepTime);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                currentThread.interrupt();
            }
            startAgents();
        }
        System.out.println("Меня зовут " + currentThread.getName() + " и я сдаюсь!");
    }

    public void startAgents() {
        Agent agent = new Agent("Агент " + (list.size() + 1) + " от " + Thread.currentThread().getName());
        agent.setDaemon(true);
        list.add(agent);
        agent.start();

        System.out.println("Агентов в системе " + list.size());
    }

}
