import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class find_n_integers_sum_zero {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int unique = 1;
        if (n % 2 == 1) {
            res[0] = 0;
            for (int i = 1; i < n; i++) {
                if (i % 2 == 1) {
                    res[i] = unique;
                } else {
                    res[i] = -unique;
                    unique++;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    res[i] = unique;
                } else {
                    res[i] = -unique;
                    unique++;
                }
            }
        }
        return res;
    }

    public int[] sumZeroMath(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i * 2 - n + 1;
        }
        return res;
    }

    public int[] sumZeroPointers(int n) {
        int[] res = new int[n];
        int left = 0, right = n-1, start = 1;
        while (left < right) {
            res[left++] = start;
            res[right--] = -start;
            start++;
        }
        return res;
    }

    @Test
    public void testSum() {
        assertArrayEquals(new int[] {0,1,-1,2,-2}, sumZero(5));
        assertArrayEquals(new int[] {0,1,-1}, sumZero(3));
        assertArrayEquals(new int[] {0}, sumZero(1));
        assertArrayEquals(new int[] {}, sumZero(0));

        assertArrayEquals(new int[] {-4,-2,0,2,4}, sumZeroMath(5));
        assertArrayEquals(new int[] {-2,0,2}, sumZeroMath(3));
        assertArrayEquals(new int[] {0}, sumZeroMath(1));
        assertArrayEquals(new int[] {}, sumZeroMath(0));

        assertArrayEquals(new int[] {1,2,0,-2,-1}, sumZeroPointers(5));
        assertArrayEquals(new int[] {1,0,-1}, sumZeroPointers(3));
        assertArrayEquals(new int[] {1,2,-2,-1}, sumZeroPointers(4));
        assertArrayEquals(new int[] {0}, sumZeroPointers(1));
        assertArrayEquals(new int[] {}, sumZeroPointers(0));
    }
}

/*
https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

Brute Force: return an array where the values are symmetric, if n is odd append value 0 in your return array
if n is odd, then first index is 0, then the index at 1...n-1 will be positive number, and index from 2...n will be negative number [0, positive, negative, positive, negative]
if n is even, then odd position idnex will be positive (0, 2, 4) and even position index will be negative (1,3,5)

Two Pointers: Two Pointers, we fill the left index with positive and the right with negative number, then increment left and decrement right
In java array is initialize with 0, so for odd length the middle number will be 0

Math: The first two solutions are good enough, especially the two pointers one.
n = 3, [-2, 0, 2]
n = 4, [-3, -1, 1, 3]
n = 5, [-4, -2, 0, 2, 4]
A[i] = i * 2 - n + 1

Time: O(n)
Space: O(1) if not counting output
*/