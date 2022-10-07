import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Find_Target_Indices_After_Sorting_Array_2089 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> targetIndicesNoSort(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int lessThanTarget = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num < target) {
                lessThanTarget++;
            }
        }

        for (int i = 0; i < count; i++) {
            res.add(lessThanTarget++);
        }
        return res;
    }

    @Test
    public void testFind() {
        int[] exampleOne = { 1, 2, 5, 2, 3 };
        List<Integer> exampleOneExpectedResult = new ArrayList<>(Arrays.asList(1, 2));
        int[] exampleTwo = { 1, 2, 5, 2, 3 };
        List<Integer> exampleTwoExpectedResult = new ArrayList<>(Arrays.asList(3));
        int[] exampleThree = { 1, 2, 5, 2, 3 };
        List<Integer> exampleThreeExpectedResult = new ArrayList<>(Arrays.asList(4));

        assertEquals(exampleOneExpectedResult, targetIndicesNoSort(exampleOne, 2));
        assertEquals(exampleTwoExpectedResult, targetIndicesNoSort(exampleTwo, 3));
        assertEquals(exampleThreeExpectedResult, targetIndicesNoSort(exampleThree, 5));
        
        assertEquals(exampleOneExpectedResult, targetIndices(exampleOne, 2));
        assertEquals(exampleTwoExpectedResult, targetIndices(exampleTwo, 3));
        assertEquals(exampleThreeExpectedResult, targetIndices(exampleThree, 5));
    }
}

/*
 * https://leetcode.com/problems/find-target-indices-after-sorting-array/
 * Explanation
 * 
 * Naive way, sort the array then if the element matches the target then add it
 * into the result
 * 
 * Time: O(nlogn)
 * Space: O(1), output doesn't count else O(n)
 * 
 * Big Brain way
 * [1,2,5,2,3] target = 3
 * we have a count and a less than target variable, if the num matches the
 * target, we increment count, if the num is smaller than target, we update less
 * than
 * 3 variables less than 3, less than = 3
 * 
 * That means if we were to "sort it", there will be 3 elements that come before
 * the target, and the value of less than will be the index that we will insert
 * the "target" value
 * [1,2,2,3,5], since we loop from 0 to count-1, we can update the according
 * index correctly
 * 
 * Time: O(n)
 * Space: O(1), output doesn't count else O(n)
 */