import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class kids_candies {
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
        int[] one = {2,3,5,1,3};
        List<Boolean> expectedOne = new ArrayList<>(Arrays.asList(true, true, true, false, true));
        int[] two = {4,2,1,1,2};
        List<Boolean> expectedTwo = new ArrayList<>(Arrays.asList(true, false, false, false, false));

        assertEquals(expectedOne, kidsWithCandies(one, 3));
        assertEquals(expectedTwo, kidsWithCandies(two, 1));
    }
}

/*abstract
Explanation

Find the upper limit, then check if adding the extra candies the new candies[i] is bigger than the upper limit

Time: O(n)
Space: O(1)
*/