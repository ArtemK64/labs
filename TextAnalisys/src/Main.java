import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String content;
        String inputFileName = "input.txt";
        File file = new File(inputFileName);

        if (!file.exists()) {
            String message = "Can not find a file";
            throw new FileNotFoundException(message);
        }

        Path filePath = Path.of(inputFileName);
        content = Files.readString(filePath);

        System.out.println(content);

        TextAnalysis textAnalysis = new TextAnalysis();

        System.out.println("""
                Choose one option:
                1. Calculate total amount of words
                2. Calculate total amount of spaces
                3. Calculate total amount of vowels
                4. Calculate total amount of consonants
                5. Calculate total amount of upper case letters
                6. Calculate total amount of lower case letters
                7. Return reverse string
                8. Does this text contains substring
                9. Show most often letter
                10. Delete word from text""");

        Scanner keyboard = new Scanner(System.in);
        int inputValue = keyboard.nextInt();

        if (!textAnalysis.isEmpty(content)) {
            switch (inputValue) {
                case 1 -> System.out.println("Total amount of words are " + textAnalysis.countWords(content));
                case 2 -> System.out.println("Total amount of spaces are " + textAnalysis.countSpaces(content));
                case 3 -> System.out.println("Total amount of vowels are " + textAnalysis.countVowels(content));
                case 4 -> System.out.println("Total amount of consonants are " + textAnalysis.countConsonants(content));
                case 5 ->
                        System.out.println("Total amount of upper case letters are " + textAnalysis.countUpperCaseLetters(content));
                case 6 ->
                        System.out.println("Total amount of lower case letters are " + textAnalysis.countLowerCaseLetters(content));
                case 7 -> System.out.println("Reverse string:\n" + textAnalysis.reverseString(content));
                case 8 -> {
                    System.out.print("Substring - ");
                    String inputString = keyboard.next();
                    if (textAnalysis.containSubstringIgnoreCase(content, inputString)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                }
                case 9 -> System.out.println("Most often letter is: " + textAnalysis.mostOftenLetter(content));
                case 10 -> {
                    System.out.println(content);
                    System.out.print("Enter string for delete - ");
                    String inputStringForDelete = keyboard.next();
                    System.out.println(textAnalysis.deleteWordFromTextIgnoreCase(content, inputStringForDelete));
                }
                default -> System.out.println("Incorrect value");
            }
        }
        else {
            System.out.println("File is empty!");
        }
    }
}