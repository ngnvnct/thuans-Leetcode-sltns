import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class container_with_most_water {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int res = 0;
        while (left < right) {
            int containerLength = right-left;
            int area = containerLength * Math.min(heights[left], heights[right]);
            res = Math.max(res,area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while (left < right) {
            int containerWidth = right-left;
            if (height[left] < height[right]) {
                area = Math.max(area, height[left] * containerWidth);
                left++;
            } else {
                area = Math.max(area, height[right] * containerWidth);
                right--;
            }
        }
        return area;
    }

    

    @Test
    public void testMaxArea() {
        int[] exampleOne = {1,8,6,2,5,4,8,3,7};
        int[] exampleTwo = {1,1};
        assertEquals(49, maxArea(exampleOne));
        assertEquals(1, maxArea(exampleTwo));
        assertEquals(49, maxArea2(exampleOne));
        assertEquals(1, maxArea2(exampleTwo));
    }
}

/*abstract
Explanation
Using two pointers approach. We take the length of the right and left pointer, and multiply it by the minimum value of the height at left and the height at right, since the minimum value
determines how much water we can hold. If the height at left is smaller than right, we move the left for a potential bigger height. If the left point and the right pointer have equal value,
we can move either of them, it doesn't matter.

Time: O(n)
Space: O(1)
*/