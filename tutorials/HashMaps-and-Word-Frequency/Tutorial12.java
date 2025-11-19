import java.util.*;
import java.io.*;

public class Tutorial12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //create HashMap of major codes, major names
        //"CS" - computer science (key, value) pair
        //"CMPEN" - computer engineering
        //"MATH" - mathematics

        /*
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("CS", "Computer Science"); //CS is the key, computer science is the value
        map.put("CMPEN", "Computer Engineering");
        map.put("MATH", "Mathematics");
        map.put("ENGL", "English");

        //get the major name from a user's major code
        System.out.print("Enter a major code(like CS): ");
        String code = s.nextLine();

        if (map.containsKey(code)) {
            String full = map.get(code);
            System.out.printf("The full name of %s is %s%n", code, full);
        }
        else {
            System.out.printf("%s not found%n", code);
        }

        //loop over all the keys
        for (String key : map.keySet()) {
            //get the value associated with the current key
            String value = map.get(key);
            System.out.printf("The full name of %s is %s%n", key, value);
        }
        */

        //word frequency
        //key: word, value: count of how 

        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();

        try {
            Scanner inFile = new Scanner (new File("decl.txt"));

            while (inFile.hasNext()) {
                String line = inFile.nextLine();
                String[] words = line.split("[\\p{Punct}\\s+]");

                for (int i = 0; i < words.length; i++) {
                    String cur = words[i].toLowerCase();

                    if (cur.length() > 0) {

                    if (wordCounts.containsKey(cur)) {
                        int count = wordCounts.get(cur);
                        wordCounts.put(cur, count+1); //updating the value to be count+1
                    }
                    else {
                        wordCounts.put(cur, 1);
                    }
                    }

                    
                    //update the frequency for this word

                    //not seen word before?

                    //Have seen that word before?
                }

                //update the words on this line
            
            }
            inFile.close();
        } catch (IOException ioe) {
            System.out.println("File IO error");
        }

        //print our results
        System.out.print("Enter a word to search for: ");
        String word = s.nextLine();

        if (wordCounts.containsKey(word)) {
            int count = wordCounts.get(word);
            System.out.printf("%s appears %d times%n", word, count);
        }
        else {
            System.out.printf("%s not found%n", word);
        }

        String mostFreq = "";
        int maxCount = 0;

        for (String cur : wordCounts.keySet()) {
            int curCount = wordCounts.get(cur);

            if (curCount > maxCount) {
                mostFreq = cur;
                maxCount = curCount;
            }
        }
        System.out.printf("The most frequent word was %s which appeared %d times%n", mostFreq, maxCount);
    }
}
