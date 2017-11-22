package com.company;

import com.company.players.Robber;
import com.company.players.Slayer;
import com.company.util.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final Integer SLAYERS_COUNT = 3;
    private static final Integer ROBBER_COUNT = 4;
    private static final Integer SLEEP_SECOND = 20_000;

    static List<Thread> band = new ArrayList<>();

    public static void main(String[] args) {
        startCrime();
        ThreadUtil.sleep(SLEEP_SECOND);

        //вызываем полицию
        System.out.println("Приехала полиция");
        nonViolentStopCrime();
        violentStopCrime();
    }

    private static void startCrime() {
        createSlayers();
        createRobbers();
        printBandInfo();
        runAll();
    }

    private static void createSlayers() {
        for (int i = 0; i < SLAYERS_COUNT; i++) {
            band.add(new Slayer("Slayer-" + (i + 1)));
        }
    }

    private static void createRobbers() {
        for (int i = 0; i < ROBBER_COUNT; i++) {
            band.add(new Thread(new Robber(), "Robber-" + (i + 1)));
        }
    }

    private static void runAll() {
        for (Thread aBand : band) {
            aBand.start();
        }

//        for (int i = 0; i < band.size(); i++) {
//            band.get(i).start();
//        }
    }

    private static void printBandInfo() {
        System.out.println("--------------------------");
        String bandSize = String.format("Банда состоит из %d %s %s", band.size(), "человек", "!");

        //Напечатать кто в банде
        String bandList = band
                .stream()
                .map(Thread::getName)
                .collect(Collectors.toList())
                .toString();

        System.out.println(bandList);
        System.out.println(bandSize);
        System.out.println("--------------------------");
    }

    private static void nonViolentStopCrime() {
        for (Thread criminal : band) {
            criminal.interrupt();
            ThreadUtil.sleep(100);
        }

    }

    private static void violentStopCrime() {
        for (Thread criminal : band) {
            if (criminal.isAlive()) {
                criminal.stop();
                System.out.println(criminal.getName() + " убит полицией округа " + Thread.currentThread().getName() + "!");
            }
        }
    }

}
