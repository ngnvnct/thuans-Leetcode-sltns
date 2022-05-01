import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.Test;

public class sunset_views {
    public static void main(String[] args) {
        sunset_views sol = new sunset_views();
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {3,5,4,4,3,1,3,2}, "EAST").toArray()));
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {3, 5, 4, 4, 3, 1, 3, 2}, "WEST").toArray()));
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {10,11}, "EAST").toArray()));
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {2,4}, "WEST").toArray()));
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5}, "EAST").toArray()));
        System.out.println(Arrays.toString(sol.sunsetViews(new int[] {20, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8}, "EAST").toArray()));
    }
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
        int[] one = new int[] {3,5,4,4,3,1,3,2};
        int[] two = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        int[] three = new int[] {7, 1, 7, 8, 9, 8, 7, 6, 5, 4, 2, 5};
        List<Integer> expectedOne = new ArrayList<>(Arrays.asList(1,3,6,7));
        List<Integer> expectedTwo = new ArrayList<>(Arrays.asList(0,1));
        List<Integer> expectedThree = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 11));
        assertEquals(expectedOne, sunsetViews(one, "EAST"));
        assertEquals(expectedTwo, sunsetViews(two, "WEST"));
        assertEquals(expectedThree, sunsetViews(three, "EAST"));
    }
}

/*
Explanation
The exact problem as Building Ocean 1762 https://leetcode.com/problems/buildings-with-an-ocean-view/

Use a Deque, then add elements into it. If it is "EAST" side, then addFirst, the first element in the array will be at the head
If it is "WEST" side, then using addLast (Queue-like), the first element in the array will be at the head

Time: O(n)
Space: O(n)
*/