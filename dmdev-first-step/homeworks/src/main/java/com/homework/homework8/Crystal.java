package com.homework.homework8;

public class Crystal {
    public enum ColorType {
        RED,
        WHITE
    }

    private ColorType colorType;

    public Crystal(ColorType colorType) {
        this.colorType = colorType;
    }

    public ColorType getColorType() {
        return colorType;
    }
}
