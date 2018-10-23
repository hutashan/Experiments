package F;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
    HashMap<Integer,UndirectedGraphNode> hs = new HashMap<Integer,UndirectedGraphNode>();
    public static void main(String[] args) {

    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer,UndirectedGraphNode> hs = new HashMap<Integer,UndirectedGraphNode>();
        return DFScloneGraph(node);
    }
    private UndirectedGraphNode DFScloneGraph(UndirectedGraphNode node) {
        if(node==null) return node;
        if(hs.containsKey(node.label)){
            return hs.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        hs.put(clone.label,clone);
        for(UndirectedGraphNode neighbour:node.neighbors){
            clone.neighbors.add(DFScloneGraph(neighbour));
        }
        return clone;

    }
}
