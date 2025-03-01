package com.arsh.spring_assignment1.Question6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubbleSort")
public class BubbleSort implements SortAlgorithm {

    public int[] sort(int[] arr){
        System.out.println("using bubble");
        return new int[0];
    }
}
