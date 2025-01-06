
package com.GoKart.controller.algorithms;



import com.GoKart.model.model1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paras
 */
public class SelectionSort {
    List<model1> RacerSortList;
    
    

    public SelectionSort() {
        RacerSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of model1 objects by their Kart Number in ascending or
     * descending order.
     *
     * @param racerList the list of model1 objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return the sorted list
     */
    public List<model1> sortByKartNumber(List<model1> racerList, boolean isDesc) {
        this.RacerSortList.clear();
        this.RacerSortList.addAll(racerList);
        if (RacerSortList == null || RacerSortList.isEmpty()) {
            throw new IllegalArgumentException("Racer list cannot be null or empty.");
        }

        for (int i = 0; i < RacerSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(RacerSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(RacerSortList, i, extremumIndex);
            }
        }

        return RacerSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param racerSortList the list of model1 objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<model1> racerSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < racerSortList.size(); j++) {
            if (shouldSwap(racerSortList.get(j).getkartNo(), racerSortList.get(extremumIndex).getkartNo(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for ascending)
     * @return true if the current value should replace the extremum; false otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param racerSortList the list of model1 objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<model1> racerSortList, int i, int j) {
        model1 temp = racerSortList.get(i);
        racerSortList.set(i, racerSortList.get(j));
        racerSortList.set(j, temp);
    }
    
}
