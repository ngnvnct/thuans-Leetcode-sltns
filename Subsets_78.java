import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Subsets_78 {
    public static void main(String[] args) {
        Subsets_78 sol = new Subsets_78();
        List<List<Integer>> result = sol.subset(new int[] {1,3});
        System.out.println("Subsets of {1,3}" + result);

        result = sol.subset(new int[] { 1, 5, 3 });
        System.out.println("Subsets of {1,5,3}" + result);
    }

    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(res, current, nums, 0);
        return res;
    }
    public void backtracking(List<List<Integer>> res, List<Integer> current, int[] nums, int currIndex) {
        if (currIndex >= nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        // decision to include nums[i], left branch
        current.add(nums[currIndex]);
        backtracking(res, current, nums, currIndex+1);

        // decision NOT to include nums[i], right branch
        current.remove(current.size()-1);
        backtracking(res, current, nums,currIndex+1);
    }

    @Test
    public void testSubset() {
        List<List<Integer>> testCase1ExpectedResult = List.of(List.of(1), List.of());
        List<List<Integer>> testCase2ExpectedResult = List.of(List.of(1,3,2), List.of(1,3), List.of(1,2), List.of(1), List.of(3,2), List.of(3), List.of(2), List.of());

        assertEquals(testCase1ExpectedResult, subset(new int[] {1}));
        assertEquals(testCase2ExpectedResult, subset(new int[] {1,3,2}));
    }
}

/*
https://leetcode.com/problems/subsets/submissions/
Explanation

A = [1,2,3]

This is a decision tree problem

First Path: 1 or []
1. [1] or []
----------------
Path of [1]
Second Path 2 or []
2. [1,2] or [1]

Path of []
Second Path 2 or []
2. [2] or []
---------------
Path of [1,2]
Third Path 3 or []
3. [1,2,3] or [1,2]

Path of [1]
Third Path 3 or []
3. [1,3] or [1]

Path of [2]
Third Path 3 or []
3. [2,3] or [2]

Path of []
Third Path 3 or []
3. [3] or []

On the "3." path is our solution, 8 subsets all unique

Step by Step for Backtracking
Pick a starting point
While (problem is not solved)
    For each path from the starting point
        check if selected path is safe, is yes select it
        and make recursive call to rest of the problem
        before which undo the current move
    End For
If none of the move works out, return false, NO solution

Time: O(n * 2^n)
Space: O(n) for current list
*/