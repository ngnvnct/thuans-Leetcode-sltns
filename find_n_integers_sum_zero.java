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

    @Test
    public void testSum() {
        assertArrayEquals(new int[] {0,1,-1,2,-2}, sumZero(5));
        assertArrayEquals(new int[] {0,1,-1}, sumZero(3));
        assertArrayEquals(new int[] {0}, sumZero(1));
        assertArrayEquals(new int[] {}, sumZero(0));
    }
}
