
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

package math_matrix_geometry;

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
        final double epsilon = 0.0; // Define a small epsilon for comparing floating-point values

        // Test cases with known expected results
        final int hours1 = 12;
        final int minutes1 = 30;
        final double expected1 = 165.0;
        assertEquals(expected1, angleClock(hours1, minutes1), epsilon);

        final int hours2 = 3;
        final int minutes2 = 30;
        final double expected2 = 75.0;
        assertEquals(expected2, angleClock(hours2, minutes2), epsilon);

        final int hours3 = 3;
        final int minutes3 = 15;
        final double expected3 = 7.5;
        assertEquals(expected3, angleClock(hours3, minutes3), epsilon);

        final int hours4 = 1;
        final int minutes4 = 57;
        final double expected4 = 76.5;
        assertEquals(expected4, angleClock(hours4, minutes4), epsilon);

        // Test cases for angleClock2 method with known expected results
        final double expected5 = 165.0;
        assertEquals(expected5, angleClock2(hours1, minutes1), epsilon);

        final double expected6 = 75.0;
        assertEquals(expected6, angleClock2(hours2, minutes2), epsilon);

        final double expected7 = 7.5;
        assertEquals(expected7, angleClock2(hours3, minutes3), epsilon);

        final double expected8 = 76.5;
        assertEquals(expected8, angleClock2(hours4, minutes4), epsilon);
    }

}
