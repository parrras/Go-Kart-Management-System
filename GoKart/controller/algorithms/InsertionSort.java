package com.GoKart.controller.algorithms;

import com.GoKart.model.model1;
import java.util.List;

/**
 * Insertion Sort implementation for sorting by Full Name.
 */
public class InsertionSort {
    
    /**
     * Sorts a list of model1 objects by their Full Name in ascending or
     * descending order using the Insertion Sort algorithm.
     *
     * @param racerList the list of model1 objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<model1> sortByFullName(List<model1> racerList, boolean isDesc) {
        // Check if the list is null or empty
        if (racerList == null || racerList.isEmpty()) {
            throw new IllegalArgumentException("Racer list cannot be null or empty.");
        }

        // Insertion Sort Algorithm
        for (int i = 1; i < racerList.size(); i++) {
            model1 key = racerList.get(i);  // The element to be inserted
            int j = i - 1;

            // Compare Full Names lexicographically (alphabetical order)
            while (j >= 0 && shouldSwap(racerList.get(j).getFullName(), key.getFullName(), isDesc)) {
                // Move the element one position forward
                racerList.set(j + 1, racerList.get(j));
                j--;
            }

            // Insert the key at the correct position
            racerList.set(j + 1, key);
        }

        return racerList;  // Return the sorted list
    }

    /**
     * Determines whether the current value should replace the current element
     * based on the sort order (ascending/descending).
     *
     * @param current the current Full Name
     * @param key the key Full Name
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should be swapped; false otherwise
     */
    private boolean shouldSwap(String current, String key, boolean isDesc) {
        return isDesc ? current.compareToIgnoreCase(key) < 0 : current.compareToIgnoreCase(key) > 0;
    }
}