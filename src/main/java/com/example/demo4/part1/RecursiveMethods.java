package com.example.demo4.part1;

public class RecursiveMethods {

    // Part 1.1: Recursive sum of the first n positive integers
    public int sum1toN(int n) {
        // Base case: if n is 1, return 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: sum(n) = n + sum(n - 1)
        return n + sum1toN(n - 1);
    }

    // Part 1.2: Recursive power calculation
    public double power(double x, int n) {
        // Base case: if n is 0, return 1
        if (n == 0) {
            return 1.0;
        }
        // Recursive case
        return x * power(x, n - 1);
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        RecursiveMethods rm = new RecursiveMethods();

        // Test sum1toN
        int sumResult = rm.sum1toN(10); // Expect 15 (1+2+3+4+5)
        System.out.println("sum1toN(5) = " + sumResult);

        // Test power
        double powerResult = rm.power(2, 3); // Expect 8.0 (2^3)
        System.out.println("power(2, 3) = " + powerResult);
    }
}
