// Definition for a Node.
import java.util.*;
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node clone (Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            newNode.neighbors.add(clone(node.neighbors.get(i)));
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        return clone (node);
    }
}
