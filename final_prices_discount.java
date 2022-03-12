import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

public class final_prices_discount {
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    public int[] finalPricesStack(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i =0; i< prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                prices[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(prices));
        return prices;
    }

    @Test
    public void testPrice() {
        int[] one = {8,4,6,2,3};
        int[] expectedOne = {4,2,4,2,3};
        int[] two = {1,2,3,4,5};
        int[] expectedTwo = {1,2,3,4,5};

        assertArrayEquals(expectedOne, finalPricesStack(one));
        assertArrayEquals(expectedTwo, finalPricesStack(two));
    }
}


/*abstract
Explanation

Brute Force, simple 2 loops and update this discount price as needed

Linear, [8,4,6,2,3]
stack is empty, do nothing, we push the index 0 onto the stack
at prices[0], it is bigger than prices[1], stack pop and subtract from the current price, prices [4,4,6,2,3]
push index 1 onto the stack
prices[1] prices[2], do nothing
push index 2 onto the stack [1,2]
prices[2] > prices[3] - stack pop and subtract [4,4,4,2,3]
prices[1] > prices[3] - stack pop and subtract [4,2,4,2,3]
Do nothing for prices[3] and prices[4]
Final Result: [4,2,4,2,3]

Time: O(n^2) for Brute Force, O(n) for Linear
Space: O(1) for BF and O(n) for Linear
*/