package Java;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class _0283_move_zeroes {
    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[currentIndex];
                nums[currentIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void moveZeroesMinWrite(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (insertPos != i) {
                    nums[insertPos] = nums[i];
                    nums[i] = 0;
                }
                insertPos++;
            }
        }
    }

    public void moveZeroesMinWrite2(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;
        while (readIndex < nums.length) {
            if (nums[readIndex] == 0) {
                readIndex++;
                continue;
            }
            if (readIndex != writeIndex) {
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = 0;
            }
            writeIndex++;
            readIndex++;
        }
    }

    public int countMoveZeroesMetaMockInterview(int[] nums) {
        int readIndex = 0;
        int writeIndex = 0;
        while (readIndex < nums.length) {
            if (nums[readIndex] == 0) {
                readIndex++;
                continue;
            }
            if (readIndex != writeIndex) {
                nums[writeIndex] = nums[readIndex];
                nums[readIndex] = 0;
            }
            writeIndex++;
            readIndex++;
        }
        return writeIndex;
    }

    @Test
    public void testZeroes() {
        _0283_move_zeroes sol = new _0283_move_zeroes();
        int[] testCase1 = new int[] { 0, 1, 0, 3, 12 };
        int[] testCase1ExpectedResult = new int[] { 1, 3, 12, 0, 0 };

        sol.moveZeroesMinWrite2(testCase1);

        assertArrayEquals(testCase1ExpectedResult, testCase1);
        assertEquals(3, countMoveZeroesMetaMockInterview(testCase1));
    }
}

/*
 * https://leetcode.com/problems/move-zeroes/
 * Explantion
 * We want to loop through an Array and check for index that doesn't have a 0.
 * We keep an index at the start of the Array
 * and only increment it after we swap it with the current element that is not
 * 0.
 * 
 * Method 1 do an unnessary swap if the element is not 0
 * 
 * Method 2 and 3 do minimum write
 * 
 * Time: O(n), looping through n elements of Array
 * Space: O(1), input array doesn't count, if it does then O(n)
 * 
 * countMoveZeroes was asked during facebook mock, want to return the number of
 * non-zero element, when writeIndex finish updating, it will be at the next
 * index, then we can return it as it will be
 * the number of non zero element
 * 
 * Ask during facebook mock interview
 */