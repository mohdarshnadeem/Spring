package com.arsh.spring_assignment1.Question2and3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class QuickSort implements SortAlgorithm{
    public int[] sort(int[] arr){
        System.out.println("using Quicksort");
        return new int[0];
    }
}
