import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class perimeter_triangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length-3; i >= 0; i--) {
            if (nums[i] + nums[i+1] > nums[i+2]) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        return 0;
    }

    @Test
    public void testPerimeter() {
        assertEquals(5, largestPerimeter(new int[] {2,1,2}));
        assertEquals(0, largestPerimeter(new int[] {1,2,1}));
    }
}

/*
https://leetcode.com/problems/largest-perimeter-triangle/
Explanation

The length of any side of a triangle is shorter than the sum of the other two sides. 
Since the array is sorted, we can just check if the longest side > (second longest side) + (third longest side) to get our largest perimeter

Time: O(n)
Space: O(1)
*/