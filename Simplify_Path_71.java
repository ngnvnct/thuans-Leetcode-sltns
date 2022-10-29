import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class Simplify_Path_71 {
    public static void main(String[] args) {
        String exampleOne = "/home/";
        String exampleTwo = "/../";
        String exampleThree = "/home//foo/";
        String four = "/a//b////c/d//././/..";
        Simplify_Path_71 sol = new Simplify_Path_71();
        System.out.println(sol.simplifyPath(exampleOne));
        System.out.println(sol.simplifyPath(exampleTwo));
        System.out.println(sol.simplifyPath(exampleThree));
        System.out.println(sol.simplifyPath(four));
    }

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(directory);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.append("/").append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
    }

    public String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeFirst();
                }
            } else {
                stack.addFirst(directory);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append("/").append(stack.removeLast());
        }
        return res.toString();
    }

    @Test
    public void testPath() {
        String exampleOne = "/home/";
        String exampleOneExpectedresult = "/home";
        String exampleTwo = "/../";
        String exampleTwoExpectedResult = "/";
        String exampleThree = "/home//foo/";
        String exampleThreeExpectedResult = "/home/foo";
        String exampleFour = "/a//b////c/d//././/..";
        String exampleFourExpectedResult = "/a/b/c";

        assertEquals(exampleOneExpectedresult, simplifyPath(exampleOne));
        assertEquals(exampleTwoExpectedResult, simplifyPath(exampleTwo));
        assertEquals(exampleThreeExpectedResult, simplifyPath(exampleThree));
        assertEquals(exampleFourExpectedResult, simplifyPath(exampleFour));

        assertEquals(exampleOneExpectedresult, simplifyPath2(exampleOne));
        assertEquals(exampleTwoExpectedResult, simplifyPath2(exampleTwo));
        assertEquals(exampleThreeExpectedResult, simplifyPath2(exampleThree));
        assertEquals(exampleFourExpectedResult, simplifyPath2(exampleFour));
    }
}

/*
 * https://leetcode.com/problems/simplify-path/
 * Explanation
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