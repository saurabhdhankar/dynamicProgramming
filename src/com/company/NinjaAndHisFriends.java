package com.company;

import java.util.Arrays;

public class NinjaAndHisFriends {

    /*
    Ninja has a 'GRID' of size 'R' X 'C'. Each cell of the grid contains some chocolates.
    Ninja has two friends Alice and Bob, and he wants to collect as many chocolates as possible with the help of his friends.
    Initially, Alice is in the top-left position i.e. (0, 0), and Bob is in the top-right place i.e. (0, ‘C’ - 1) in the grid.
    Each of them can move from their current cell to the cells just below them.
    When anyone passes from any cell, he will pick all chocolates in it, and then the number of chocolates in that cell will become zero.
    If both stay in the same cell, only one of them will pick the chocolates in it.

    If Alice or Bob is at (i, j) then they can move to (i + 1, j), (i + 1, j - 1) or (i + 1, j + 1). They will always stay inside the ‘GRID’.
    Your task is to find the maximum number of chocolates Ninja can collect with the help of his friends by following the above rules.
     */

    public int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] mem = new int[r][c][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return findMaxChocolates(r, c, grid, 0, 0, c-1, mem);
    }

    private int findMaxChocolates(int r, int c, int[][] grid, int i, int alice, int bob, int[][][] mem){
        if(alice < 0 || bob < 0 || alice >= c || bob >= c) return -1;

        if(mem[i][alice][bob] == -1){
            int max = 0;
            if(i >= r-1){
                if(alice == bob)
                    return grid[i][alice];

                return grid[i][alice] + grid[i][bob];
            } else {
                for(int j = -1; j <= 1; j++) {
                    for(int k = -1; k <= 1; k++) {
                        int tAlice = alice+j, tBob = bob+k;
                        if(tBob == tAlice){
                            max = Math.max(max, grid[i][alice]+findMaxChocolates(r, c, grid, i+1, tAlice, tBob, mem));
                        } else {
                            max = Math.max(max, grid[i][alice]+grid[i][bob]+findMaxChocolates(r, c, grid, i+1, tAlice, tBob, mem));
                        }
                    }
                }
            }
            mem[i][alice][bob] = max;
        }

        return mem[i][alice][bob];
    }
}
