import java.util.List;

public class minimum_time_difference {
    public int findMinDifferent(List<String> timePoints) {
        // 24 hours time 60 minutes
        // "01:01" = 1 * 60 = 60 + 1 = 61 position
        boolean[] timeSeen = new boolean[24*60];

        for (String time : timePoints) {
            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            if (timeSeen[(hour*60) + minute]) {
                return 0;
            }
            timeSeen[(hour*60) + minute] = true;
        }

        Integer firstTimeSeen = null;
        Integer prevTimeSeen = null;
        Integer minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < timeSeen.length; i++) {
            if (timeSeen[i]) {
                if (firstTimeSeen == null) {
                    firstTimeSeen = i;
                    prevTimeSeen = i;
                } else {
                    minDifference = Math.min(minDifference, Math.min(i-prevTimeSeen, 1440 -i + prevTimeSeen));
                    prevTimeSeen = i;
                }
            }
        }
        minDifference = Math.min(minDifference, Math.min(prevTimeSeen - firstTimeSeen, 1440 - prevTimeSeen + firstTimeSeen));

        return minDifference;
    } 
}

/*
Explanation

We make a bucket of size 24 (hours) * 60 minutes = 1440, and we mark it as true if we already seen it
if we already seen that time, return 0

We gonna loop through this timeSeen, and set firstTimeSeen once and leave it till the end
At the end prevTimeSeen will be the last time, and we compare it with the firstTimeSeen

Now we update prevTimeSeen, i-prevTimeSeen is the clockwise minimum, 1440-i + prevTimeSeen is the counter clockwise minimum

The loop will have find the minimum, unless the very last element and the first time seen are close to each other

Alternative, minDifference = Math.min(minDifference, Math.min(i-prevTimeSeen, 1440 -i + firstTimeSeen)) and remove line #33
Edge case like [00:01, 10:00, 23:59] and [00:00, 10:00, 23:00]

Time: O(n)
Space: O(1440)
*/