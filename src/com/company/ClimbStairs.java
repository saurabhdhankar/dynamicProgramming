package com.company;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {

    /*
    start from 0th stair and find all ways to reach to Nth stair,
    user can take 1-step or 2-steps at a time
     */
    public int findAllWaysToReachToNthStair(int n) {
        if(n == 0) return 0;
        return findAllWays(n, 0);
    }

    private Map<Integer, Integer> pathsToDestinationCount = new HashMap<>();
    private int findAllWays(int target, int current) {
        if(current > target) return 0;
        if(current == target) return 1;

        if(!pathsToDestinationCount.containsKey(current)) {
            int count = 0;
            count += findAllWays(target, current+1);

            if(current+2 <= target) {
                count += findAllWays(target, current+2);
            }

            pathsToDestinationCount.put(current, count);
        }
        return pathsToDestinationCount.get(current);
    }

}
