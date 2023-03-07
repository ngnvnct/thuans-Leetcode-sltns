import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.Test;

public class min_swap_group_1_together {
    public int minSwaps(int[] data) {
        int sumOne = Arrays.stream(data).sum();
        int countOne = 0, maxOneWindow = 0;
        int left = 0, right = 0;

        while (right < data.length) {
            countOne += data[right++];
            if (right - left > sumOne) {
                countOne -= data[left++];
            }
            maxOneWindow = Math.max(maxOneWindow, countOne);
        }
        return sumOne - maxOneWindow;
    }

    public int minSwapsDeque(int[] data) {
        int sumOne = Arrays.stream(data).sum();
        int countOne = 0;
        int maxOneWindow = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < data.length; i++) {
            deque.addLast(data[i]);
            countOne += data[i];

            if (deque.size() > sumOne) {
                countOne -= deque.removeFirst();
            }
            maxOneWindow = Math.max(maxOneWindow, countOne);
        }
        return sumOne - maxOneWindow;
    }

    @Test
    public void testSwap() {
        assertEquals(1, minSwaps(new int[] { 1, 0, 1, 0, 1 }));
        assertEquals(0, minSwaps(new int[] { 0, 0, 0, 1, 0 }));
        assertEquals(3, minSwaps(new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1 }));
        assertEquals(1, minSwapsDeque(new int[] { 1, 0, 1, 0, 1 }));
        assertEquals(0, minSwapsDeque(new int[] { 0, 0, 0, 1, 0 }));
        assertEquals(3, minSwapsDeque(new int[] { 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1 }));
    }
}

/*
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 * Explanation
 * 
 * The number of 1's should be grouped together is a fix number, total number of
 * 1's the whole array has. Use sliding window to find number of swaps needed
 * 
 * Two Pointers
 * Use left and right to main a sliding window of length sumOne, and while we
 * check every window throught he input, we would calculate the number of 1's in
 * it as countOne
 * and store the largest one as maxOne
 * While the window is sliding through data, maintain is length as sumOne.
 * Update the number of 1's in the window by adding the new boundary data[right]
 * and subtracting left boundary data[left]
 * We want to find the maximum number of 1's in the window so that we can make
 * the smallest number of swaps to achieve the goal
 * 
 * Two Pointers with Deque
 * Similar appoarch, adding data to the right and if it is bigger than the
 * sumOne, remove it from the left side
 * 
 * Time: O(n)
 * Space: O(1) or O(n)
 */