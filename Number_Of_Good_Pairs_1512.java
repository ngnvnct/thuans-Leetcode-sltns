import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Number_Of_Good_Pairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        int identicalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    identicalPairs++;
                }
            }
        }
        return identicalPairs;
    }

    public int numIdenticalPairs2(int[] nums) {
        int identicalPairs = 0;
        int[] countBucket = new int[101];

        for (int num : nums) {
            countBucket[num]++;
        }

        for (int n : countBucket) {
            identicalPairs += (n * (n-1) /2);
        }
        return identicalPairs;
    }

    @Test
    public void testPairs() {
        int[] exampleOne = new int[] {1,2,3,1,1,3};
        int exampleOneExpectedResult = 4;
        int[] exampleTwo = new int[] {1,1,1,1};
        int exampleTwoExpectedResult = 6;
        int[] exampleThree = new int[] {1,2,3};
        int exampleThreeExpectedResult = 0;

        assertEquals(exampleOneExpectedResult, numIdenticalPairs(exampleOne));
        assertEquals(exampleTwoExpectedResult, numIdenticalPairs(exampleTwo));
        assertEquals(exampleThreeExpectedResult, numIdenticalPairs(exampleThree));

        assertEquals(exampleOneExpectedResult, numIdenticalPairs2(exampleOne));
        assertEquals(exampleTwoExpectedResult, numIdenticalPairs2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, numIdenticalPairs2(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/number-of-good-pairs/
 * Explanation
 * 
 * Two for loops or use the math property n(n-1)/2 to determine the number of pairs of a given number of items
 * 
 * Time: O(n^2) or O(n)
 * Space: O(1) or O(100)
 */