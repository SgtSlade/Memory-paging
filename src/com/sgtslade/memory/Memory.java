package com.sgtslade.memory;

import com.sgtslade.algorithms.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class Memory {
    private List<MemoryFrame> frames = new ArrayList<>();
    private List<MemoryFrame> inserts = new ArrayList<>();
    private final int frameSize;
    private int[] toPull;
    private Algorithm algorithm;

    public Memory(int frameSize){
        this.frameSize = frameSize;
    }

    public List<MemoryFrame> getFrames() {
        return frames;
    }

    public List<MemoryFrame> getInserts() {
        return inserts;
    }

    public int getFrameSize() {
        return frameSize;
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
        algorithm.setParent(this);
    }

    public void run(){
        algorithm.run();
    }

    public int[] getToPull() {
        return toPull;
    }

    public void setToPull(int[] toPull) {
        this.toPull = toPull;
    }
}
