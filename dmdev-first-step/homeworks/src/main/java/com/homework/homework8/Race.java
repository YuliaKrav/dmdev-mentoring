package com.homework.homework8;

import static com.homework.homework8.Constant.TARGET_CRYSTALS_COUNT;

public class Race {
    private String name;
    private int redCrystals = 0;
    private int whiteCrystals = 0;

    public Race(String name) {
        this.name = name;
    }

    public void collectCrystal(Crystal crystal) {
        if (crystal.getColorType() == Crystal.ColorType.RED) {
            redCrystals++;
        } else {
            whiteCrystals++;
        }
    }

    public boolean hasCollectedAllCrystals() {
        return redCrystals >= TARGET_CRYSTALS_COUNT && whiteCrystals >= TARGET_CRYSTALS_COUNT;
    }

    public String getName() {
        return name;
    }

    public String getCollectedCrystalsCount() {
        return "red crystals = " + redCrystals + " white crystals = " + whiteCrystals;
    }
}
