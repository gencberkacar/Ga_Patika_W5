import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Write a sentence..");
        Scanner inp = new Scanner(System.in);
        String rep = inp.nextLine();

        String[] words =rep.split(" ");
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            // Avoid case differences by converting to lowercase
            word = word.toLowerCase();

            // Search for the word in HashMap
            if (wordCounts.containsKey(word)) {
                //If the word is already added, increase its number by one
                int number = wordCounts.get(word);
                wordCounts.put(word, number + 1);
            } else {
                //If the word is added for the first time, initialize its count to 1
                wordCounts.put(word, 1);
            }
        }
        String repeatingWord = null;
        int highestNumber = 0;

        for (HashMap.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > highestNumber) {
                highestNumber = entry.getValue();
                repeatingWord = entry.getKey();
            }
        }

        System.out.println("Most frequent word: " + repeatingWord);
        System.out.println("This word " + highestNumber + " times passing through.");
    }

}