import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import org.junit.Test;

public class Buildings_With_An_Ocean_View_1762 {
    public static void main(String[] args) {
        int[] exampleOne = { 4, 2, 3, 1, 1 };
        Buildings_With_An_Ocean_View_1762 solution = new Buildings_With_An_Ocean_View_1762();
        System.out.println(Arrays.toString(solution.findBuildings(exampleOne)));
    }

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
        int[] exampleOne = new int[] { 4, 2, 3, 1 };
        int[] exampleOneExpectedResult = new int[] { 0, 2, 3 };
        int[] exampleTwo = new int[] { 4, 3, 2, 1 };
        int[] exampleTwoExpectedResult = new int[] { 0, 1, 2, 3 };
        int[] exampleThree = new int[] { 1, 3, 2, 1 };
        int[] exampleThreeExpectedResult = new int[] { 1, 2, 3 };

        assertArrayEquals(exampleOneExpectedResult, findBuildings(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, findBuildings(exampleTwo));
        assertArrayEquals(exampleThreeExpectedResult, findBuildings(exampleThree));

        assertArrayEquals(exampleOneExpectedResult, findBuildingsStack(exampleOne));
        assertArrayEquals(exampleTwoExpectedResult, findBuildingsStack(exampleTwo));
        assertArrayEquals(exampleThreeExpectedResult, findBuildingsStack(exampleThree));
    }
}

/*
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 * Explanation
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
