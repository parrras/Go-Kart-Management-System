package com.GoKart.controller.algorithms;

import com.GoKart.model.model1;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    
    public List<model1> sortByAge(List<model1> racerList, boolean isDesc) {
        if (racerList == null || racerList.size() <= 1) {
            return racerList;  // Return the list if it's empty or contains only one element
        }
        
        // Step 1: Split the list into two halves
        int mid = racerList.size() / 2;
        List<model1> left = racerList.subList(0, mid);
        List<model1> right = racerList.subList(mid, racerList.size());

        // Step 2: Recursively sort both halves
        left = sortByAge(left, isDesc);
        right = sortByAge(right, isDesc);

        // Step 3: Merge the two sorted halves
        return merge(left, right, isDesc);
    }

    
    private List<model1> merge(List<model1> left, List<model1> right, boolean isDesc) {
        List<model1> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Merge two lists while comparing the Age
        while (i < left.size() && j < right.size()) {
            model1 leftRacer = left.get(i);
            model1 rightRacer = right.get(j);
            
            if (shouldSwap(leftRacer.getage(), rightRacer.getage(), isDesc)) {
                mergedList.add(leftRacer);
                i++;
            } else {
                mergedList.add(rightRacer);
                j++;
            }
        }

        // Add remaining elements from either list
        while (i < left.size()) {
            mergedList.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            mergedList.add(right.get(j));
            j++;
        }

        return mergedList;
    }

    /**
     * Determines whether the current Age should be placed before the other
     * based on the sort order (ascending or descending).
     *
     * @param leftAge the Age from the left sublist
     * @param rightAge the Age from the right sublist
     * @param isDesc true for descending, false for ascending
     * @return true if leftAge should come before rightAge in the sorted list
     */
    private boolean shouldSwap(int leftAge, int rightAge, boolean isDesc) {
        return isDesc ? leftAge > rightAge : leftAge < rightAge;
    }
}
