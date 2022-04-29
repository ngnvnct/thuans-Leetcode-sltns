public class consecutive_characters {
    public int maxPower(String s) {
        int maxLength = 1;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                count++;
            } else {
                maxLength = Math.max(count, maxLength);
                count = 1;
            }
        }
        return Math.max(maxLength, count);
    }
}
