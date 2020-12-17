package com.sgtslade.algorithms;

import com.sgtslade.memory.MemoryFrame;
import java.util.Comparator;

public class FIFO extends Algorithm {
    public FIFO(){
        setName("First in first out");
    }

    public MemoryFrame toReplace(int pullId){
         return getParent().getFrames().stream().min(Comparator.comparing(MemoryFrame::getId)).get();
    }

}
