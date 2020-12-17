package com.sgtslade.algorithms;

import com.sgtslade.Helpers;
import com.sgtslade.memory.MemoryFrame;

import java.util.HashMap;
import java.util.Map;

public class Optim extends Algorithm {
    public Optim(){
        setName("Optim");
    }

    public MemoryFrame toReplace(int pullId){
        Map<MemoryFrame,Integer> distances = new HashMap<>();
        getParent().getFrames().forEach(memoryFrame -> distances.put(memoryFrame, Helpers.getDistance(getParent().getToPull(), pullId,memoryFrame.getValue())));
        return distances.entrySet().stream().max((o1, o2) -> {
            if(o1.getValue() >0 && o2.getValue() >0){
                return Integer.compare(o1.getValue(),o2.getValue());
            }else {
                if(o1.getValue().equals(o2.getValue())){
                    return o2.getKey().getId()-o1.getKey().getId();
                }
                if(o1.getValue()<0){
                    return 1;
                }else {
                    return -1;
                }
            }
        }).get().getKey();
    }


}
