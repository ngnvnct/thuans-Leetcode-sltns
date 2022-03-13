import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class keep_multiplying_found_value_by_two {
    public int findFinalValueSort(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original *= 2;
            }
        }
        return original;
    }
    public int findFinalValueSet(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num >= original) {
                set.add(num);
            }
        }
        while (true) {
            if (set.contains(original)) {
                original *= 2;
            } else {
                break;
            }
        }
        return original;
    }
}

/*
Explanation

If you sort the array, original * 2 will always be after the index if it exists, if we don't sort it, it could happen before

For hash set, we can add all the number bigger than original, then do a while true loop, if the hash set contains original, multiply it by 2, repeatedly
break when you're done

Time: O(nlogn) for sorting, O(n) for hash set
Space: O(1) for sorting, O(n) for hash set
*/