package com.sgtslade.algorithms;

import com.sgtslade.memory.Memory;
import com.sgtslade.memory.MemoryFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract public class Algorithm implements Runnable {
    private Memory parent;
    private String name;
    List<Integer[]> history = new ArrayList<>();

    public void run(){
        for(int i=0;i<parent.getToPull().length;i++){
            pull(i);
            logHistory();
        }
        displayInformation();
    }

    @Override
    public void pull(int pullId) {
        int toPull = parent.getToPull()[pullId];
        if(hasSpace()){
            addFrame(new MemoryFrame(toPull,getParent().getInserts().size()));
        }else if(needsReplacement(toPull)){
            replaceFrame(toReplace(pullId),new MemoryFrame(toPull,getParent().getInserts().size()));
        }
    }

    public boolean needsReplacement(int val){
        return !new ArrayList<>(getParent().getFrames()).stream().map(MemoryFrame::getValue).collect(Collectors.toList()).contains(val);
    }

    public boolean hasSpace(){
        return !(getParent().getFrames().size()==getParent().getFrameSize());
    }

    public Memory getParent() {
        return parent;
    }

    public void replaceFrame(MemoryFrame what, MemoryFrame with){
        int index = getParent().getFrames().indexOf(what);
        getParent().getFrames().set(index,with);
        getParent().getInserts().add(with);
    }

    public void addFrame(MemoryFrame what){
        getParent().getFrames().add(what);
        getParent().getInserts().add(what);
    }

    public void logHistory(){
        history.add(parent.getFrames().stream().map(MemoryFrame::getValue).toArray(Integer[]::new));
    }

    public void displayInformation(){
        System.out.println(getName());
        System.out.println("Page faults - " + getParent().getInserts().size());
    }

    public void setParent(Memory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
