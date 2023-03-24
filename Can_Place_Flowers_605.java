import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Can_Place_Flowers_605 {
    public static void main(String[] args) {
        Can_Place_Flowers_605 Solution = new Can_Place_Flowers_605();
        int[] testCase1 = { 1, 0, 0, 0, 1 };
        System.out.println(Solution.canPlaceFlowersMethodTwo(testCase1, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    flowerbed[i] = 1;
                    n--;
                }
                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean canPlaceFlowersMethodTwo(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
                int next = (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) ? 0 : 1;
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    @Test
    public void testPlaceFlower() {
        int[] testCase1 = { 1, 0, 1 };
        int[] testCase2 = { 1, 0, 0, 1 };
        int[] testCase3 = { 1, 0, 0, 0, 1 };
        int[] testCase4 = { 0, 0, 1 };
        int[] testCase5 = { 1, 0, 0 };

        assertFalse(canPlaceFlowers(testCase1, 1));
        assertFalse(canPlaceFlowers(testCase2, 1));
        assertTrue(canPlaceFlowers(testCase3, 1));
        assertTrue(canPlaceFlowers(testCase4, 1));
        assertTrue(canPlaceFlowers(testCase5, 1));

        testCase1 = new int[] { 1, 0, 1 };
        testCase2 = new int[] { 1, 0, 0, 1 };
        testCase3 = new int[] { 1, 0, 0, 0, 1 };
        testCase4 = new int[] { 0, 0, 1 };
        testCase5 = new int[] { 1, 0, 0 };

        assertFalse(canPlaceFlowersMethodTwo(testCase1, 1));
        assertFalse(canPlaceFlowersMethodTwo(testCase2, 1));
        assertTrue(canPlaceFlowersMethodTwo(testCase3, 1));
        assertTrue(canPlaceFlowersMethodTwo(testCase4, 1));
        assertTrue(canPlaceFlowersMethodTwo(testCase5, 1));
    }
}

/*
 * https://leetcode.com/problems/can-place-flowers/
 * Explanation
 * 
 * Greedy algorithm. If you can place a flower there, do so, and check for edge case
 * Edge Case
 * [1,0,1] no
 * [1,0,0,1] no
 * [1,0,0,0,1] yes
 * 
 * [0,0,1] and [1,0,0], two continous spot
 * JUnit Test, if you do two method, make sure to reinialize the test, since
 * there is a chance the input array will be modify. You can prevent that by cloning an array to make JUnit tests more clean.
 * 
 * Time: O(n)
 * Space: O(1)
 */
