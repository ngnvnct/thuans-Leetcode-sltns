import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class best_time_to_buy_and_sell_stock_i {
    public static void main(String[] args) {
        int[] exampleOne = new int[] { 7, 1, 5, 3, 6, 4 };
        int[] exampleTwo = new int[] { 7, 6, 4, 3, 1 };
        best_time_to_buy_and_sell_stock_i sol = new best_time_to_buy_and_sell_stock_i();
        System.out.println(sol.maxProfit(exampleOne));
        System.out.println(sol.maxProfit(exampleTwo));
        System.out.println(sol.maxProfitDP(exampleOne));
        System.out.println(sol.maxProfit(exampleTwo));
    }

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
        int[] exampleOne = new int[] { 7, 1, 5, 3, 6, 4 };
        int[] exampleTwo = new int[] { 7, 6, 4, 3, 1 };
        assertEquals(5, maxProfit(exampleOne));
        assertEquals(0, maxProfit(exampleTwo));
        assertEquals(5, maxProfitDP(exampleOne));
        assertEquals(0, maxProfitDP(exampleTwo));
        assertEquals(5, maxProfitBF(exampleOne));
        assertEquals(0, maxProfitBF(exampleTwo));
    }
}

/*
 * Explanation:
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
