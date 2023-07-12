package com.company;

import java.util.List;
import java.util.Set;

public class MaximumSumOfNonAdjacentElements {

    /*
    you are given an array list of n integers
    you are supposed to return the maximum sum of the subsequence
    with the constraint that no two elements are adjacent in the given array list
     */

    public int getMaximumSumOfNonAdjacentElementsInArray(List<Integer> nums) {
        return maximumNonAdjacentSum(nums);
    }

    // DP : Tabulation/Bottom-Up => T.C. = O(n) , S.C. = O(1)
    private int maximumNonAdjacentSum(List<Integer> nums) {
        int maxSum = Integer.MIN_VALUE;
        int prevExcl = 0;

        maxSum = Math.max(nums.get(0), prevExcl);

        for(int i = 1; i < nums.size(); i++) {
            int currExcl = maxSum;
            int currIncl = prevExcl + nums.get(i);

            maxSum = Math.max(maxSum, currExcl);
            maxSum = Math.max(maxSum, currIncl);

            prevExcl = currExcl;
        }
        return maxSum;
    }

    // DP : Tabulation/Bottom-Up => T.C. = O(n) , S.C. = O(n)
    private int getMaximumSum(List<Integer> nums) {
        int[][] maxSumArray = new int[nums.size()][2];
        int maxSum = Integer.MIN_VALUE;
        maxSumArray[0][0] = 0;
        maxSumArray[0][1] = nums.get(0);
        maxSum = Math.max(0, nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            maxSumArray[i][0] = maxSum;
            maxSumArray[i][1] = maxSumArray[i-1][0]+nums.get(i);
            maxSum = Math.max(maxSumArray[i][0], maxSumArray[i][1]);
        }
        return  maxSum;
    }


    // Recursion
    private int getMaximumSum(List<Integer> nums, int ind, int currSum, Set<Integer> covered){
        if(ind >= nums.size()) return currSum;

        Integer thisIndex = Integer.MIN_VALUE;
        if(!covered.contains(ind-1)) {
            covered.add(ind);
            thisIndex = Math.max(thisIndex, getMaximumSum(nums, ind+1, currSum+nums.get(ind), covered));
        }
        covered.remove(ind);

        thisIndex = Math.max(thisIndex, getMaximumSum(nums, ind+1, currSum, covered));

        return thisIndex;
    }
}
