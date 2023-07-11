package com.company;

public class Main {

    public static void main(String[] args) {
//        Fibonacci fibonacci = new Fibonacci();
//        System.out.println("Nth Fibonacci number is : "+fibonacci.findNthFibonacciNumber(8));

        ClimbStairs climbStairs = new ClimbStairs();
//        System.out.println("All ways to reach the Nth Stair : "+ climbStairs.findAllWaysToReachToNthStair(4));
        int[] costs = {1,100,1,1,1,100,1,1,100,1};
        System.out.println("MinCost to climb the stairs : "+ climbStairs.minCostToClimbStairs(costs));
    }
}
