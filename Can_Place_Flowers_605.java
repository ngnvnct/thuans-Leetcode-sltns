import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Can_Place_Flowers_605 {
    public static void main(String[] args) {
        Can_Place_Flowers_605 Solution = new Can_Place_Flowers_605();
        int[] exampleOne = { 1, 0, 0, 0, 1 };
        System.out.println(Solution.canPlaceFlowersMethodTwo(exampleOne, 1));
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
        int[] exampleOne = { 1, 0, 1 };
        int[] exampleTwo = { 1, 0, 0, 1 };
        int[] exampleThree = { 1, 0, 0, 0, 1 };
        int[] exampleFour = { 0, 0, 1 };
        int[] exampleFive = { 1, 0, 0 };

        assertFalse(canPlaceFlowers(exampleOne, 1));
        assertFalse(canPlaceFlowers(exampleTwo, 1));
        assertTrue(canPlaceFlowers(exampleThree, 1));
        assertTrue(canPlaceFlowers(exampleFour, 1));
        assertTrue(canPlaceFlowers(exampleFive, 1));

        exampleOne = new int[] { 1, 0, 1 };
        exampleTwo = new int[] { 1, 0, 0, 1 };
        exampleThree = new int[] { 1, 0, 0, 0, 1 };
        exampleFour = new int[] { 0, 0, 1 };
        exampleFive = new int[] { 1, 0, 0 };

        assertFalse(canPlaceFlowersMethodTwo(exampleOne, 1));
        assertFalse(canPlaceFlowersMethodTwo(exampleTwo, 1));
        assertTrue(canPlaceFlowersMethodTwo(exampleThree, 1));
        assertTrue(canPlaceFlowersMethodTwo(exampleFour, 1));
        assertTrue(canPlaceFlowersMethodTwo(exampleFive, 1));
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
