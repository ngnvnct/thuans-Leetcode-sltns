import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class extract_string_to_integer {
    public static void main(String[] args) {
        String[] one = {"A2D", "1B", "3F5", "67FE2", "AA"};
        extract_string_to_integer sol = new extract_string_to_integer();
        System.out.println(sol.extract(one).toString());
    }

    public List<Integer> extract(String[] words) {
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for (String word : words) {
            count = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    count = 10 * count + (c - '0');
                } else {
                    if (count != 0) {
                        res.add(count);
                        count = 0;
                    }
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
        String[] one = {"A2D", "1B", "3F5", "67FE2", "AA"};
        List<Integer> expected = new ArrayList<>(Arrays.asList(2,1,3,5,67,2));
        assertEquals(expected, extract(one));
    }
}

/*abstract
Explanation
Edge case is when there is multiple numbers that appear in a string "67FE2" or when the last one is a number
keep a count variable to continously getting the number, and when it is not a number, you want to add it to the result (using count != 0)
if the last character is a number, have to do one last check outside to see if it is a number, then add it to the result

Time: O(nm)
Space: O(1)
*/