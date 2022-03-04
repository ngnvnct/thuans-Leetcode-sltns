import java.util.HashMap;
import java.util.Map;

public class logger_rate_limiter {
    Map<String, Integer> times;
    public logger_rate_limiter() {
        times = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        // 1. Is the message unique
        // 2. has it been 10 seconds since we've last seen the message
        if (times.containsKey(message)) {
            if (timestamp - times.get(message) >= 10) {
                times.put(message,timestamp);
                return true;
            }
            return false;
        } else {
            times.put(message, timestamp);
            return true;
        }
    }
}
