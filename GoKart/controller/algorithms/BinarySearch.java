package com.GoKart.controller.algorithms;

import com.GoKart.model.model1;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author paras
 */
public class BinarySearch {

    /**
     * Searches for a racer by their full name using binary search and updates the table.
     *
     * @param searchValue the full name to search for
     * @param racerList the sorted list of model1 objects
     * @param left the starting index of the search range
     * @param right the ending index of the search range
     * @param table the JTable to update with the search result
     */
    public void searchAndUpdateTable(String searchValue, List<model1> racerList, int left, int right, JTable table) {
        model1 foundRacer = searchByFullName(searchValue, racerList, left, right);
        
        // Clear the table and update it with the search result
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing rows
        
        if (foundRacer != null) {
            model.addRow(new Object[] {
                foundRacer.getFullName(),
                foundRacer.getage(),
                foundRacer.getgender(),
                foundRacer.getContact(),
                foundRacer.getkartNo()
            });
        } else {
            System.out.println("Racer not found.");
        }
    }

    /**
     * Searches for a racer by their full name using binary search.
     *
     * @param searchValue the full name to search for
     * @param racerList the sorted list of model1 objects
     * @param left the starting index of the search range
     * @param right the ending index of the search range
     * @return the model1 object if found; otherwise, null
     */
    private model1 searchByFullName(String searchValue, List<model1> racerList, int left, int right) {
        // Base case: If the search range is invalid, return null
        if (right < left) {
            return null;
        }

        // Calculate the mid index
        int mid = (left + right) / 2;

        // Compare the search value with the racer's full name at mid
        int comparison = searchValue.compareToIgnoreCase(racerList.get(mid).getFullName());

        if (comparison == 0) {
            // Match found
            return racerList.get(mid);
        } else if (comparison < 0) {
            // Search in the left half
            return searchByFullName(searchValue, racerList, left, mid - 1);
        } else {
            // Search in the right half
            return searchByFullName(searchValue, racerList, mid + 1, right);
        }
    }
}
