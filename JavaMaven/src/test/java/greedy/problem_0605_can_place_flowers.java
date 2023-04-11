/*
 * https://leetcode.com/problems/can-place-flowers/
 * Explanation:
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

package greedy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class problem_0605_can_place_flowers {
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

    private problem_0605_can_place_flowers sol;
    private int[] testCase1;
    private int[] testCase2;
    private int[] testCase3;
    private int[] testCase4;
    private int[] testCase5;

    @BeforeEach
    public void setUp() {
        sol = new problem_0605_can_place_flowers();
        testCase1 = new int[] { 1, 0, 1 };
        testCase2 = new int[] { 1, 0, 0, 1 };
        testCase3 = new int[] { 1, 0, 0, 0, 1 };
        testCase4 = new int[] { 0, 0, 1 };
        testCase5 = new int[] { 1, 0, 0 };
    }

    @Test
    public void testCanPlaceFlowers() {
        assertFalse(sol.canPlaceFlowers(testCase1, 1));
        assertFalse(sol.canPlaceFlowers(testCase2, 1));
        assertTrue(sol.canPlaceFlowers(testCase3, 1));
        assertTrue(sol.canPlaceFlowers(testCase4, 1));
        assertTrue(sol.canPlaceFlowers(testCase5, 1));
    }

    @Test
    public void testCanPlaceFlowersMethodTwo() {
        assertFalse(sol.canPlaceFlowersMethodTwo(testCase1, 1));
        assertFalse(sol.canPlaceFlowersMethodTwo(testCase2, 1));
        assertTrue(sol.canPlaceFlowersMethodTwo(testCase3, 1));
        assertTrue(sol.canPlaceFlowersMethodTwo(testCase4, 1));
        assertTrue(sol.canPlaceFlowersMethodTwo(testCase5, 1));
    }
}
