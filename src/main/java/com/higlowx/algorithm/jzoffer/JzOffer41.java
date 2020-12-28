package com.higlowx.algorithm.jzoffer;

import java.util.ArrayList;

/**
 * @author Dylan.Li
 * @date 2020/12/28
 */

public class JzOffer41 {

    public int[][] findContinuousSequence(int target) {
        if(target == 1){
            return new int[][]{{1}};
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = target-1;i>1;i--){
            if(target%2==1){
                ArrayList<Integer> a = new ArrayList<Integer>(2);
                a.add(target/2);
                a.add(target/2+1);
                result.add(a);
            }
        }

    }

}
