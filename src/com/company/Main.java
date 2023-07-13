package com.company;

public class Main {

    public static void main(String[] args) {
        NinjaTraining ninjaTraining = new NinjaTraining();
        int[][] schedule = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        System.out.println("Max points for Ninja : "+ ninjaTraining.ninjaTraining(3, schedule));
    }
}
