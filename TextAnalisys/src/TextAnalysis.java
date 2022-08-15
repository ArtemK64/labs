public class TextAnalysis {
    public boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }
    public int countWords(String text) {
        String[] arrayOfWords = text.replaceAll(" +", " ").split(" ");
        int wordsCounter = 0;
        for (String word: arrayOfWords) {
            if (!word.isEmpty()) {
                wordsCounter++;
            }
        }
        return wordsCounter;
    }
    public int countSpaces(String text) {
        return text.replaceAll("[^ ]", "").length();
    }
    public int countVowels(String text) {
        return text.toLowerCase().replaceAll("[^aeiou]", "").length();
    }
    public int countConsonants(String text) {
        return text.toLowerCase().replaceAll("[^bcdfghjklmnpqrstvwxyz]", "").length();
    }
    public int countUpperCaseLetters(String text) {
        String[] arrayOfWords = text.split("");
        int countUpperCaseLetters = 0;
        for (String word: arrayOfWords) {
            if (word.matches("[A-Z]")) {
                countUpperCaseLetters++;
            }
        }
        return countUpperCaseLetters;
    }
    public int countLowerCaseLetters(String text) {
        String[] arrayOfWords = text.split("");
        int countLowerCaseLetters = 0;
        for (String word: arrayOfWords) {
            if (word.matches("[a-z]")) {
                countLowerCaseLetters++;
            }
        }
        return countLowerCaseLetters;
    }

    public String reverseString(String text) {
        return new StringBuilder(text).reverse().toString().trim();
    }
    public boolean containSubstringIgnoreCase(String text, String searchString) {
        return text.toLowerCase().contains(searchString.toLowerCase());
    }
    public String mostOftenLetter(String text) {
        if (text.isEmpty()) {
            return text;
        }
        text = text.replaceAll("[^a-zA-Z]", "");
        String[] arrayOfWords = text.split("");
        int count = 0;
        int maxCount = 0;
        String resultLetter = "";

        for (String s1: arrayOfWords) {
            for (String s2: arrayOfWords) {
                if (s1.equalsIgnoreCase(s2)) {
                    count++;
                }
            }
            if (count > maxCount) {
                resultLetter = s1;
                maxCount = count;
            }
            count = 0;
        }
        return maxCount == 1 ? "Do not exist" : resultLetter.toUpperCase() + " - " + maxCount;
    }
    public String deleteWordFromTextIgnoreCase(String text, String word) {
        if (text.isEmpty() || word.isEmpty()) {
            return text;
        }
        String[] arrayOfWords = text.split(" ");
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].equalsIgnoreCase(word)) {
                arrayOfWords[i] = "";
            }
            if (arrayOfWords[i].toLowerCase().replaceAll("\\p{Punct}", "").equals(word.toLowerCase())) {
                arrayOfWords[i] = arrayOfWords[i].substring(arrayOfWords[i].length() - 1);
            }
        }
        return String.join(" ", arrayOfWords);
    }
}