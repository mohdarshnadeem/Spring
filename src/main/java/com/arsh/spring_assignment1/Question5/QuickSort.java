package com.arsh.spring_assignment1.Question5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
//@Primary
public class QuickSort implements SortAlgorithm {
    public int[] sort(int[] arr){
        System.out.println("using Quicksort");
        return new int[0];
    }
}
