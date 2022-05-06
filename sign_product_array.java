import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class sign_product_array {
    public int arraySignNaive(int[] nums) {
        int product = 1;
        for (int num : nums) {
            product *= num;
        }
        if (product > 0) {
            return 1;
        } else if (product == 0) {
            return 0;
        }
        return -1;
    }

    public int arraySignMethod2(int[] nums) {
        int product = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                product *= -1;
            } else {
                product *= 1;
            }
        }
        return product;
    }

    public int arraySignOptimal(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }

    @Test
    public void testProduct() {
        assertEquals(1, arraySignOptimal(new int[] {-1,-2,-3,-4,3,2,1}));
        assertEquals(0, arraySignOptimal(new int[] {1,5,0,2,-3}));
        assertEquals(-1, arraySignOptimal(new int[] {-1,1,-1,1,-1}));
        assertEquals(1, arraySignMethod2(new int[] {-1,-2,-3,-4,3,2,1}));
        assertEquals(0, arraySignMethod2(new int[] {1,5,0,2,-3}));
        assertEquals(-1, arraySignMethod2(new int[] {-1,1,-1,1,-1}));
    }
}
