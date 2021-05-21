import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<String> Split(List<String> filtered) {
        //sorts elements into subarray
        List<String> S = new ArrayList(filtered);
        List<String> split1 = new ArrayList();
        List<String> split2 = new ArrayList();
        int s1index;
        int s2index;

        List<String> sortedList = new ArrayList();
        int whilecounter = 0;
        int ifcounter = 0;
        int forcounter = 0;
        //first split the intial array in to two approximate halves

        int total_words = filtered.size();
        if (S.size() <1){return};

        //first work out the last index in sublist 1
        int midIndex = Math.floorDiv(S.size(), 2);

        //group 1
        List<String> LeftArray = new ArrayList<>(S.subList(0,midIndex));
        //group 2
        List<String> RightArray = new ArrayList<>(S.subList(midIndex,));

        if (s1index < s2index) {

            sub1Array = filtered.subList(0, s1index + 1);
            sub2Array = filtered.subList(0, total_words - s2index);
//                  the list has been split into two sublists, s1 and s2. Now according to the algorithm from the lecture
//                  they need to keep being split down and split down until there is a list size of 1.
            //need to workout how to split the lists....

            for (int j = 0; j < sub1Array.size() - 1; j++) {
                if ((sub1Array.get(j + 1)).toLowerCase().compareTo((sub1Array.get(j)).toLowerCase()) < 1) {
//                   System.out.println("Hey there!" + ifcounter);
                    String temp = sub1Array.get(j + 1);
                    String temp2 = sub1Array.get(j);
                    sub1Array.set(j + 1, temp2);
                    sub1Array.set(j, temp);

                    ifcounter++;
                }
                forcounter++;
            }
            for (int k = 0; k < sub2Array.size() - 1; k++) {
                if ((sub2Array.get(k + 1)).toLowerCase().compareTo((sub1Array.get(k)).toLowerCase()) < 1) {
//                    System.out.println("Hey there!" + ifcounter);
                    String temp = sub2Array.get(k + 1);
                    String temp2 = sub2Array.get(k);
                    sub2Array.set(k + 1, temp2);
                    sub2Array.set(k + 1, temp);

                    ifcounter++;

                }
                forcounter++;


            }


        }

        ifcounter++;
        System.out.println("If counter is  " + ifcounter + ". Forcounter is " + forcounter);

       return sortedList;
    }
}
