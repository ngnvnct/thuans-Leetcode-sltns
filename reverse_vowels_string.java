import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class reverse_vowels_string {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] cArray = s.toCharArray();
        int left = 0;
        int right = cArray.length-1;
        while (left < right) {
            if (set.contains(cArray[left]) && set.contains(cArray[right])) {
                char temp = cArray[left];
                cArray[left] = cArray[right];
                cArray[right] = temp;
                left++;
                right--;
            } else if (!set.contains(cArray[left]) && set.contains(cArray[right])) {
                left++;
            } else {
                right--;
            }
        }
        return new String(cArray);
    }

    public String reverseVowels2(String s) {
        if(s == null || s.length()==0) return s;
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            while(start<end && !vowels.contains(chars[start]+"")){
                start++;
            }
            
            while(start<end && !vowels.contains(chars[end]+"")){
                end--;
            }
            
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            
            start++;
            end--;
        }
        return new String(chars);
    }

    @Test
    public void testReverseVowels() {
        String exampleOne = "hello";
        String exampleTwo = "leetcode";
        assertEquals("holle", reverseVowels(exampleOne));
        assertEquals("holle", reverseVowels2(exampleOne));
        assertEquals("leotcede", reverseVowels(exampleTwo));
        assertEquals("leotcede", reverseVowels2(exampleTwo));
    }
}


/*
Explanation

Make a set, or a string of vowels, then check at each index. Use two pointers approarch to swap, only swap if both char at left and right are vowels, else move left or right

Time: O(n)
Space: O(10)
*/