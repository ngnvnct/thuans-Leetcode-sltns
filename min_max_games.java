import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class min_max_games {
    public int minMaxGame(int[] nums) {
        while (nums.length != 1) {
            int[] newNums = new int[nums.length / 2];

            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
                } else {
                    newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
                }
            }
            nums = newNums;
        }
        return nums[0];
    }

    public int minMaxGameRecursion(int[] nums) {
        while (nums.length != 1) {
            int[] newNums = new int[nums.length / 2];

            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2*i], nums[2*i+1]);
                } else {
                    newNums[i] = Math.max(nums[2*i], nums[2*i+1]);
                }
            }
            return minMaxGame(newNums);
        }
        return nums[0];
    }

    @Test
    public void testSimulation() {
        assertEquals(1, minMaxGame(new int[] {1,3,5,2,4,8,2,2}));
        assertEquals(3, minMaxGame(new int[] {3}));
        assertEquals(1, minMaxGameRecursion(new int[] {1,3,5,2,4,8,2,2}));
        assertEquals(3, minMaxGameRecursion(new int[] {3}));
    }
}

/*
https://leetcode.com/problems/min-max-game/
Explanation

Just Simulate the algorithm, iterative or recursive

Time: O(log n)
Space: O(log n)
*/
