package com.company;

public class Triangle {

    /*
    Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below.
    More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     */
    public int minPathSum(int[][] triangle) {
        int n = triangle.length;
        if(n < 1) return 0;
        if(n == 1) return triangle[0][0];

        for(int i = 1; i < n; i++) {
            triangle[i][0] += triangle[i-1][0];
            for(int j = 1; j < i; j++) {
                triangle[i][j] += Math.min(triangle[i-1][j-1], triangle[i-1][j]);
            }
            triangle[i][i] += triangle[i-1][i-1];
        }
        int minSum = triangle[n-1][0];
        for(int j = 0; j < n; j++) {
            minSum = Math.min(minSum, triangle[n-1][j]);
        }
        return minSum;
    }
}
