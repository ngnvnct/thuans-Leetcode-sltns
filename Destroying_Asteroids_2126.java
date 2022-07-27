import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class Destroying_Asteroids_2126 {
    public boolean asteroidsDestroyedLong(int mass, int[] asteroids) {
        long m = mass;
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (m < asteroid) {
                return false;
            }
            m += asteroid;
        }
        return true;
    }

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (mass < asteroid) {
                return false;
            } else if (mass > 100000) {
                return true;
            }
            mass += asteroid;
        }
        return true;
    }

    @Test
    public void testDestroyed() {
        int[] exampleOne = { 3, 9, 19, 5, 21 };
        int[] exampleTwo = { 4, 9, 23, 4 };

        assertTrue(asteroidsDestroyed(10, exampleOne));
        assertFalse(asteroidsDestroyed(5, exampleTwo));

        assertTrue(asteroidsDestroyedLong(10, exampleOne));
        assertFalse(asteroidsDestroyedLong(5, exampleTwo));

    }
}

/*
 * https://leetcode.com/problems/destroying-asteroids/
 * Greedy Problem. Sort it and then check if current mass is bigger than the
 * asteroid[i], then add it together
 * 
 * CONSTRAINT CHECK: if the array is big there is a chance integer will exceed 2
 * ^ 31, have to convert it into long
 * if not, just use the other constraint, if mass is the biggest value in the
 * constraint, it can smash the entire array
 * 
 * Time: O(n)
 * Space: O(1)
 */