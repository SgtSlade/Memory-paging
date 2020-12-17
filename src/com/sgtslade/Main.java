package com.sgtslade;

import com.sgtslade.algorithms.FIFO;
import com.sgtslade.algorithms.LRU;
import com.sgtslade.algorithms.Optim;
import com.sgtslade.memory.Memory;

public class Main {

    public static void main(String[] args) {
        Memory mem = new Memory(3);
        FIFO fifo = new FIFO();
        Optim optim = new Optim();
        LRU lru = new LRU();
        mem.setAlgorithm(lru);
        mem.setToPull(new int[]{7,0,1,2,0,3,0,4,2,3,0,3,2,1,2});
        mem.run();
        mem.setAlgorithm(optim);
        mem.run();
        mem.setAlgorithm(fifo);
        mem.run();
    }
}
