/*
 * https://leetcode.com/problems/container-with-most-water/
 * Explanation:
 * 
 * Using two pointers approach. We take the length of the right and left
 * pointer, and multiply it by the minimum value of the height at left and the
 * height at right, since the minimum value determines how much water we can hold.
 * 
 * If the height at left is smaller than
 * right, we move the left for a potential bigger height. If the left point and
 * the right pointer have equal value, we can move either of them, it doesn't matter.
 * 
 * Brute Force : Consider every single case of area
 * Time: O(n^2), Space: O(1)
 * 
 * Time: O(n)
 * Space: O(1)
 */

package src.test.java.two_pointers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0011_container_with_most_water {
    public int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;
        while (leftPointer < rightPointer) {
            int containerLength = rightPointer - leftPointer;
            int currArea = containerLength * Math.min(height[leftPointer], height[rightPointer]);
            maxArea = Math.max(maxArea, currArea);
            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxArea = 0;
        while (leftPointer < rightPointer) {
            int containerLength = rightPointer - leftPointer;
            if (height[leftPointer] < height[rightPointer]) {
                maxArea = Math.max(maxArea, height[leftPointer] * containerLength);
                leftPointer++;
            } else {
                maxArea = Math.max(maxArea, height[rightPointer] * containerLength);
                rightPointer--;
            }
        }
        return maxArea;
    }

    public int maxAreaBF(int[] height) {
        int maxArea = 0;
        for (int leftPointer = 0; leftPointer < height.length; leftPointer++) {
            for (int rightPointer = leftPointer + 1; rightPointer < height.length; rightPointer++) {
                maxArea = Math.max(maxArea, Math.min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer));
            }
        }
        return maxArea;
    }

    @Test
    public void testMaxArea() {
        int[] testCase1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int testCase1ExpectedResult = 49;
        int[] testCase2 = { 1, 1 };
        int testCase2ExpectedResult = 1;

        assertEquals(testCase1ExpectedResult, maxArea(testCase1));
        assertEquals(testCase2ExpectedResult, maxArea(testCase2));

        assertEquals(testCase1ExpectedResult, maxArea2(testCase1));
        assertEquals(testCase2ExpectedResult, maxArea2(testCase2));

        assertEquals(testCase1ExpectedResult, maxAreaBF(testCase1));
        assertEquals(testCase2ExpectedResult, maxAreaBF(testCase2));
    }
}