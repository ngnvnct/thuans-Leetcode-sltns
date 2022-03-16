import java.util.HashMap;
import java.util.Map;

public class total_time_space {
    public static void main(String[] args) {
        String[][] logs = {
            {"create", "xyz", "1", "1619916081"}, // Sat May 01 2021 17:41:21 GMT-0700 
            {"join", "xyz", "2", "1619916681"}, // Sat May 01 2021 17:51:21 GMT-0700
            {"create", "abc", "3", "1619916881"}, //12:01
            {"leave", "xyz", "2", "1619920281"},
            {"join", "abc", "4", "1619920881"},
            {"create", "ghi", "5", "1619923999"},
            {"leave", "xyz", "1", "1619923881"},
            {"leave", "abc", "3", "1619927481"}, //12:07 time spent = 6 minutes
            {"leave", "abc", "4", "1619927481"},
            {"leave", "ghi", "5", "1619958001"}
        };
        total_time_space solution = new total_time_space();
        int a = (1619923881-1619916081)+(1619920281-1619916681);
        System.out.println(a);
        System.out.println(solution.getTotal(logs));
    }

    public Map<String, Integer> getTotal(String[][] logs) {
        Map<String, Integer> userMap = new HashMap<>();
        Map<String, Integer> spaceMap = new HashMap<>();
        
        for (String[] log : logs) {
            String action = log[0];
            String space = log[1];
            String userId = log[2];
            int time = Integer.parseInt(log[3]);

            if (action == "create" || action == "join") {
                if (!userMap.containsKey(userId)) {
                    userMap.put(userId, time);
                } 
            } else {
                int diff = time - userMap.get(userId);
                if (!spaceMap.containsKey(space)) {
                    spaceMap.put(space, diff);
                } else {
                    spaceMap.put(space, spaceMap.get(space) + diff);
                }
            }
        }
        return spaceMap;
    }
}

/*abstract
Explanation

Was ask during twitter phone screen, the person was okay with returning a hash map

Time: O(n), where n is the integral
Space: O(m + n), m is the spaceMap and n is the userMap
*/