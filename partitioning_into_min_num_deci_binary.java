import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class partitioning_into_min_num_deci_binary {
    public int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) -'0');
            if (maxDigit == 9) {
                return maxDigit;
            }
        }
        return maxDigit;
    }

    @Test
    public void testDeciBinary() {
        assertEquals(3, minPartitions("32"));
        assertEquals(8, minPartitions("82734"));
        assertEquals(9, minPartitions("27346209830709182346"));
    }
}

/*
https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
Explanation

This problem is best if you try it on paper
1 digit "1" to "9", you need 1 deci-binary to add up (1 for 1, 1 + 1 for 2, ....)

82734, going vertically you get this
11111
11111
10111
10101
10100
10100
10100
10000

Add them up horizontally 11111 + 11111 + 10111 + 10101 + 10100 + 10100 + 10100 + 10000 = 82734
So the max digits any string can contain is 9, we return early if we find it

28734, going verticall you get this
11111
11111
01111
01101
01100
01100
01100
01000
11111 + 11111 + 1111 + 1101 + 1100 + 1100 + 1000 = 28734

Time: O(n)
Space: O(1)
*/