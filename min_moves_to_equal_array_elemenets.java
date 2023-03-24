import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class min_moves_to_equal_array_elemenets {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length-1; i > 0; i--) {
            count += nums[i] - nums[0];
        }
        return count;
    }

    public int minMovesMath(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }
        return moves - min * nums.length;
    }

    public int minMovesMathModified(int[] nums) {
        int moves = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }
        return moves;
    }

    @Test
    public void testMoves() {
        int[] one = {1,2,3};
        int[] two = {1,1,1};
        int[] three = {13,18,3,10,35,68,50,20,50};
        assertEquals(3, minMoves(one));
        assertEquals(3, minMovesMath(one));
        assertEquals(3, minMovesMathModified(one));
        assertEquals(0, minMoves(two));
        assertEquals(0, minMovesMath(two));
        assertEquals(0, minMovesMathModified(two));
        assertEquals(240, minMoves(three));
        assertEquals(240, minMovesMath(three));
        assertEquals(240, minMovesMathModified(three));
    }
}


/*
Explanation
The way to break this problem down is instead of equalizing every element, we can sort the array,
we equalizing the array by traversing from the end of the array and subtract by the smallest value, and add it to the count

[3, 10, 13, 18, 20, 35, 50, 68]
(68-3) + (50-3) + (35-3) + (20-3) + (18-3) + (13-3) + (10-3) = 193

Math explanation:
Adding 1 to all elements except one is equivalent to decrementing 1 from a single element. The problem is simplified to find the number of decrement operations
required to equalize all elements of the given array. If the number is large it can lead to overflow
we can do 2 loops, find the min number in one loop, then on the 2nd loop, calculate moves on the fly;

Time: O(nlogn), O(n) for math
Space: O(1)
*/