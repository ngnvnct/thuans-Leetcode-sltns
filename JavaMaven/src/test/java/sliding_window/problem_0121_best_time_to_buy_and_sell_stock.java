/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Explanation:
 * 
 * Using Kadane's Algorithm to keep track of the largest sum array to get the
 * most profit.
 * 
 * This is a DP problem, you can do it with O(n) extra space
 * Brute Force problem, consider all the number, remember i only loops to the
 * 2nd to last index. Time: O(n^2), Space: O(1)
 * 
 * Time: O(n)
 * Space: O(1)
 */

package sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_0121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int price : prices) {
            minBuy = Math.min(minBuy, price);
            maxProfit = Math.max(maxProfit, price - minBuy);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(prices[i], minBuy);
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        return maxProfit;
    }

    public int maxProfitDP(int[] prices) {
        int[] maxProfit = new int[prices.length];
        maxProfit[0] = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuy = Math.min(minBuy, prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minBuy);
        }
        return maxProfit[prices.length - 1];
    }

    public int maxProfitBF(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currProfit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }
        return maxProfit;
    }

    @Test
    public void testBuyStock() {
        int[] testCase1 = new int[] { 7, 1, 5, 3, 6, 4 };
        int testCase1ExpectedResult = 5;
        int[] testCase2 = new int[] { 7, 6, 4, 3, 1 };
        int testCase2ExpectedResult = 0;

        assertEquals(testCase1ExpectedResult, maxProfit(testCase1));
        assertEquals(testCase2ExpectedResult, maxProfit(testCase2));

        assertEquals(testCase1ExpectedResult, maxProfit2(testCase1));
        assertEquals(testCase2ExpectedResult, maxProfit2(testCase2));

        assertEquals(testCase1ExpectedResult, maxProfitDP(testCase1));
        assertEquals(testCase2ExpectedResult, maxProfitDP(testCase2));

        assertEquals(testCase1ExpectedResult, maxProfitBF(testCase1));
        assertEquals(testCase2ExpectedResult, maxProfitBF(testCase2));
    }
}
