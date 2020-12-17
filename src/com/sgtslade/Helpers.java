package com.sgtslade;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Helpers {
    public static int getIndex(int[] where,int what){
        return IntStream.range(0, where.length)
                .filter(i -> what == where[i])
                .findFirst()
                .orElse(-1);
    }

    public static int getDistance(int[] where, int from, int what){
        int[] sub = Arrays.copyOfRange(where,from,where.length);
        return getIndex(sub,what);
    }
}
