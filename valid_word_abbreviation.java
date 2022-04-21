import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class valid_word_abbreviation {

    public static void main(String[] args) {
        valid_word_abbreviation sol = new valid_word_abbreviation();
        String wordOne = "internationalization";
        String abbrOne = "i12iz4n";
        String wordTwo = "apple";
        String abbrTwo = "a2e";

        System.out.println(sol.validWordAbbreviation(wordOne, abbrOne));
        System.out.println(sol.validWordAbbreviation(wordTwo, abbrTwo));

    }

    public boolean validWordAbbreviation(String word, String abbr) {
        if (abbr.length() > word.length()) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        int wordIndex = 0;
        int abbrIndex = 0;

        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            if (word.charAt(wordIndex) == abbr.charAt(abbrIndex)) {
                wordIndex++;
                abbrIndex++;
                continue;
            }

            if (abbr.charAt(abbrIndex) == '0' || !Character.isDigit(abbr.charAt(abbrIndex))) {
                return false;
            }

            int num = 0;
            while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                num = 10 * num + (abbr.charAt(abbrIndex) - '0');
                abbrIndex++;
            }
            wordIndex += num;
        }
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }

    @Test
    public void testAbbr() {
        String wordOne = "internationalization";
        String abbrOne = "i12iz4n";
        String wordTwo = "apple";
        String abbrTwo = "a2e";
        String wordThree = "substitution";
        String abbrThree = "s10n";
        String abbrThree2 = "sub4u4";
        String abbrThree3 = "12";
        String abbrThree4 = "su3i1u2on";
        String abbrThree5 = "s55n";
        String abbrThree6 = "s010n";

        assertEquals(true, validWordAbbreviation(wordOne, abbrOne));
        assertEquals(false, validWordAbbreviation(wordTwo, abbrTwo));
        assertEquals(true, validWordAbbreviation(wordThree, abbrThree));
        assertEquals(true, validWordAbbreviation(wordThree, abbrThree2));
        assertEquals(true, validWordAbbreviation(wordThree, abbrThree3));
        assertEquals(true, validWordAbbreviation(wordThree, abbrThree4));
        assertEquals(false, validWordAbbreviation(wordThree, abbrThree5));
        assertEquals(false, validWordAbbreviation(wordThree, abbrThree6));
    }
}

/*
Explanation

Two base cases, word length is 0 and abbr length is greater than word length

Have two indexes to keep track of the String word and String abbr
While loop and only terminate if both of them are greater than the length of word and abbr
Inside it have a bunch of conditions to check
If they have the same characters, increment index and continue.

If it falls to here, we have to check
1. Is abbr has leading '0' or it is not a digit, return false

2. Then, we want to calculate the digit in abbr
do num = 0 and num = 10 * num + (abbr.charAt(index) - '0')

at the end of the while loop, we increment the word index
substition
s10n
wordIndex = 11 afterward

Time: O(n) where n is the length of abbreviation
Space: O(n + m) if counting the input string, otherwise O(1)
*/