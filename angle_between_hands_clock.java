public class angle_between_hands_clock {
    public static void main(String[] args) {
        angle_between_hands_clock Solution = new angle_between_hands_clock();
        System.out.println(Solution.angleClock(12, 30));
        System.out.println(Solution.angleClock(3, 30));
        System.out.println(Solution.angleClock(3, 15));
    }
    public double angleClock(int hour, int minutes) {

        double hourAngle = (hour % 12 * 30) + ((double) minutes/60 * 30);
        double minuteAngle = minutes * 6;
        double angle = Math.abs(minuteAngle-hourAngle);
        if (angle > 180) {
            angle = 360.0 - angle;
        }
        return angle;
    }
}

/*
Explanation

12 hours hand complet whole circle cover 360 degree
1 hour - 360 / 12 = 30
1 hour = 30 degree
1 minute, hours hand rotate 30 degree / 60 = 0.5 degree
total angle of minutes by hour hand is minutes/60 * 30 or minutes * 0.5

1 minute = 360 / 60 = 6 degree

If the angle is obtuse (>180) convert it to acute (0 <= x <= 180)

Time: O(1)
Space: O(1)
*/
