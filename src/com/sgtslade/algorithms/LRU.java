package com.sgtslade.algorithms;

import com.sgtslade.memory.MemoryFrame;

import java.util.HashMap;
import java.util.Map;

public class LRU extends Algorithm {
    public LRU(){
        setName("Least recently used");
    }

    @Override
    public MemoryFrame toReplace(int pullId) {
        Map<MemoryFrame,Integer> lastUses = new HashMap<>();
        getParent().getFrames().forEach(memoryFrame -> lastUses.put(memoryFrame,getLastUse(getParent().getToPull(),pullId, memoryFrame.getValue())));
        return lastUses.entrySet().stream().min(Map.Entry.comparingByValue()).get().getKey();
    }

    public int getLastUse(int[] ar, int start, int val){
        for(int i = start;i>0;i--){
            if(ar[i]==val){
                return i;
            }
        }
        return 0;
    }
}
