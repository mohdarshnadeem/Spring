package com.arsh.spring_assignment1.Question1;

public class TightCouplingExample {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] arr = {1,3,2,4,6};
        System.out.println(search.binarySearch(arr));
    }
}
