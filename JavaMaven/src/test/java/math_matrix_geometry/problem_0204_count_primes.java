/*
 * https://leetcode.com/problems/count-primes/
 * Explanation:
 * 
 * Sieve of Eratosthenes
 * 
 * You can count prime less than n, or count prime up to n
 * You can also get ask count the sum of all prime
 * 
 * Prime: The number can divide by itself and 1
 * 
 * Assume all number is prime
 * 
 * 21 numbers
 * Smallest Prime number is 2. We mark the multiples of this number as non
 * primes in the array.
 * Move to the next one 3, repeat the same process
 * We don't need to check the remaining number since 5*5 > 20, and our loop only
 * interates til lthe square root of n = 20
 * Why?
 * 6 * 1 = 6 = 1 * 5
 * 6 * 2 = 12 = 2 * 6
 * 6 * 3 = 18 = 3 * 6
 * 6 * 4 = 24 = 2 * 12
 * 6 * 5 = 30 = 5 * 6
 * 6 * 6 = 36 > 30
 * Every multiple of 6 was already addresed by some multiple of a prime number
 * less than 6
 */

package math_matrix_geometry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_0204_count_primes {
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimes2(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 2; i * i < primes.length; i++) {
            if (!primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                count++;
            }
        }
        return count;
    }

    public static int countPrimesSum(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }

        int sum = 0;

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                sum += i;
            }
        }
        return sum;
    }

    @Test
    public void testCountPrimes() {
        // Test case 1
        int testCase1 = 10;
        int testCase1ExpectedResult = 4;
        assertEquals(testCase1ExpectedResult, countPrimes(testCase1));
        assertEquals(testCase1ExpectedResult, countPrimes2(testCase1));

        // Test case 2
        int testCase2 = 0;
        int testCase2ExpectedResult = 0;
        assertEquals(testCase2ExpectedResult, countPrimes(testCase2));
        assertEquals(testCase2ExpectedResult, countPrimes2(testCase2));

        // Test case 3
        int testCase3 = 1;
        int testCase3ExpectedResult = 0;
        assertEquals(testCase3ExpectedResult, countPrimes(testCase3));
        assertEquals(testCase3ExpectedResult, countPrimes2(testCase3));

        // Test case 4
        int testCase4 = 100;
        int testCase4ExpectedResult = 25;
        assertEquals(testCase4ExpectedResult, countPrimes(testCase4));
        assertEquals(testCase4ExpectedResult, countPrimes2(testCase4));

        // Test case 5
        int testCase5 = 999;
        int testCase5ExpectedResult = 168;
        assertEquals(testCase5ExpectedResult, countPrimes(testCase5));
        assertEquals(testCase5ExpectedResult, countPrimes2(testCase5));
    }

    @Test
    public void testCountPrimesSum() {
        // Test case 1
        int testCase1 = 10;
        int testCase1ExpectedResult = 17;
        assertEquals(testCase1ExpectedResult, countPrimesSum(testCase1));

        // Test case 2
        int testCase2 = 0;
        int testCase2ExpectedResult = 0;
        assertEquals(testCase2ExpectedResult, countPrimesSum(testCase2));

        // Test case 3
        int testCase3 = 1;
        int testCase3ExpectedResult = 0;
        assertEquals(testCase3ExpectedResult, countPrimesSum(testCase3));

        // Test case 4
        int testCase4 = 100;
        int testCase4ExpectedResult = 1060;
        assertEquals(testCase4ExpectedResult, countPrimesSum(testCase4));

        // Test case 5
        int testCase5 = 999;
        int testCase5ExpectedResult = 76127;
        assertEquals(testCase5ExpectedResult, countPrimesSum(testCase5));
    }
}
