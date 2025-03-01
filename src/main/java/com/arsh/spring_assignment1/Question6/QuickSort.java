package com.arsh.spring_assignment1.Question6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("quickSort")
public class QuickSort implements SortAlgorithm {
    public int[] sort(int[] arr){
        System.out.println("using Quicksort");
        return new int[0];
    }
}
