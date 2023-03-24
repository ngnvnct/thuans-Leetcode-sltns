import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Merge_Intervals_56 {
	public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[][] {};
		}
		if (intervals.length == 1) {
			return intervals;
		}

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		// Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
		List<int[]> res = new ArrayList<int[]>();
		int[] current = intervals[0];
		res.add(current);
		for (int i = 1; i < intervals.length; i++) {
			int currEnd = current[1];
			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];
			if (currEnd >= nextStart) {
				current[1] = Math.max(currEnd, nextEnd);
			} else {
				current = intervals[i];
				res.add(current);
			}
		}
		return res.toArray(new int[res.size()][2]);
	}

	public int[][] merge2(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[][] {};
		}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merged = new LinkedList<>();
		
		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray((new int[merged.size()][]));
	}

	@Test
	public void testMergeInterval() {
		int[][] testCase1 = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] testCase1ExpectedResult = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] testCase2 = new int[][] { { 1, 4 }, { 4, 5 } };
		int[][] testCase2ExpectedResult = new int[][] { { 1, 5 } };

		assertArrayEquals(testCase1ExpectedResult, merge(testCase1));
		assertArrayEquals(testCase2ExpectedResult, merge(testCase2));
		
		assertArrayEquals(testCase1ExpectedResult, merge2(testCase1));
		assertArrayEquals(testCase2ExpectedResult, merge2(testCase2));
	}
}

/*
 * https://leetcode.com/problems/merge-intervals/
 * Explanation
 * Draw a number line
 * [1,3], [8,10], [15,18], [2,6]
 * ----------------------------------------------------------------------
 * 0 1 2 3 4 ....
 * We can take the interval and sort them by the start value, then iterate
 * through them
 * Check does the current interval overlap with the previous interval. If
 * overlap, merge
 * Compare currEnd and nextStart
 * [1,3], [2,6], [8,10]. [15,18]
 * Merge [1,6], [8,10], [15,18]
 * 
 * current[1] = Math.max(currEnd, nextEnd); Any instance of the class ArrayList
 * is mutable. Its elements can be modified
 * 
 * Linked List is a part of the Collection framework present in java.util
 * package.
 * This class is an implementation of the LinkedList data structure which is a
 * linear data structure where the elements are not stored in contiguous
 * locations and every element is a separate object with a data part and.
 * The Java.util.LinkedList.getLast() method is used to fetch or retrieve the
 * last element from a LinkedList or the element present at the tail of the
 * list.
 * 
 * Time: O(nlogn)
 * Space: O(n)
 */