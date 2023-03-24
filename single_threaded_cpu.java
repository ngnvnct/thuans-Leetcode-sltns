import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

public class single_threaded_cpu {
    public int[] getOrder(int[][] tasks) {
        int[] result = new int[tasks.length];
        int[][] allTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            allTasks[i][0] = tasks[i][0];
            allTasks[i][1] = tasks[i][1];
            allTasks[i][2] = i;
        }
        //Arrays.sort(allTasks, (a,b) -> a[0]-b[0]);
        Arrays.sort(allTasks, (a,b) -> Integer.compare(a[0], b[0]));

        // If they have same processing time, pick the smallest index (given)
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> (a[1] == b[1]) ? Integer.compare(a[2],b[2]) :  Integer.compare(a[1],b[1]));

        int i = 0, resIndex = 0, time = 0;
        while(!minHeap.isEmpty() || i < tasks.length) {
            if (minHeap.isEmpty()) {
                time = Math.max(time, allTasks[i][0]);
            }
            while (i < tasks.length && time >= allTasks[i][0]) {
                minHeap.offer(allTasks[i++]);
            }

            int[] cur = minHeap.poll();
            time += cur[1];
            result[resIndex++] = cur[2];
        }
        return result;
    }

    @Test
    public void testCPU() {
        int[][] testCase1 = {{1,2},{2,4},{3,2},{4,1}};
        int[] expected = {0,2,3,1};
        int[][] testCase2 = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        int[] testCase2ExpectedResult = {4,3,2,0,1};

        assertEquals(Arrays.toString(expected),Arrays.toString(getOrder(testCase1)));
        assertEquals(Arrays.toString(testCase2ExpectedResult), Arrays.toString(getOrder(testCase2)));
    }
}

/*abstract
Explanation

Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
Output: [0,2,3,1]
Explanation: The events go as follows: 
- At time = 1, task 0 is available to process. Available tasks = {0}.
- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
- At time = 2, task 1 is available to process. Available tasks = {1}.
- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
- At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
- At time = 10, the CPU finishes task 1 and becomes idle.

The idea is we keep a min heap to support choosing the task with the smallest processing time from all the enqueued task
We also want to keep the index of the interval (allTasks), and we will sort it by the enqueued time
allTasks[0] = enqueued time, allTasks[1] = processing time, allTasks[2] = original index
Our custom min heap will help to get available task with minimum processing time, if they have the same processing time, it will grab the smallest index one instead

When queue is empty, time will be the first time in allTasks (sorted), time = 1
Loop, while we have intervals, and time is bigger than the allTask start time add it to our min Heap

Min Heap [1,2,0], and we poll it,
time += 2 = 3
res = cur[2] = [0]

Time is now 3, we can add in [2,4,1] and [3,2,2] in our min heap
what do we pick, the one with the smaller processing time
time += 2 = 5
res = cur[2] = [0,2]

we can add [4,1,3] into it, now we have {2,4,1} and {4,1,3}
we pick the smaller processing time
time += 6
res = cur[2] = [0,2,3]

finally
time += 7
res = [0,2,3,4]

Time: O(nlogn)
Space: O(n)
*/