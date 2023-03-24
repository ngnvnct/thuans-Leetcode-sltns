import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class excel_sheet_col_number {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        int number = 0;
        for (int i = 0; i < n; i++) {
            number = columnTitle.charAt(i) -'A' + 1;
            res = res * 26 + number;
        }
        return res;
    }

    @Test
    public void testTitleToNumber() {
        assertEquals(1, titleToNumber("A"));
        assertEquals(28, titleToNumber("AB"));
        assertEquals(701, titleToNumber("ZY"));
    }
}

/*
Explanation
1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"]

A to Z is 1 to 26, for example if charAt('A') - 'A', we get 0, and we add 1 to it. We want to convert a number in the base 26 numeral system to a decimal number.

"ABZCD"
A = 0 * 26 + 1 = 1
B = 1 * 26 + 2 = 28
Z = 28 * 26 + 26 = 754
C = 754 * 26 + 26 = 19607
D = 19607 * 26 + 4 = 509786

Time: O(n)
Space: O(1)
*/
