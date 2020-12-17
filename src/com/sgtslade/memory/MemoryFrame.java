package com.sgtslade.memory;

public class MemoryFrame {
    private int value;
    private int id;

    public MemoryFrame(int value, int id) {
        this.value = value;
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
