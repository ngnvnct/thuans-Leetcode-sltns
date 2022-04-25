import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class encryption_validity {
    public int[] encryptionValidity(int[] keys, int instructionCount, int validityPeriod) {
        Arrays.sort(keys);
        boolean[] isDivisible = new boolean[keys.length];
        int count = 0;
        int maxDivisible = 0;

        for (int i = 0; i < keys.length; i++) {
            if (!isDivisible[i]) {
                for (int j = i; j < isDivisible.length; j++) {
                    if (keys[j] % keys[i] == 0) {
                        count++;
                        maxDivisible = Math.max(maxDivisible, count);
                        isDivisible[j] = true;
                    }
                }
            }
        }
        long keyStrength = maxDivisible * 100000;
        long crack = (long) instructionCount * (long) validityPeriod;
        if (crack > keyStrength) {
            return new int[] {1, (int) keyStrength};
        }
        return new int[] {0, (int) keyStrength};
    }

    @Test
    public void testEncrypt() {
        int[] one = {2,4,8,2};
        int[] two = {2,4,16,8,2};
        assertArrayEquals(new int[] {1, 400000}, encryptionValidity(one, 1000, 10000));
        assertArrayEquals(new int[] {0, 500000}, encryptionValidity(two, 100, 100));
    }
}

/*
This problem is basically asking that given a set of keys, find the highest divisible, then multiply it by 10^5 (100000) to find its strength
then compare it with the product of instruction count and validity period to see if the hacker can crack the code or not.

The problem itself uses List<Integer>, which makes it easy to do Collections.sort or Collection.sort(Collection.reverseOrder()) to quickly sort asc or desc
Don't think it matters with the boolean solution whether it is asc or desc (just have to be careful with i and j variables)

Explanation
The key is to apply a similar pattern to Count Prime (Sieve of Eratosthenes)
A brute force approach would be a nested for loop to find the highest divisible, but this can repeat the calculation and cause a TLE in test cases
The key is to sort the keys array (descending or ascending it doesn't really matter), then have a boolean array to mark each divisible to True after we calculate it
{2,4,8,2} = {2,2,4,8}, do a nested loop but the inside for loop is bounded by the boolean constraint
for the first iteration, it will mark it with {true, true, true, true} and give a maxDivisible of 4
because each element is mark it won't do the calculation again

Need sorting because the largest element can be in the middle of the array, thus giving inaccurate divisible


Time: Worst case O(n^2) if all the element only divisible by 1 else O(n log n)
Space: O(n) to store the boolean array
*/