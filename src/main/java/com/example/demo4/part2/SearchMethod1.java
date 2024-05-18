package com.example.demo4.part2;


import java.util.ArrayList;

public class SearchMethods {

    public int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        // Base case: if beginIdx is greater than endIdx, the key is not in the list
        if (beginIdx > endIdx) {
            return -1;
        }
        // Check if the element at beginIdx is the key
        if (list.get(beginIdx).equals(key)) {
            return beginIdx;
        }
        // Recursive case: search the rest of the list
        return recLinearSearch(list, key, beginIdx + 1, endIdx);
    }

    // Test method
    public static void main(String[] args) {
        SearchMethods sm = new SearchMethods();
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");
        list.add("elderberry");

        int result = sm.recLinearSearch(list, "cherry", 0, list.size() - 1);
        System.out.println("Index of 'cherry': " + result); // Should print 2

        result = sm.recLinearSearch(list, "fig", 0, list.size() - 1);
        System.out.println("Index of 'fig': " + result); // Should print -1
    }

    public int binarySearch(int[] a, int search) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
        int middle = (low + high) / 2;
        if (a[middle] == search) {
        return middle;
        } else if (a[middle] < search) {
        low = middle + 1;
        } else {
        high = middle - 1;
        }
        }
        return -1; // If the element is not found
        }

    public int recursiveBinarySearch(int[] a, int search, int low, int high) {
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
        SearchMethods sm = new SearchMethods();
        int[] a = { 2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600 };

        int index = sm.recursiveBinarySearch(a, 10, 0, a.length - 1);
        System.out.println("Index of 10: " + index); // Should print 3

        index = sm.recursiveBinarySearch(a, 150, 0, a.length - 1);
        System.out.println("Index of 150: " + index); // Should print -1
        }

}
