import org.junit.jupiter.api.*;

class TextAnalysisTest {
    public TextAnalysis textAnalysis = new TextAnalysis();

    @Test
    void isEmptyStringTest() {
        Assertions.assertTrue(textAnalysis.isEmpty(""));
        Assertions.assertTrue(textAnalysis.isEmpty(null));
        Assertions.assertFalse(textAnalysis.isEmpty("Hello"));
        Assertions.assertFalse(textAnalysis.isEmpty("Hello World!"));
        Assertions.assertFalse(textAnalysis.isEmpty(" "));
    }

    @Test
    void countWordsTest() {
        Assertions.assertEquals(textAnalysis.countWords(""), 0);
        Assertions.assertEquals(textAnalysis.countWords("Hello"), 1);
        Assertions.assertEquals(textAnalysis.countWords("Hello World"), 2);
        Assertions.assertEquals(textAnalysis.countWords("Hello  World!"), 2);
        Assertions.assertEquals(textAnalysis.countWords("  Hello World! "), 2);
    }

    @Test
    void countSpacesTest() {
        Assertions.assertEquals(textAnalysis.countSpaces(""), 0);
        Assertions.assertEquals(textAnalysis.countSpaces(" "), 1);
        Assertions.assertEquals(textAnalysis.countSpaces(" Hello "), 2);
        Assertions.assertEquals(textAnalysis.countSpaces(" Hello World! "), 3);
        Assertions.assertEquals(textAnalysis.countSpaces("     "), 5);
    }

    @Test
    void countVowelsTest() {
        Assertions.assertEquals(textAnalysis.countVowels("abc"), 1);
        Assertions.assertEquals(textAnalysis.countVowels(""), 0);
        Assertions.assertEquals(textAnalysis.countVowels("Hello"), 2);
        Assertions.assertEquals(textAnalysis.countVowels("Hello World"), 3);
        Assertions.assertEquals(textAnalysis.countVowels("bcd"), 0);
    }

    @Test
    void countConsonantsTest() {
        Assertions.assertEquals(textAnalysis.countConsonants("abc"), 2);
        Assertions.assertEquals(textAnalysis.countConsonants(""), 0);
        Assertions.assertEquals(textAnalysis.countConsonants("Hello"), 3);
        Assertions.assertEquals(textAnalysis.countConsonants("Hello World"), 7);
        Assertions.assertEquals(textAnalysis.countConsonants("bcd"), 3);
    }

    @Test
    void countUpperCaseLettersTest() {
        Assertions.assertEquals(textAnalysis.countUpperCaseLetters("ABC"), 3);
        Assertions.assertEquals(textAnalysis.countUpperCaseLetters("Hello World"), 2);
        Assertions.assertEquals(textAnalysis.countUpperCaseLetters(""), 0);
        Assertions.assertEquals(textAnalysis.countUpperCaseLetters("Hello"), 1);
        Assertions.assertEquals(textAnalysis.countUpperCaseLetters("HelloWorld"), 2);
    }

    @Test
    void countLowerCaseLettersTest() {
        Assertions.assertEquals(textAnalysis.countLowerCaseLetters("John"), 3);
        Assertions.assertEquals(textAnalysis.countLowerCaseLetters("World"), 4);
        Assertions.assertEquals(textAnalysis.countLowerCaseLetters(""), 0);
        Assertions.assertEquals(textAnalysis.countLowerCaseLetters("Hello"), 4);
        Assertions.assertEquals(textAnalysis.countLowerCaseLetters("HelloWorld"), 8);
    }

    @Test
    void reverseStringTest() {
        Assertions.assertEquals(textAnalysis.reverseString(""), "");
        Assertions.assertEquals(textAnalysis.reverseString("hello"), "olleh");
        Assertions.assertEquals(textAnalysis.reverseString("Hello"), "olleH");
        Assertions.assertEquals(textAnalysis.reverseString("Hello World! "), "!dlroW olleH");
        Assertions.assertEquals(textAnalysis.reverseString("World ! "), "! dlroW");
    }

    @Test
    void containSubstringIgnoreCaseTest() {
        Assertions.assertTrue(textAnalysis.containSubstringIgnoreCase("Hello", "hello"));
        Assertions.assertTrue(textAnalysis.containSubstringIgnoreCase(" ", " "));
        Assertions.assertTrue(textAnalysis.containSubstringIgnoreCase("", ""));
        Assertions.assertFalse(textAnalysis.containSubstringIgnoreCase("Hello World!", "John"));
        Assertions.assertFalse(textAnalysis.containSubstringIgnoreCase("Hello World!", "?"));
    }

    @Test
    void mostOftenLetterTest() {
        Assertions.assertEquals(textAnalysis.mostOftenLetter(""), "");
        Assertions.assertEquals(textAnalysis.mostOftenLetter("Hello"), "L - 2");
        Assertions.assertEquals(textAnalysis.mostOftenLetter("John"), "Do not exist");
        Assertions.assertEquals(textAnalysis.mostOftenLetter("Hey Hi hello"), "H - 3");
        Assertions.assertEquals(textAnalysis.mostOftenLetter("Hello World"), "L - 3");
    }

    @Test
    void deleteWordFromTextIgnoreCaseTest() {
        Assertions.assertEquals(textAnalysis.deleteWordFromTextIgnoreCase("Hello", "Hello"), "");
        Assertions.assertEquals(textAnalysis.deleteWordFromTextIgnoreCase("", ""), "");
        Assertions.assertEquals(textAnalysis.deleteWordFromTextIgnoreCase("Hello World!", "world"), "Hello !");
        Assertions.assertEquals(textAnalysis.deleteWordFromTextIgnoreCase("Hey!", "Hey"), "!");
        Assertions.assertEquals(textAnalysis.deleteWordFromTextIgnoreCase("John", "john"), "");
    }
}