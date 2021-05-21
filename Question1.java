import java.util.List;
import java.util.ArrayList;
import java.io.*;

class Question1 {


//look at making the file more efficient by not having a discarded arraylist it's not necessary, these words don't need
    //to be collected anywhere
    public static void main(String args[]) {

        try{
            // Create an ArrayList to store words that are allowed
            List<String> allowed = new ArrayList<String>();
            List<String> filtered = new ArrayList<String>();
//            List<String> removed = new ArrayList<String>(); removed as redundant

            FileReader reader = new FileReader("google.txt");
            BufferedReader in = new BufferedReader( reader );
            FileReader reader2 = new FileReader("an_article.txt");
            BufferedReader in2 = new BufferedReader( reader2);

            String s;
//          first create the array for the permitted words this array is called 'allowed'
            while ( ( s = in.readLine()) != null ){
//                System.out.println(s);
                String[] a = s.split("\\s");
                for (String word: a){
                    allowed.add(word.toLowerCase());
                }
            }
            //next read each liine in the text that isn't null and split into words which becomes an array 'a'. For each string
            //('word') in a remove the punctuation, then check if it's in the allowed list. If it is add it to the filtered array
            while (( s = in2.readLine()) != null){
                String[] a = s.split("\\s");
                for (String word : a){
                    //code to remove the punctuation from the word - regexp from https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
                    String stripped_word=word.replaceAll("\\p{Punct}", "");
                    if (allowed.contains(stripped_word.toLowerCase())) {
//                        System.out.println("WE got one...");
                        filtered.add(stripped_word);
                        continue;
                    }
                    else {
                            continue;
//                            removed.add(stripped_word);
                        }



                    }
                }




//            System.out.println(splitTest);
//            System.out.println(allowed.size());
            //display the length of the filtered array containing the number of words from the list in the article.
            System.out.println(filtered.size());
//            System.out.println(removed.size());
//            System.out.println(filtered);
//            System.out.println("This is the removed list" + removed);
        }
        catch ( FileNotFoundException e ){
            System.out.println( e );
        }
        catch ( IOException e ) {
            System.out.println( e );
        }





    }

}