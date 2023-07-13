package com.company;

import java.util.HashMap;
import java.util.Map;

public class NinjaTraining {

    public Map<Integer, Map<Integer, Integer>> maxPointsAtIndex;
    public int ninjaTraining(int n, int points[][]) {
//        maxPointsAtIndex = new HashMap<>();
//        return getMaxPoints(n, points, 0, -1);

        return maxPointsAfterNinjaTraining(n, points);
    }

    // DP : Tabulation/Bottom-Up Approach
    private  int maxPointsAfterNinjaTraining(int n, int[][] points) {
        if(n < 1) return 0;
        Map<Integer, Integer> MaxPointsAtCurrLevel = new HashMap<>();
        for(int i = 0; i < 3; i++) {
            MaxPointsAtCurrLevel.put(i, points[0][i]);
        }

        for(int i = 1; i < n; i++) {
            Map<Integer, Integer> MaxPointsAtNewLevel = new HashMap<>();
            MaxPointsAtNewLevel.put(0, points[i][0]+ Math.max(MaxPointsAtCurrLevel.get(1), MaxPointsAtCurrLevel.get(2)));
            MaxPointsAtNewLevel.put(1, points[i][1]+ Math.max(MaxPointsAtCurrLevel.get(0), MaxPointsAtCurrLevel.get(2)));
            MaxPointsAtNewLevel.put(2, points[i][2]+ Math.max(MaxPointsAtCurrLevel.get(0), MaxPointsAtCurrLevel.get(1)));

            MaxPointsAtCurrLevel = MaxPointsAtNewLevel;
        }

        int maxPoints = MaxPointsAtCurrLevel.get(0);
        maxPoints = Math.max(maxPoints, MaxPointsAtCurrLevel.get(1));
        maxPoints = Math.max(maxPoints, MaxPointsAtCurrLevel.get(2));
        return maxPoints;
    }

    // DP : Memoization/Top-Down Approach
    private int getMaxPoints(int n, int[][] points, int ind, int prev) {
        if(ind >= n) return 0;
        if(!maxPointsAtIndex.containsKey(ind)) {

            Map<Integer, Integer> maxPoints= new HashMap<>();
            for(int i = 0; i < 3; i++){
                maxPoints.put(i, points[ind][i] + getMaxPoints(n, points, ind+1, i));
            }
            maxPointsAtIndex.put(ind, maxPoints);
        }
        int max = 0;
        for(int i = 0; i < 3; i++) {
            if(i != prev){
                max = Math.max(max, maxPointsAtIndex.get(ind).get(i));
            }
        }
        return max;
    }
}
