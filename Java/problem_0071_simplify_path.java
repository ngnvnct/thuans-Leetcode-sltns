/*
 * https://leetcode.com/problems/simplify-path/
 * Explanation:
 * 
 * Keep a stack to push the directory on it, and split the components to array
 * of strings
 * if it is "." or the directory is empty, we just continue, "." means the
 * current directory
 * if it is ".." meaning we want to go up one directory, we pop it out of the
 * stack
 * else, we add it to the stack
 * 
 * Then we build a new string, 2 methods to build the string using Deque
 * 
 * Time: O(n)
 * Space: O(2n) -> O(n), split component array and the stack
 */

package Java;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class problem_0071_simplify_path {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(directory);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : deque) {
            sb.append("/").append(dir);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }

    public String simplifyPath2(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeFirst();
                }
            } else {
                deque.addFirst(directory);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeLast());
        }
        return sb.toString();
    }

    @Test
    public void testSimplifyPath() {
        String testCase1 = "/home/";
        String testCase1Expectedresult = "/home";
        String testCase2 = "/../";
        String testCase2ExpectedResult = "/";
        String testCase3 = "/home//foo/";
        String testCase3ExpectedResult = "/home/foo";
        String testCase4 = "/a//b////c/d//././/..";
        String testCase4ExpectedResult = "/a/b/c";

        assertEquals(testCase1Expectedresult, simplifyPath(testCase1));
        assertEquals(testCase2ExpectedResult, simplifyPath(testCase2));
        assertEquals(testCase3ExpectedResult, simplifyPath(testCase3));
        assertEquals(testCase4ExpectedResult, simplifyPath(testCase4));

        assertEquals(testCase1Expectedresult, simplifyPath2(testCase1));
        assertEquals(testCase2ExpectedResult, simplifyPath2(testCase2));
        assertEquals(testCase3ExpectedResult, simplifyPath2(testCase3));
        assertEquals(testCase4ExpectedResult, simplifyPath2(testCase4));
    }
}