import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class song_duration_divisible60 {

    public int numPairsDivisisbleBy60Array(int[] time) {
        int[] remainder = new int[60];
        int count = 0;
        for (int timeEle : time) {
            count += remainder[(60-timeEle%60) % 60];
            remainder[timeEle % 60] += 1;
        }
        return count;
    }
    public int numPairsDivisisbleBy60(int[] time) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int timeEle : time) {
            int rem = timeEle % 60;
            int target = 60 - rem;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            if (rem != 0) {
                map.put(rem, map.getOrDefault(rem,0) + 1);
            } else {
                map.put(60, map.getOrDefault(60,0) + 1);
            }
        }
        return count;
    }

    @Test
    public void testSongDivisibleBy60() {
        int[] testCase1 = {30,20,150,100,40};
        int[] testCase2 = {60,60,60};
        assertEquals(3, numPairsDivisisbleBy60(testCase1));
        assertEquals(3, numPairsDivisisbleBy60(testCase2));
        assertEquals(3, numPairsDivisisbleBy60Array(testCase1));
        assertEquals(3, numPairsDivisisbleBy60Array(testCase2));

    }
}

/*
Explantion
for an array of [30,20,150,100,40] we take the remainder, and they become [30,20,30,40,40] and we have a target variable that subtract the remainder.
Since Remainder1 + Remainder2 = 60, we have our pairs, similar to two sum. Then we check if it is in the hash map, then update the count value.
If it is not in the hash map, we put it into the hash map and keep track of the occurences

Time: O(n)
Space: O(n)

*/