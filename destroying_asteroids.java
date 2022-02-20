import java.util.Arrays;

import org.junit.Test;

public class destroying_asteroids {
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

    }
}


/*abstract
Greedy Problem. Sort it and then check if current mass is bigger than the asteroid[i], then add it together

CONSTRAINT CHECK: if the array is big there is a chance integer will exceed 2 ^ 31, have to convert it into long
if not, just use the other constraint, if mass is the biggest value in the constraint, it can smash the entire array

Time: O(n)
Space: O(1)
*/