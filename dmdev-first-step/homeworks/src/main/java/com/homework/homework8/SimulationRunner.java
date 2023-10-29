package com.homework.homework8;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static com.homework.homework8.Constant.DAY_DURATION_MILLIS;

/**
 * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
 * Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.
 * <p>
 * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки (может быть 1
 * красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).
 * <p>
 * Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
 * Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
 * Если кристаллов нет - ракета улетает пустой.
 * <p>
 * Написать программу, которая симулирует процесс заполнения кристаллов у магов огня и воздуха.
 * Для симуляции принять, что и кристаллы создаются, и ракеты прилетают в одно и то же время - полночь.
 * <p>
 * Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы.
 */

public class SimulationRunner {
    private static final Object LOCK = new Object();
    private static final Object FIRE_MAGE_LOCK = new Object();
    private static final Object AIR_MAGE_LOCK = new Object();

    private static AtomicBoolean hasRaceCompleted = new AtomicBoolean(false);
    private static final int INITIAL_DAY = 1;
    private static AtomicInteger currentDay = new AtomicInteger(INITIAL_DAY);

    private static final Planet planet = new Planet();
    private static final Race fireMages = new Race("Fire Mages");
    private static final Race airMages = new Race("Air Mages");

    public static void main(String[] args) {
        Runnable growCrystals = () -> {
            while (!hasRaceCompleted.get()) {
                synchronized (LOCK) {
                    System.out.println("\nDay " + currentDay.getAndIncrement() + ":");
                    planet.growAndStoreCrystals();
                    System.out.println("Crystals have been grown.");
                }

                synchronized (FIRE_MAGE_LOCK) {
                    System.out.println("Notifying Fire Mages...");
                    FIRE_MAGE_LOCK.notify();
                }

                synchronized (AIR_MAGE_LOCK) {
                    System.out.println("Notifying Air Mages...");
                    AIR_MAGE_LOCK.notify();
                }

                try {
                    System.out.println("Planet is sleeping for a day...");
                    Thread.sleep(DAY_DURATION_MILLIS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Consumer<Race> collectCrystals = currentRace -> {
            Object currentRaceLock = currentRace == fireMages ? FIRE_MAGE_LOCK : AIR_MAGE_LOCK;
            while (!hasRaceCompleted.get()) {
                synchronized (currentRaceLock) {
                    try {
                        currentRaceLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (hasRaceCompleted.get()) {
                        System.out.println(currentRace.getName() + " detected that the other race is completed.");
                        return;
                    }

                    System.out.println(currentRace.getName() + " are collecting crystals...");
                    Crystal[] crystals = planet.collectAndEmptyCrystals();
                    for (Crystal crystal : crystals) {
                        currentRace.collectCrystal(crystal);
                    }
                    System.out.println(currentRace.getName() + " now have " + currentRace.getCollectedCrystalsCount() + " crystals.");

                    if (currentRace.hasCollectedAllCrystals()) {
                        System.out.println(currentRace.getName() + " collected all the crystals first!");
                        hasRaceCompleted.set(true);
                        synchronized (FIRE_MAGE_LOCK) {
                            FIRE_MAGE_LOCK.notify();
                        }
                        synchronized (AIR_MAGE_LOCK) {
                            AIR_MAGE_LOCK.notify();
                        }
                    }
                }
            }
        };

        Thread planetThread = new Thread(growCrystals);
        Thread fireMageThread = new Thread(() -> collectCrystals.accept(fireMages));
        Thread airMageThread = new Thread(() -> collectCrystals.accept(airMages));

        planetThread.start();
        fireMageThread.start();
        airMageThread.start();

        try {
            planetThread.join();
            fireMageThread.join();
            airMageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
