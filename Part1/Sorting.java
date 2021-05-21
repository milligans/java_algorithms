import java.util.ArrayList;
import java.util.List;

public class Sorting {
    //first part - divide the array list recursively into smaller and smaller lists
    //second part - find the subsolutions to each part
    //third part - construct the final answer from the subsolutions

    public static void mergeSorting(List<String> S, int n) {
        //if base case condition has been met

        int midpoint = n / 2;
        //setting the initial capacities of the list to half the size of the list to be sorted
        List<String> left = new ArrayList<String>(midpoint);
        List<String> right = new ArrayList<String>(n - midpoint);
        //adding on the left side
        if (n == 1) {
            return;
        }

        for (int i = 0; i < midpoint; i++) {
            left.add(i, S.get(i));
        }
        //adding on the right side
        for (int i = midpoint; i < n; i++) {
            right.add(i - midpoint, S.get(i));

        }
        //now for the recursion
        mergeSorting(left, midpoint);
        mergeSorting(right, n - midpoint);
        merge(S, left, right);
    }

    //the merge method takes the sublists and compares the elements in the left and right sublists one by one
    //The rest of the elements ????
    public static void merge(List<String> S, List<String> left, List<String> right) {
        //setting up the variables
        int i = 0, j = 0, k = 0;
        //comparing the parts in the sublists
        while (i < left.size() && j < right.size()) {
            if ((left.get(i)).toLowerCase().compareTo((right.get(j)).toLowerCase()) < 1) {
                S.add(left.get(i));
            } else {
                S.add(right.get(j));
            }

        }
        while (i<left.size()){
            S.add(left.get(i));
        }
        while (j<right.size()){
            S.add(right.get(j));
        }
    }
}
