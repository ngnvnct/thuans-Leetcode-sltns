import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class Maximum_Units_On_A_Truck_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        //Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[1], a[1]));

        maxHeap.addAll(Arrays.asList(boxTypes));
        int maxUnits = 0;
        int size = 0;

        while (!maxHeap.isEmpty()) {
            int[] currBox = maxHeap.poll();
            size = Math.min(truckSize, currBox[0]);
            maxUnits += size * currBox[1];
            truckSize -= size;
            if (truckSize == 0) {
                break;
            }
        }
        return maxUnits;
    }

    public int maximumUnitsSort(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> Integer.compare(b[1], a[1]));
        //Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int unitCount = 0;
        for (int[] boxType : boxTypes) {
            int boxCount = Math.min(truckSize, boxType[0]);
            unitCount +=  boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0) {
                break;
            }
        }
        return unitCount;
    }

    @Test
    public void testTruck() {
        assertEquals(8, maximumUnits(new int[][] {{1,3}, {2,2}, {3,1}}, 4));
        assertEquals(91, maximumUnits(new int[][] {{5,10}, {2,5}, {4,7}, {3,9}}, 10));

        assertEquals(8, maximumUnitsSort(new int[][] {{1,3}, {2,2}, {3,1}}, 4));
        assertEquals(91, maximumUnitsSort(new int[][] {{5,10}, {2,5}, {4,7}, {3,9}}, 10));
    }
}

/*
https://leetcode.com/problems/maximum-units-on-a-truck/
Explanation


 */