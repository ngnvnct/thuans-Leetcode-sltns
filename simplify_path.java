import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class simplify_path {
    public static void main(String[] args) {
        String one = "/home/";
        String two = "/../";
        String three = "/home//foo/";
        String four = "/a//b////c/d//././/..";
        simplify_path sol = new simplify_path();
        System.out.println(sol.simplifyPath(one));
        System.out.println(sol.simplifyPath(two));
        System.out.println(sol.simplifyPath(three));
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
        String one = "/home/";
        String two = "/../";
        String three = "/home//foo/";
        String four = "/a//b////c/d//././/..";
        assertEquals("/home", simplifyPath(one));
        assertEquals("/", simplifyPath(two));
        assertEquals("/home/foo", simplifyPath(three));
        assertEquals("/a/b/c", simplifyPath(four));
    }
}


/*abstract
Explanation
Keep a stack to push the directory on it, and split the components to array of strings
if it is "." or the directory is empty, we just continue, "." means the current directory
if it is ".." meaning we want to go up one directory, we pop it out of the stack
else, we add it to the stack

Rhen we build a new string, 2 methods to build the string using Deque

Time: O(n)
Space: O(2n) -> O(n), split component array and the stack
*/