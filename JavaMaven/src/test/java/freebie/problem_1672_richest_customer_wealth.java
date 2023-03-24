/*
 * https://leetcode.com/problems/richest-customer-wealth/
 * Explanation:
 * 
 * Straight forward problem, loop through each account then calculate the sum,
 * wealth will be the max of current wealth or the new bank account sum.
 * 
 * Time: O(m * n)
 * Space: O(1)
 */

package freebie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class problem_1672_richest_customer_wealth {
    public int maxWealth(int[][] accounts) {
        int wealth = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int num : account) {
                sum += num;
            }
            wealth = Math.max(wealth, sum);
        }
        return wealth;
    }

    @Test
    public void testWealth() {
        int[][] testCase1 = { { 1, 2, 3 }, { 3, 2, 1 } };
        int[][] testCase2 = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
        int[][] testCase3 = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };

        assertEquals(6, maxWealth(testCase1));
        assertEquals(10, maxWealth(testCase2));
        assertEquals(17, maxWealth(testCase3));
    }
}