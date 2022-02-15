import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class single_number {
    public int singleNumber(int[] nums) {
        int bitWise = 0;
        for (int num : nums) {
            bitWise ^= num;
        }
        return bitWise;
    }

    @Test
    public void testSingleNumber() {
        int[] expectedOne = {2,2,1};
        int[] expectedTwo = {4,1,2,1,2};
        int[] expectedThree = {1};
        assertEquals(1, singleNumber(expectedOne));
        assertEquals(4, singleNumber(expectedTwo));
        assertEquals(1, singleNumber(expectedThree));
    }
}

/*
Explanation
This is a bit manipulation problem. ^= is XOR, the integer becomes binary representation, and XOR will calculate as
1 ^ 0 = 1
0 ^ 1 = 1
1 ^ 1 = 0
0 ^ 0 = 0
If you XOR the exact same number, they will become 0 in the output.

Time: O(n)
Space: O(1)
*/