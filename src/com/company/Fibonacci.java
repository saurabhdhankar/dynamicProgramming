package com.company;

public class Fibonacci {

    /*
    n => input must be a positive number
    T.C. => O(n)
    S.C. => O(1)
     */
    public int findNthFibonacciNumber(int n) {
        if(n <= 2) {
            return n-1;
        }
        int curr = 1, prev = 0;
        for(int i = 3; i <=n; i++) {
            curr += prev;
            prev = curr-prev;
        }
        return curr;
    }
}
