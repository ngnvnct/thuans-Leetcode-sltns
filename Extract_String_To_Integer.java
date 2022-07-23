import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Extract_String_To_Integer {
    public static void main(String[] args) {
        String[] exampleOne = { "A2D", "1B", "3F5", "67FE2", "AA" };
        Extract_String_To_Integer sol = new Extract_String_To_Integer();
        System.out.println(sol.extract(exampleOne).toString());
    }

    public List<Integer> extract(String[] words) {
        List<Integer> res = new ArrayList<>();
        int count;

        for (String word : words) {
            count = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (Character.isDigit(c)) {
                    count = 10 * count + (c - '0');
                    if (count == 0 && i == word.length() - 1 || count == 0 && !Character.isDigit(word.charAt(i + 1))) {
                        res.add(count);
                    }
                } else {
                    if (count != 0) {
                        res.add(count);
                    }
                    count = 0;
                }
            }
            if (count != 0) {
                res.add(count);
            }
        }
        return res;
    }

    @Test
    public void testExtract() {
        assertEquals(new ArrayList<>(Arrays.asList(2, 1, 3, 5, 67, 2)),extract(new String[] { "A2D", "1B", "3F5", "67FE2", "AA" }));
        assertEquals(new ArrayList<>(Arrays.asList(2, 1, 3, 5, 60, 2, 0)),extract(new String[] { "A2D", "1B", "3F5", "60FE2", "A0A" }));
        assertEquals(new ArrayList<>(Arrays.asList(2, 1, 3, 5, 60, 22, 0, 0)),extract(new String[] { "A2D", "1B", "3F5", "60FE022", "A0A0" }));
    }
}

/*
 * Explanation
 * Edge case is when there is multiple numbers that appear in a string "67FE2"
 * or when the last one is a number
 * keep a count variable to continously getting the number, and when it is not a
 * number, you want to add it to the result (using count != 0)
 * if the last character is a number, have to do one last check outside to see
 * if it is a number, then add it to the result
 * 
 * One Edge case that i didn't catch, what if there is only 0 in the string,
 * need the is count equals 0 after the calculation, if it is
 * it only contains 0, so add it in the result
 * Another edge case is leading 0, i don't want that
 * 
 * One potential follow up is, what if i don't want to contain duplicate, use a
 * set.
 * 
 * Time: O(nm)
 * Space: O(1)
 */