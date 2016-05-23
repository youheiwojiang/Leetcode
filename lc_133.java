/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer,UndirectedGraphNode>vertexes = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)//attention
            return null;
        if(vertexes.containsKey(node.label))
            return vertexes.get(node.label);
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        vertexes.put(node.label,newnode);
        for(UndirectedGraphNode neighbour:node.neighbors){
                newnode.neighbors.add(cloneGraph(neighbour));
            
        }
        return newnode;
    }
}
