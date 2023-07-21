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
}
