import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryMap {
    public static void main(String[] args) {

        Map<String, String> dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // 5 words input
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter word: ");
            String word = sc.next();

            System.out.print("Enter meaning: ");
            String meaning = sc.next();

            dictionary.put(word, meaning);
        }

        // search
        System.out.print("Search word: ");
        String search = sc.next();

        if (dictionary.containsKey(search)) {
            System.out.println("Meaning: " + dictionary.get(search));
        } else {
            System.out.println("Word not found in the dictionary");
        }
    }
}