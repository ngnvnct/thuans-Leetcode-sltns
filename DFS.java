import java.util.ArrayList;
import java.util.List;

public class DFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> dfs(List<String> array) {
            array.add(name);
            /*for (Node child : children) {
                child.dfs(array);
            }*/
            for (int i = 0; i< children.size(); i++) {
                children.get(i).dfs(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

/*
 * Explanation
 * [ABEFIJCDGKH]
 * 
 * We are going Deep, rather than Wide. As deep as we can, before exploring the
 * next branch
 * 
 */
