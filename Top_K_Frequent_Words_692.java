import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class Top_K_Frequent_Words_692 {
    class Pair {
        String word;
        int freq;

        Pair(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Queue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.freq == b.freq) {
                    return a.word.compareTo(b.word);
                }
                return b.freq - a.freq;
            }
        });

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair currPair = maxHeap.poll();
            res.add(currPair.word);
        }
        return res;
    }

    public List<String> topKFrequent2(String[] words, int k) {
        List<String> res = new ArrayList<>();

        if (words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> maxHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s1.compareTo(s2);
                }
                // return map.get(s2) - map.get(s1);
                return Integer.compare(map.get(s2), map.get(s1));
            }
        });

        maxHeap.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                res.add(maxHeap.poll());
            }
        }
        return res;
    }

    public List<String> topKFrequent3(String[] words, int k) {
        List<String> res = new ArrayList<>();

        if (words == null || words.length == 0) {
            return res;
        }

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) {
                    return s2.compareTo(s1);
                }
                return Integer.compare(map.get(s1), map.get(s2));
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(entry.getKey());
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    @Test
    public void testKFrequent() {
        assertEquals(new ArrayList<>(Arrays.asList("i", "love")),topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
        assertEquals(new ArrayList<>(Arrays.asList("the", "is", "sunny", "day")), topKFrequent(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));

        assertEquals(new ArrayList<>(Arrays.asList("i", "love")),topKFrequent2(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
        assertEquals(new ArrayList<>(Arrays.asList("the", "is", "sunny", "day")), topKFrequent2(new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
    }
}

/*
 * https://leetcode.com/problems/top-k-frequent-words/
 * Explanation
 * 
 * compareTo() is used for comparing two strings lexicographically in Java. Each
 * character is converted into a Unicode value for comparsion.
 * It returns the following values:
 * 
 * 1. if (string1 > string2) it returns a positive value.
 * 2. if both the strings are equal lexicographically i.e.(string1 == string2)
 * it returns 0.
 * 3. if (string1 < string2) it returns a negative value.
 * 
 * compare() method of Integer class of java.lang package compares two integer
 * values (x, y) given
 * as a parameter and
 * 
 * 1. returns the value zero if (x==y) (0)
 * 2. if (x < y) then it returns a value less than zero and (-1)
 * 3. if (x > y) then it returns a value greater than zero (1)
 * 
 * Max Heap:
 * Use a hash map to get the frequency. Write my own comparator for the max heap
 * method. It is going to say this
 * if they have the same frequency, then use compareTo() for strings
 * lexicographically. The smaller value will be in front of the priority queue
 * 
 * For the string "i" and "love", if i do "love".compareTo("i"), it will return
 * 3 and "i".compareTo("love") return -3
 * if we do s2.compareTo(s1) we are saying that put the character with bigger
 * unicode value first, and that will be wrong
 * 
 * if the frequency is difference, compare the frequency
 * Integer.compare(2,2) will return 0
 * Integer.compare(2,1) will return 1
 * Integer.compare(1,2) will return -1
 * We have to do Integer.compare(map.get(s2), map.get(s1)) because we want to
 * put the smaller value behind our queue, not in front
 * 
 * Min Heap:
 * Heap has worst time case of log n insert, and in order to get O(n log k) we
 * only want to insert k element in it
 * We want to put the less frequency character in front of our priority queue,
 * and the character with bigger lexicographic character in front
 * when we pulling from our priority queue, we only pull the one with lesser
 * frequency or the one with bigger lexicographic
 * 
 * But when we add it to our answer we have to reverse the list
 * 
 * Time: O(n log n) or O(n log k)
 * Space: O(n)
 */