package com.example.demo4.part2;
import java.util.ArrayList;

public class SearchMethod2 {
    private int[] a;
    private int search;
    private int low;
    private int high;

    public int recursiveBinarySearch(int[] a, int search, int low, int high) {
        this.a = a;
        this.search = search;
        this.low = low;
        this.high = high;
        if (low > high) {
            return -1; // Base case: element not found
        }
        int middle = (low + high) / 2;
        if (a[middle] == search) {
            return middle;
        } else if (a[middle] < search) {
            return recursiveBinarySearch(a, search, middle + 1, high);
        } else {
            return recursiveBinarySearch(a, search, low, middle - 1);
        }
    }

    // Test method
    public static void main(String[] args) {
        SearchMethod2 sm = new SearchMethod2();
        int[] a = { 2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600 };

        int index = sm.recursiveBinarySearch(a, 10, 0, a.length - 1);
        System.out.println("Index of 10: " + index); // Should print 3

        index = sm.recursiveBinarySearch(a, 150, 0, a.length - 1);
        System.out.println("Index of 150: " + index); // Should print -1
    }
}

