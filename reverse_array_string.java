public class reverse_array_string {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}


/*
Two pointer approach, keep the left index and the right index, loop to the half way point and swap the element

Time: O(n)
Space: O(1)

*/
