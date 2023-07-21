package com.company;

public class GridPathSum {

    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
    which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i==0 && j == 0) continue;

                if(i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else if(j == 0) {
                    grid[i][j] += grid[i-1][j];;
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }

    /*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
    which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.
     */
    public int minSumPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i = 1; i < m ; i++){
            grid[i][0] += grid[i-1][0];
        }

        for(int j = 1; j < n ; j++){
            grid[0][j] += grid[0][j-1];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }


    /*
    You have been given an N*M matrix filled with integer numbers,
    find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
     */

    public  int getMaxPathSum(int[][] grid) {
        int n = grid.length;
        if(n < 1) return 0;

        int m = grid[0].length;
        for(int i = 1; i < n; i++) {
            if(m > 1) {
                grid[i][0] += Math.max(grid[i-1][0], grid[i-1][1]);
                grid[i][m-1] += Math.max(grid[i-1][m-2], grid[i-1][m-1]);
            } else {
                grid[i][0] += grid[i-1][0];
            }

            for(int j = 1; j < m-1; j++) {
                int prevMax = Math.max(grid[i - 1][j - 1], grid[i - 1][j]);
                prevMax = Math.max(prevMax, grid[i - 1][j + 1]);
                grid[i][j] += prevMax;
            }
        }
        int maxPathSum = grid[n-1][0];
        for(int j = 0; j < m; j++) {
            maxPathSum = Math.max(maxPathSum, grid[n-1][j]);
        }
        return maxPathSum;
    }

    /*
    You have been given an N*M matrix filled with integer numbers,
    find the minimum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
     */

    public  int getMinPathSum(int[][] grid) {
        int n = grid.length;
        if(n < 1) return 0;

        int m = grid[0].length;
        for(int i = 1; i < n; i++) {
            if(m > 1) {
                grid[i][0] += Math.min(grid[i-1][0], grid[i-1][1]);
                grid[i][m-1] += Math.min(grid[i-1][m-2], grid[i-1][m-1]);
            } else {
                grid[i][0] += grid[i-1][0];
            }

            for(int j = 1; j < m-1; j++) {
                int prevMax = Math.min(grid[i - 1][j - 1], grid[i - 1][j]);
                prevMax = Math.min(prevMax, grid[i - 1][j + 1]);
                grid[i][j] += prevMax;
            }
        }
        int minPathSum = grid[n-1][0];
        for(int j = 0; j < m; j++) {
            minPathSum = Math.min(minPathSum, grid[n-1][j]);
        }
        return minPathSum;
    }
}
