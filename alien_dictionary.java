public class alien_dictionary {
    public String alienOrder(String[] words) {
        return "";
    }
}


/*abstract
Explanation

They are already sorted
words = ["wrt","wrf","er","ett","rftt"]
t - f, t comes before f. [t,f] t -> f
w - e, w comes before w, [w,e] w -> e
for now, it could be w-f-e
r - t, r comes before t, [r,t] r -> t
This is a graph so now we have
r -> t -> f

e - r, e comes before r, [e,r] e -> r
e and r already in the graph, so now our graph has

w - e - r - t - f
BFS or DFS solution

*/