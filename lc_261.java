public class Solution {
    int count = 0;
    public boolean validTree(int n, int[][] edges) {
        List[]graph = new List[n];
        for(int i = 0; i< n; i++)
            graph[i] = new ArrayList<Integer>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean visit[] = new boolean[n];
        dfs(0,visit,graph);
        return count == n && edges.length == n-1;
    }
    void dfs(int vertex, boolean[]visit, List<Integer>[]graph){
        if(visit[vertex]) return ;
        visit[vertex] = true;
        count++;
        for(int neighbour:graph[vertex]){
           dfs(neighbour,visit,graph);
        }
        return ;
    }
}
