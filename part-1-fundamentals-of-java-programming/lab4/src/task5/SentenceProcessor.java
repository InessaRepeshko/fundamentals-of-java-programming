package task5;

import java.util.Set;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Arrays;

public class SentenceProcessor {
    public static SortedSet<String> processSentence(String sentence) {
        Set<Character> delimiters = new HashSet<>(
                Arrays.asList(' ', '.', ',', ':', ';', '?', '!', '-', '(', ')', '\"', '\''));

        SortedSet<String> words = new TreeSet<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (!delimiters.contains(currentChar)) {
                currentWord.append(currentChar);
            } else {
                if (!currentWord.isEmpty()) {
                    words.add(currentWord.toString().toLowerCase());
                    currentWord.setLength(0);
                }
            }
        }

        if (!currentWord.isEmpty()) {
            words.add(currentWord.toString().toLowerCase());
        }

        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence:\t");
        String inputSentence = scanner.nextLine();

        SortedSet<String> result = processSentence(inputSentence);
        System.out.println(result);
    }
}
