/*
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 * Explanation:
 * 
 * Find the upper limit, then check if adding the extra candies the new
 * candies[i] is bigger than the upper limit
 * 
 * Time: O(n)
 * Space: O(1)
 */

package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_1431_kids_with_the_greatest_number_of_candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            int extra = candies[i] + extraCandies;
            res.add(extra >= max);
        }
        return res;
    }

    @Test
    public void testCandies() {
        assertEquals(new ArrayList<>(Arrays.asList(true, true, true, false, true)),
                kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
        assertEquals(new ArrayList<>(Arrays.asList(true, false, false, false, false)),
                kidsWithCandies(new int[] { 4, 2, 1, 1, 2 }, 1));
    }
}