package com.sgtslade.algorithms;

import com.sgtslade.memory.Memory;
import com.sgtslade.memory.MemoryFrame;

public interface Runnable {
    void pull(int pullId);
    MemoryFrame toReplace(int pullId);
    void setParent(Memory parent);
    Memory getParent();
}
