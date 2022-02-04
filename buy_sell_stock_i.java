import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class buy_sell_stock_i {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxProfit = 0;
        int minBuy = prices[0];

        for (int price : prices) {
            minBuy = Math.min(minBuy, price);
            maxProfit = Math.max(maxProfit, price-minBuy);
        }
        return maxProfit;
    }

    @Test
    public void testBuyStock() {
        int[] exampleOne = new int[] {7,1,5,3,6,4};
        int expected = 5;
        assertEquals(expected, maxProfit(exampleOne));

        int[] exampleTwo = new int[] {7,6,4,3,1};
        expected = 0;
        assertEquals(expected, maxProfit(exampleTwo));
    }
}

/*
Explanation:
Using Kadane's Algorithm to keep track of the largest sum array to get the most profit. 
*/
