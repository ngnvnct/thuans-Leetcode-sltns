import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class contains_duplicate {
    public static void main(String[] args) {

    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    @Test
    public void testContainsDuplicate() {
        int[] exampleOne = new int[]{1,2,3,1};
        assertEquals(true, containsDuplicate(exampleOne));

        int[] exampleTwo = new int[]{1,2,3,4};
        assertEquals(false, containsDuplicate(exampleTwo));

        int[] exampleThree = new int[]{1,1,1,3,3,4,3,2,4,2};
        assertEquals(true, containsDuplicate(exampleThree));
    }
}
