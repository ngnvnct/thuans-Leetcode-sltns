
/*
 * The exact problem as Building Ocean 1762, AlgoExpert
 * https://leetcode.com/problems/buildings-with-an-ocean-view/
 * Explanation:
 * 
 * Use a Deque, then add elements into it. If it is "EAST" side, then addFirst,
 * the first element in the array will be at the head
 * If it is "WEST" side, then using addLast (Queue-like), the first element in
 * the array will be at the head
 * 
 * Time: O(n)
 * Space: O(n)
 */

package stack_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class problem_9999_sunset_views_expert {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Deque<Integer> stack = new ArrayDeque<>();
        int prev = -1;
        if (direction.equals("EAST")) {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > prev) {
                    prev = buildings[i];
                    stack.addFirst(i);
                }
            }
        } else if (direction.equals("WEST")) {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > prev) {
                    prev = buildings[i];
                    stack.addLast(i);
                }
            }
        }
        return new ArrayList<>(stack);
    }

    @Test
    public void testSunset() {
        int[] testCase1 = new int[] { 3, 5, 4, 4, 3, 1, 3, 2 };
        int[] testCase2 = new int[] { 7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5 };
        int[] testCase3 = new int[] { 10, 11 };
        int[] testCase4 = new int[] { 2, 4 };
        int[] testCase5 = new int[] { 1 };
        int[] testCase6 = new int[0];
        int[] testCase7 = new int[] { 7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5 };
        int[] testCase8 = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] testCase9 = new int[] { 1, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8 };
        int[] testCase10 = new int[] { 20, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8 };

        assertEquals(new ArrayList<>(Arrays.asList(1, 3, 6, 7)), sunsetViews(testCase1, "EAST"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 1)), sunsetViews(testCase1, "WEST"));
        assertEquals(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 11)), sunsetViews(testCase2, "EAST"));
        assertEquals(new ArrayList<>(Arrays.asList(1)), sunsetViews(testCase3, "EAST"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 1)), sunsetViews(testCase4, "WEST"));
        assertEquals(new ArrayList<>(Arrays.asList(0)), sunsetViews(testCase5, "EAST"));
        assertEquals(new ArrayList<>(), sunsetViews(testCase6, "EAST"));
        assertEquals(new ArrayList<>(), sunsetViews(testCase6, "WEST"));
        assertEquals(new ArrayList<>(Arrays.asList(4, 5, 6, 7, 11)), sunsetViews(testCase7, "EAST"));
        assertEquals(new ArrayList<>(Arrays.asList(5)), sunsetViews(testCase8, "EAST"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5)), sunsetViews(testCase8, "WEST"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 6, 10, 13)), sunsetViews(testCase9, "WEST"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 13, 14)), sunsetViews(testCase10, "EAST"));
    }
}
