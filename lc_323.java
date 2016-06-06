public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n < 1) return 0;
        boolean visit[] = new boolean[n];
        List[]graph = new List[n];
        for(int i = 0; i< n;i++)
            graph[i] = new ArrayList<Integer>();
        for(int[]edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int count = 0;
        for(int i = 0; i< n; i++){
            if(!visit[i]){
                count++;
                dfs(i,visit,graph);
            }
        }return count;
    }
    private void dfs(int vertex, boolean[]visit, List<Integer>[]graph){
        visit[vertex] = true;
        for(int neighbour:graph[vertex]){
            if(!visit[neighbour])
                dfs(neighbour,visit,graph);
        }
        return;
    }
}
