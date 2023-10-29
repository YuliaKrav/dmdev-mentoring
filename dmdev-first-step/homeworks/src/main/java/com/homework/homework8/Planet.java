package com.homework.homework8;

import java.util.Random;

/**
 * * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки (может быть 1
 * * красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).
 */

public class Planet {
    private static final int MIN_CRYSTALS = 2;
    private static final int MAX_CRYSTALS = 5;
    private static final Crystal.ColorType[] CRYSTAL_TYPES = Crystal.ColorType.values();

    private Random random = new Random();
    private Crystal[] storedCrystals = new Crystal[0];

    public Crystal[] growAndStoreCrystals() {
        int numberCrystals = MIN_CRYSTALS + random.nextInt(MAX_CRYSTALS - MIN_CRYSTALS + 1);
        storedCrystals = new Crystal[numberCrystals];

        for (int i = 0; i < numberCrystals; i++) {
            Crystal.ColorType randomType = CRYSTAL_TYPES[random.nextInt(CRYSTAL_TYPES.length)];
            storedCrystals[i] = new Crystal(randomType);
        }

        return storedCrystals;
    }

    public Crystal[] collectAndEmptyCrystals() {
        Crystal[] takenCrystals = storedCrystals;
        storedCrystals = new Crystal[0];
        return takenCrystals;
    }
}
