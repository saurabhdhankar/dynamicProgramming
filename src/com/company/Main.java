package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] grid = {{4, 5}, {3, 7}, {2, 4}};
        NinjaAndHisFriends ninjaAndHisFriends = new NinjaAndHisFriends();


        System.out.println("max chocolates: "+ ninjaAndHisFriends.maximumChocolates(3, 2, grid));
    }
}
