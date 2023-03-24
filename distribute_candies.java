import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class distribute_candies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    @Test
    public void testCandies() {
        assertEquals(3, distributeCandies(new int[] {1,1,2,2,3,3}));
        assertEquals(2, distributeCandies(new int[] {1,1,2,3}));
        assertEquals(1, distributeCandies(new int[] {6,6,6,6}));
    }
}

/*
Explanation

Insert all the candies into a hash set then check with the upper limit n / 2

Time: O(n)
Space: O(n)
*/