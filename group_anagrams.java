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
        System.out.println(Solution.groupAnagrams2(exampleOne));
        System.out.println(Solution.groupAnagrams2(exampleTwo));
        System.out.println(Solution.groupAnagrams2(exampleThree));
        System.out.println(Solution.groupAnagrams3(exampleOne));
        System.out.println(Solution.groupAnagrams3(exampleTwo));
        System.out.println(Solution.groupAnagrams3(exampleThree));
    }
    public List<List<String>> groupAnagrams(String[] s) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String current : s) {
            char[] c = current.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            //String sorted = String.valueOf(c);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }
        res.addAll(map.values());
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] alphabet = new int[26];
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a']++;
            }
            String hash = Arrays.toString(alphabet);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(word);
        }
        res.addAll(map.values());
        return res;
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] alphabet = new char[26];
            for (int i = 0; i < word.length(); i++) {
                alphabet[word.charAt(i) - 'a']++;
            }
            String hash = Arrays.toString(alphabet);
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(word);
        }
        res.addAll(map.values());
        return res;
    }
}

/*
Explanation
Anagram = two words that can be rearrange and be the same. We can sort all the words and group them together. We have a map that contains the sorted word (key).
After we sort it, we need to pass it back as a string. If nothing is being map yet, we need to add a new array list. 

Time: O(n klogk) where n is the length of strs, and k is the maximum lengh of a string in strs, sorting is k log k
Space: O(nk), total information content stored in res

Optimal
Two strings are anagram if they have the same character counts. So we can transform the string into a hash of 26 non-negative integers counts, represent the number of a,b,c
similar to valid anagram, you can use arrays as a key, or turn it into a String hash ("#2#1#0....#0"), 2 a, 1 b, 0 c ....

Time: O(nk) where n is the length of the strs, and k is the maximum length of a string in strs
Space: O(nk)
*/