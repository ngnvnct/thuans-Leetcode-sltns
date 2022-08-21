import java.util.ArrayList;
import java.util.List;

public class Course_Schedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true; // ??
        }

        // create the array lists to represent the courses
        List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<Integer>());
        }

        // create the dependency graph
        for (int i = 0; i < prerequisites.length; i++) {
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        // dfs visit each course
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courses, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
        visited[course] = 1; // mark it being visited
        List<Integer> eligibleCourses = courses.get(course); // get its children

        // dfs its children
        for (int i = 0; i < eligibleCourses.size(); i++) {
            int eligibleCourse = eligibleCourses.get(i).intValue();

            if (visited[eligibleCourse] == 1) {
                return false; // has been visited while visiting its children - cycle !!!!
            }
            if (visited[eligibleCourse] == 0) { // not visited
                if (!dfs(eligibleCourse, courses, visited)) {
                    return false;
                }
            }

        }
        visited[course] = 2; // mark it done visiting
        return true;
    }
}

/*
 * https://leetcode.com/problems/course-schedule/
 * Explanation
 * This is a graph problem
 * 
 * Impossible case
 * n = 2, 0 and 1
 * prereq = [[1,0], [0,1]]
 * If we want to finish course 0, we have to finish course 1
 * If we want to finish course 1, we have to finish course 0
 * 0 <-> 1, this is a cycle
 * 
 * DFS n = 5
 * Prereq = [[0,1], [0,2], [1,3], [1,4], [3,4]
 * 5 edges
 * 
 * 0 -> 1 -> 3 -> 4
 * 0 - > 2
 * 1 -> 4
 * 2 and 4 don't have any prereq
 * 
 * preMap
 * course| pre | recursive
 * 0 [1,2] [] x
 * 1 [3,4] [] x
 * 2 [] x
 * 3 [4] [] x
 * 4 [] x
 * 
 * Time: O(|E| + |V|) where |V| is the number of courses and |E | is the number of dependencies
 * Space: O(|E| + |V|)
 */