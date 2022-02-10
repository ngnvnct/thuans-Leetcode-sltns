import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_anagrams {
    public static void main (String[] args) {
        String[] exampleOne = {"eat","tea","tan","ate","nat","bat"};
        String[] exampleTwo = {""};
        String[] exampleThree = {"a"};
        group_anagrams Solution = new group_anagrams();
        System.out.println(Solution.groupAnagrams(exampleOne));
        System.out.println(Solution.groupAnagrams(exampleTwo));
        System.out.println(Solution.groupAnagrams(exampleThree));
    }
    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String current : s) {
            char[] c = current.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }
        res.addAll(map.values());
        return res;
    }
}

/*
Explanation
Anagram = two words that can be rearrange and be the same. We can sort all the words and group them together. We have a map that contains the sorted word (key).
After we sort it, we need to pass it back as a string. If nothing is being map yet, we need to add a new array list. 

*/