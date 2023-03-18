/*
 * https://leetcode.com/problems/trapping-rain-water/
 * Explanation:
 * 
 * maxLeft = 0,1,2,3
 * maxRight = 1,2
 * [L,L,L,L,L,L,L,L,R,R,R,R] <--- Pointer
 * [0,1,0,2,1,0,1,3,2,1,2,1] <--- Input
 * [0,0,1,0,1,2,1,0,0,1,0,0] <--- Trap Water, 1 + 1 + 2 +1 +1 = 6
 * 
 * 1. We can't have water at the end point, we move our pointer when maxLeft
 * 2. We want the Min(maxLeft, maxRight)
 * 3. We shift the pointer whenever maxLeft < maxRight or vice versa
 * 4. Calculate it, if maxLeft/maxRight subtract by height[left]/height[right]
 * and the result if negative, we set it to 0
 * 5. Code Wise, if you update maxLeft or maxRight, you will never get a
 * negative result
 * 
 * Time: O(n)
 * Space: O(1)
 * 
 * Input [0,1,0,2,1,0,1,3,2,1,2,1]
 * maxLeft [0,1,1,1,2,2,2,3,3,3,3,3]
 * maxRight [3,3,3,3,3,3,3,2,2,2,1,0]
 * 
 * Min(l,r) [0,1,1,2,2,2,2,3,2,2,2,0]
 * Input [0,1,0,2,1,0,1,3,2,1,2,1]
 * Min-Input [0,0,1,0,1,2,1,0,0,1,0,0] = 1 + 1 + 2 + 1 + 1 = 6
 * Calculation (Min(l,r) - heights > 0)
 * Space: O(n)
 */

package src.test.java.two_pointers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0042_trapping_rain_water {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int res = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax - height[left] < 0) {
                    res += 0;
                } else {
                    res += leftMax - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        return res;
    }

    public int trapMemory(int[] height) {
        if (height == null) {
            return 0;
        }
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        rightMax[size - 1] = height[size - 1];
        int ans = 0;
        for (int i = 1; i < size; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = size - 2; i > -1; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < size - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    @Test
    public void testTrap() {
        int[] testCase1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int testCase1ExpectedResult = 6;
        int[] testCase2 = new int[] { 4, 2, 0, 3, 2, 5 };
        int testCase2ExpectedResult = 9;

        assertEquals(testCase1ExpectedResult, trap(testCase1));
        assertEquals(testCase2ExpectedResult, trap(testCase2));

        assertEquals(testCase1ExpectedResult, trapMemory(testCase1));
        assertEquals(testCase2ExpectedResult, trapMemory(testCase2));
    }
}