/*
 * https://leetcode.com/problems/defanging-an-ip-address/description/
 * Explanation:
 * 
 * Method 1 is straight forward. Method 2 is a shortening version of method 1. 
 * Method 3 introduces Deque (Double-Ended Queue), which is another way of solving it
 * 
 * Time: O(n)
 * Space: O(n)
*/

package Java;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_1108_defanging_an_ip_address {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (char c : address.toCharArray())
        {
            if (c == '.') {
                sb.append("[.]");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }

    @Test
    public void testDefangIPaddr() {
        String testCase1 = "1.1.1.1";
        String testCase1ExpectedResult = "1[.]1[.]1[.]1";
        String testCase2 = "255.100.50.0";
        String testCase2ExpectedResult = "255[.]100[.]50[.]0";

        assertEquals(testCase1ExpectedResult, defangIPaddr(testCase1));
        assertEquals(testCase2ExpectedResult, defangIPaddr(testCase2));

        assertEquals(testCase1ExpectedResult, defangIPaddr2(testCase1));
        assertEquals(testCase2ExpectedResult, defangIPaddr2(testCase2));
    }
}
