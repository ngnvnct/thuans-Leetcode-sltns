/*
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 * Explanation:
 * 
 * Given the problem, we can loop from right to left, because the one at the
 * left is always going to be an ocean view
 * keep the maximum to the right while traversing
 * 
 * Our initial List will have the right to left index, so when we add it into
 * our result, we have to put the last element of the list as the 0-indexed
 * Can use a stack to make the last loop more readable
 * 
 * Time: O(n)
 * Space: O(n) if the solution is in Java, because we don't know the size of the
 * output array at the begining, we created an extra ArrayList
 * to support O(1) push operation. ArrayList can have at most n values, so for
 * java space is O(n)
 * 
 * Facebook asks this
 * first part was to count how many buildings have an ocean view (the list size)
 * second part was to print the index
 */

package stack_queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class problem_1762_buildings_with_an_ocean_view {
    public int[] findBuildings(int[] heights) {
        List<Integer> temp = new ArrayList<>();
        int maxHeight = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                temp.add(i);
                maxHeight = heights[i];
            }
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(temp.size() - 1 - i);
        }
        return res;
    }

    public int[] findBuildingsStack(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxHeight = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                stack.addFirst(i);
                maxHeight = heights[i];
            }
        }

        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeFirst();
        }
        return res;
    }

    @Test
    public void testOcean() {
        int[] testCase1 = new int[] { 4, 2, 3, 1 };
        int[] testCase1ExpectedResult = new int[] { 0, 2, 3 };
        int[] testCase2 = new int[] { 4, 3, 2, 1 };
        int[] testCase2ExpectedResult = new int[] { 0, 1, 2, 3 };
        int[] testCase3 = new int[] { 1, 3, 2, 1 };
        int[] testCase3ExpectedResult = new int[] { 1, 2, 3 };

        assertArrayEquals(testCase1ExpectedResult, findBuildings(testCase1));
        assertArrayEquals(testCase2ExpectedResult, findBuildings(testCase2));
        assertArrayEquals(testCase3ExpectedResult, findBuildings(testCase3));

        assertArrayEquals(testCase1ExpectedResult, findBuildingsStack(testCase1));
        assertArrayEquals(testCase2ExpectedResult, findBuildingsStack(testCase2));
        assertArrayEquals(testCase3ExpectedResult, findBuildingsStack(testCase3));
    }
}