import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Question1 {

    public static void main(String args[]) {


        try {
            // Create an ArrayList to store words that are allowed
            List<String> allowed = new ArrayList<String>();
            List<String> filtered = new ArrayList<String>();


//            List<String> removed = new ArrayList<String>(); removed as redundant

            FileReader reader = new FileReader("google-10000-english-no-swears.txt");
            BufferedReader in = new BufferedReader(reader);
            FileReader reader2 = new FileReader("test.txt");
            BufferedReader in2 = new BufferedReader(reader2);

            String s;
//          first create the array for the permitted words this array is called 'allowed'
            while ((s = in.readLine()) != null) {
//                System.out.println(s);
                String[] a = s.split("\\s");
                for (String word : a) {
                    allowed.add(word.toLowerCase());
                }
            }
            //next read each line in the text that isn't null and split into words which becomes an array 'a'. For each string
            //('word') in a remove the punctuation, then check if it's in the allowed list. If it is add it to the filtered array
            while ((s = in2.readLine()) != null) {
                String[] a = s.split("\\s");
                for (String word : a) {
                    //code to remove the punctuation from the word - regexp from https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
                    String stripped_word = word.replaceAll("\\p{Punct}", "");
                    if (allowed.contains(stripped_word.toLowerCase())) {
//                        System.out.println("WE got one...");
                        filtered.add(stripped_word);
                        continue;
                    } else {
                        continue;
//                            removed.add(stripped_word);
                    }

                }
            }
            //creating a copy of the unordered list so that the complete filter time can be tested as well as partial
            List<String> copyfiltered = new ArrayList<String>(filtered);
            List<String> copyfiltered2 = new ArrayList<String>(filtered);
//


            System.out.println(filtered.size() + " is the number of matching words in the text file.");
//                    long start = System.nanoTime();
////                    sortGivenArray(filtered);
//                    long end = System.nanoTime();
//                    long timetaken = end - start;
//                    System.out.println("The time taken was " + timetaken + "ns in total. \nWithout stepping through to check time.");
//                    //start timing for complete list
            mergeSorting(filtered, filtered.size());
            System.out.println(filtered);


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }



    }
    public static void mergeSorting(List<String> S, int n) {
        //if base case condition has been met

        int midpoint = n/2;
        //setting the initial capacities of the list to half the size of the list to be sorted
        List<String> left = new ArrayList<String>();
        List<String> right = new ArrayList<String>();
        //adding on the left side
        if (n < 2) {
            return;
        }

        for (int i = 0; i < midpoint; i++) {
            left.add(i, S.get(i));
            System.out.println("I'm adding to the left");
            System.out.println(left + "***LEFT***");
        }
        //adding on the right side
        for (int i = midpoint; i < n; i++) {
            right.add(i - midpoint, S.get(i));
            System.out.println("I'm adding to the right");
            System.out.println(right + "****RIGHT****");

        }
        //now for the recursion
        mergeSorting(left, midpoint);
        mergeSorting(right, n - midpoint);
        System.out.println(left +"and " + right);
        merge(S, left, right);
    }

    //the merge method takes the sublists and compares the elements in the left and right sublists one by one
    //The rest of the elements ????
    public static void merge(List<String> S, List<String> left, List<String> right) {
        //setting up the variables
        List<String> addingtoList = new ArrayList<>();
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        //comparing the parts in the sublists
        while (firstHalfIndex < left.size() && secondHalfIndex < right.size()) {
            if ((left.get(firstHalfIndex)).compareToIgnoreCase((right.get(secondHalfIndex))) < 0) {
                addingtoList.add(mergeIndex, left.get(firstHalfIndex));
                firstHalfIndex++;

                System.out.println(addingtoList);

            } else if (secondHalfIndex < right.size()) {
                addingtoList.add(mergeIndex, right.get(secondHalfIndex));
                secondHalfIndex++;
                System.out.println(addingtoList);
            }
            mergeIndex++;

        }
        //either of the below while loop will execute
        while (firstHalfIndex < left.size()) {
            addingtoList.add(left.get(firstHalfIndex));
            firstHalfIndex++;

        }
        if (firstHalfIndex < left.size()) {
            while (mergeIndex < S.size()) {
                addingtoList.add(mergeIndex++, right.get(secondHalfIndex++));
                firstHalfIndex++;
            }
            if (secondHalfIndex < right.size()) {
                while (mergeIndex < S.size()) {
                    addingtoList.add(mergeIndex++, right.get(secondHalfIndex++));
                }
            }
//        S=addingtoList;
            System.out.println(addingtoList);
        }

    }
}







