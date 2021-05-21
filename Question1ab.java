import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

class Question1ab {


    //look at making the file more efficient by not having a discarded arraylist it's not necessary, these words don't need
    //to be collected anywhere
    public static void main(String args[]) {

        try {
            // Create an ArrayList to store words that are allowed
            List<String> allowed = new ArrayList<String>();
            List<String> filtered = new ArrayList<String>();
            List<String> mergedSortedArray = new ArrayList<String>();
//            List<String> removed = new ArrayList<String>(); removed as redundant

            FileReader reader = new FileReader("google.txt");
            BufferedReader in = new BufferedReader(reader);
            FileReader reader2 = new FileReader("an_article.txt");
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
            //next read each liine in the text that isn't null and split into words which becomes an array 'a'. For each string
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



            System.out.println(filtered.size());
            sortGivenArray(filtered);
            System.out.println(filtered);


        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
    //https://www.withexample.com/merge-sort-using-arraylist-java-example/#:~:text=So%20here%20is%20another%20sorting,the%20Divide%20and%20Conquer%20paradigm.&text=Conquer%20part%20at%20each%20level,(n)%20at%20each%20level.
    //method adapted from code at the above source
    public static void  sortGivenArray(List<String> inputArray){
        divide(0, inputArray.size()-1, inputArray);

    }
    public static void divide(int startIndex,int endIndex, List<String> inputArray){

        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid, inputArray);
            divide(mid+1, endIndex, inputArray);

            //now use merge the sorted lists together
            merger(startIndex,mid,endIndex, inputArray);

        }
    }

    public static List<String> merger(int startIndex,int midIndex,int endIndex, List<String> inputArray ) {

        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<String> mergedSortedArray = new ArrayList<String>();

        int leftIndex = startIndex;
        int rightIndex = midIndex + 1;

        while (leftIndex <= midIndex && rightIndex <= endIndex) {
            if (inputArray.get(leftIndex).compareTo(inputArray.get(rightIndex)) < 1) {
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            } else {
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while (leftIndex <= midIndex) {
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex <= endIndex) {
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while (i < mergedSortedArray.size()) {
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
        return mergedSortedArray;
    }




}