import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class move_zeroes {

    public static void main(String[] args) {
        int[] one = {0,0,0,1,2,3};
        move_zeroes sol = new move_zeroes();
        sol.moveZeroes(one);
        System.out.println(Arrays.toString(one));
    }

    public void moveZeroes(int[] nums) {
        int currentIndex = 0;
        for (int i =0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[currentIndex];
                nums[currentIndex++] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public void moveZeroesMinWrite(int[] nums) {
        int insertPos = 0;
        for (int i =0; i < nums.length; i++) {
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

    public int countMoveZeroes(int[] nums) {
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
        int[] one = {0,1,0,3,12};
        assertEquals(3, countMoveZeroes(one));
    }
}

/*
Explantion:
We want to loop through an Array and check for index that doesn't have a 0. We keep an index at the start of the Array
and only increment it after we swap it with the current element that is not 0.

Method 1 do an unnessary swap if the element is not 0

Method 2 and 3

Time: O(n), looping through n elements of Array
Space: O(1), input array doesn't count, if it does then O(n)

countMoveZeroes was asked during facebook mock, want to return the number of non-zero element, when writeIndex finish updating, it will be at the next index, then we can return it as it will be
the number of non zero element

Ask during facebook mock interview
*/