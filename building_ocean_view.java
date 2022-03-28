import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class building_ocean_view {
    public static void main(String[] args) {
        int[] one = {4,2,3,1,1};
        building_ocean_view solution = new building_ocean_view();
        //System.out.println(Arrays.toString(solution.findBuildings(one)));
    }
    public int[] findBuildings(int[] heights) {
        List<Integer> temp = new ArrayList<>();
        //Stack<Integer> stack = new Stack<>();
        int maxHeight = -1;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (maxHeight < heights[i]) {
                temp.add(i);
                //stack.add(i);
                maxHeight = heights[i];
            }
        }
        System.out.println("Number of buildings that have an ocean view " + temp.size());

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(temp.size()-1-i);
            //res[i] = stack.pop();
        }
        return res;
    }

    @Test
    public void testOcean() {
        assertArrayEquals(new int[] {0,2,3}, findBuildings(new int[] {4,2,3,1}));
        assertArrayEquals(new int[] {0,1,2,3}, findBuildings(new int[] {4,3,2,1}));
        assertArrayEquals(new int[] {1,2,3}, findBuildings(new int[] {1,3,2,1}));
    }
}


/*
Explanation
Given the problem, we can loop from right to left, because the one at the left is always going to be an ocean view
keep the maximum to the right while traversing

Our initial List will have the right to left index, so when we add it into our result, we have to put the last element of the list as the 0-indexed
Can use a stack to make the last loop more readable

Time: O(n)
Space: O(n) if the solution is in Java, because we don't know the size of the output array at the begining, we created an extra ArrayList
to support O(1) push operation. ArrayList can have at most n values, so for java space is O(n)

Facebook asks this
first part was to count how many buildings have an ocean view (the list size)
second part was to print the index
*/
