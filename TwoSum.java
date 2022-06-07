import java.util.ArrayList;
import java.util.Collections;

public class TwoSum {
    private ArrayList<Integer> nums;
    private boolean isSorted;

    TwoSum() {
        this.nums = new ArrayList<>();
        this.isSorted = false;
    }

    public void add (int number) {
        this.nums.add(number);
        isSorted = false;
    }

    public boolean find (int value) {
        if (!this.isSorted) {
            Collections.sort(this.nums);
            this.isSorted = true;
        }
        int left = 0;
        int right = this.nums.size() - 1;
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
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.getNums());
        System.out.println(twoSum.find(4));
        System.out.println(twoSum.find(7));
    }
}


/*
https://leetcode.com/problems/two-sum-iii-data-structure-design/
Explanation
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:
TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.
*/