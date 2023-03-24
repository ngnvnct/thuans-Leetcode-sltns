/*
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 * Explanation:
 * 
 * 12 hours hand complet whole circle cover 360 degree
 * 1 hour - 360 / 12 = 30
 * 1 hour = 30 degree
 * 1 minute, hours hand rotate 30 degree / 60 = 0.5 degree
 * total angle of minutes by hour hand is minutes/60 * 30 or minutes * 0.5
 * 
 * 1 minute = 360 / 60 = 6 degree
 * 
 * If the angle is obtuse (>180) convert it to acute (0 <= x <= 180)
 * 
 * new JUnit Test for double value
 * 
 * Time: O(1)
 * Space: O(1)
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class problem_1344_angle_between_hands_of_a_clock {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12 + ((double) minutes / 60)) * 30;
        double minuteAngle = minutes * 6;
        double angle = Math.abs(minuteAngle - hourAngle);
        
        if (angle > 180) {
            angle = 360.0 - angle;
        }
        return angle;
    }

    public double angleClock2(int hour, int minutes) {
        int oneMinuteAngle = 6;
        int oneHourAngle = 30;

        double minutesAngle = minutes * oneMinuteAngle;
        double hoursAngle = (hour % 12 + minutes / 60.0) * oneHourAngle;
        double angle = Math.abs(hoursAngle - minutesAngle);
        return Math.min(angle, 360 - angle);
    }

    @Test
    public void testAngle() {
        assertEquals(165, angleClock(12, 30), 0.0);
        assertEquals(75, angleClock(3, 30), 0.0);
        assertEquals(7.5, angleClock(3, 15), 0.0);
        assertEquals(76.5, angleClock(1, 57), 0.0);
        assertEquals(165, angleClock2(12, 30), 0.0);
        assertEquals(75, angleClock2(3, 30), 0.0);
        assertEquals(7.5, angleClock2(3, 15), 0.0);
        assertEquals(76.5, angleClock2(1, 57), 0.0);
    }
}
