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

    /*
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the floor.
     */
    public int minCostToClimbStairs(int[] costs) {
        int prev1 = 0, prev2 = 0;
        int i = 2;
        for(; i < costs.length; i++) {
            int curr = Math.min(prev1+costs[i-1], prev2+costs[i-2]);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1+costs[i-1], prev2+costs[i-2]);
    }


    /*
    You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
    Once you pay the cost, you can climb 1 to K steps at a time.
    You can either start from the step with index 0, or the step with index 1.
    Return the minimum cost to reach the top of the floor.
     */
    public int minCostToClimbStairs(int[] costs, int k) {
        int[] minCosts = new int[costs.length+1];
        for(int i = 0; i <= costs.length; i++) {
            int minCostI = Integer.MAX_VALUE;;
            for(int j = 1; j <= k; j++) {
                if(i-j >= 0) {
                    minCostI = Math.min(minCostI, minCosts[i-j]+costs[i-j]);
                } else {
                    minCostI = 0;
                }
            }
            minCosts[i] = minCostI;
        }
        return minCosts[costs.length];
    }

}
