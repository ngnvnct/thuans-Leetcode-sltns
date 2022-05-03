import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class intersection_two_arrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersection_two_arrays sol = new intersection_two_arrays();
        System.out.println(Arrays.toString(sol.intersection(nums1, nums2)));
        System.out.println(Arrays.toString(sol.intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4})));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        int[] res = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            res[index++] = num;
        }
        return res;
    }

    public int[] intersectionSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // assume it is sorted
        Arrays.sort(nums2); // assume it is sorted
        Set<Integer> intersect = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersect.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            res[index++] = num;
        }
        return res;
    }
}

/*abstract
Explanation

Using two sets and add all element into the first set, then on the 2nd array, check to see if it already exist in the set, if it is then add to the intersect. Finally add it to the result

Time: O(n)
Space: O(n)

Two Pointers Solution: Assume it is sorted, it is okay if not. Keep two pointers, add them into a set if we find an intersect and move the pointers accordingly

Time: O(n + m), else O (n log n + m log m)
Space: O(n) for intersect array, else O(1) since we are only using pointers
*/