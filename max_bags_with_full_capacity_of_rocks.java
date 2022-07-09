import java.util.PriorityQueue;

public class max_bags_with_full_capacity_of_rocks {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] fill = new int[capacity.length];
        int count = 0;

        for (int i = 0; i < fill.length; i++) {
            fill[i] = capacity[i] - rocks[i];
            if (fill[i] == 0) {
                count++;
            } else {
                minHeap.add(fill[i]);
            }
        }

        while (additionalRocks != 0 && !minHeap.isEmpty()) {
            int placement = minHeap.poll();
            int place = Math.min(placement, additionalRocks);
            additionalRocks -= place;
            placement -= place;
            if (placement == 0) {
                count++;
            } else {
                minHeap.add(placement);
            }
        }
        return count;
    }
}
