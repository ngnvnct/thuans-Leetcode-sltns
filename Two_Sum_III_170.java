import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class Two_Sum_III_170 {
    private ArrayList<Integer> nums;
    private boolean isSorted;
    public Two_Sum_III_170() {
        this.nums = new ArrayList<Integer>();
        this.isSorted = false;
    }
    
    public void add(int number) {
        this.nums.add(number);
        this.isSorted = false;
    }
    
    public boolean find(int value) {
        if (!this.isSorted) {
            Collections.sort(this.nums);
            this.isSorted = true;
        }
        int left = 0;
        int right = this.nums.size() -1;
        while (left < right) {
            int twoSum = this.nums.get(left) + this.nums.get(right);
            if (twoSum < value) {
                left++;
            } else if (twoSum > value) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getNums() {
        return this.nums;
    }

    public static void main(String[] args) {
        Two_Sum_III_170 twoSum = new Two_Sum_III_170();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.getNums());
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
    }

    @Test
    public void testTwoSum() {
        Two_Sum_III_170 twoSum = new Two_Sum_III_170();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);

        assertEquals(new ArrayList<>(Arrays.asList(1,3,5)),twoSum.getNums());
        assertTrue(twoSum.find(4));
        assertFalse(twoSum.find(7));
    }
}

/*
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/ LC Premium
 * Explanation
 * 
 * Design a data structure that accepts a stream of integers and checks if it
 * has a pair of integers that sum up to a particular value.
 * 
 * Implement the TwoSum class:
 * TwoSum() Initializes the TwoSum object, with an empty array initially.
 * void add(int number) Adds number to the data structure.
 * boolean find(int value) Returns true if there exists any pair of numbers
 * whose sum is equal to value, otherwise, it returns false.
 */