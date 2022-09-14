import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Maximum_Product_Subarray_152 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // Swapping min and max
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public int maxProductMethodTwo(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {
            // if any of left or right become 0 then update it to 1
            left = left == 0 ? 1 : left;
            right = right == 0 ? 1 : right;

            left *= nums[i]; // prefix product
            right *= nums[n - 1 - i]; // suffix product

            ans = Math.max(ans, Math.max(left, right));

        }
        return ans;
    }

    public int maxProductMethodThree(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;
        for (int num : nums) {
            if (num == 0) {
                currMin = 1;
                currMax = 1;
            }
            int tempMax = currMax * num;
            currMax = Math.max(Math.max(tempMax, num * currMin), num);
            currMin = Math.min(Math.min(tempMax, num * currMin), num);
            res = Math.max(res, currMax);
        }
        return res;
    }

    @Test
    public void testMaxProduct() {
        int[] exampleOne = { 2, 3, -2, 4 };
        int exampleOneExpectedResult = 6;
        int[] exampleTwo = { -2, 0, -1 };
        int exampleTwoExpectedResult = 0;

        assertEquals(exampleOneExpectedResult, maxProduct(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxProduct(exampleTwo));

        assertEquals(exampleOneExpectedResult, maxProductMethodThree(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxProductMethodThree(exampleTwo));

        assertEquals(exampleOneExpectedResult, maxProductMethodTwo(exampleOne));
        assertEquals(exampleTwoExpectedResult, maxProductMethodTwo(exampleTwo));
    }
}

/*
 * https://leetcode.com/problems/maximum-product-subarray/
 * Explanation
 * 
 * We have to take account for 0 value, and odd/even number of negative numbers.
 * Multiplying with negative number max will become min and min will become max,
 * as soon as we encounter a negative element we swap max and min.
 * 
 * Case1 :- All the elements are positive : Then your answer will be product of
 * all the elements in the array.
 * Case2 :- Array have positive and negative elements both :
 * If the number of negative elements is even then again your answer will be
 * complete array because on multiplying all the negative numbers it will become
 * positive.
 * If the number of negative elements is odd then you have to remove just one
 * negative element and for that u need to check your subarrays to get the max
 * product.
 * Case3 :- Array also contains 0. We just make the currMin and currMax equals
 * 1, because we might have to make a new subarray after 0
 * 
 * Use temp to re-use the old currMax value
 * 
 * Time: O(n)
 * Space: O(1)
 */