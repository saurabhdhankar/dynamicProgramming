package com.company;

public class GridUniquePaths {
    /*
    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
    The robot can only move either down or right at any point in time.
    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     */
    public int getUniquePaths(int m, int n) {
        int[][] uniquePathsToPoint = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i==0 || j == 0) {
                    uniquePathsToPoint[i][j] = 1;
                } else {
                    uniquePathsToPoint[i][j] = uniquePathsToPoint[i-1][j] + uniquePathsToPoint[i][j-1];
                }
            }
        }
        return uniquePathsToPoint[m-1][n-1];
    }


    /*
    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
    The robot can only move either down or right at any point in time.
    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        long[][] uniquePaths = new long[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    uniquePaths[i][j] = 0l;
                } else {
                    if(i == 0 && j == 0) {
                        if(obstacleGrid[i][j] == 1) return 0;

                        uniquePaths[i][j] = 1l;
                    } else if(i == 0) {
                        uniquePaths[i][j] = uniquePaths[i][j-1];
                    } else if(j == 0) {
                        uniquePaths[i][j] = uniquePaths[i-1][j];
                    } else {
                        uniquePaths[i][j] = uniquePaths[i-1][j] + uniquePaths[i][j-1];;
                    }
                }
            }
        }
        return (int) uniquePaths[m-1][n-1];
    }
}
