// a DFS version(very slow)
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Map<Integer,List<Integer>>graph = new HashMap<>();
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i<numCourses;i++) graph[i] =  new ArrayList<Integer>();
        for(int[]prerequisite:prerequisites){
            //if(!graph.containsKey(prerequisite[1])) graph.put(prerequisite[1],new ArrayList<Integer>());
            //graph.get(prerequisite[1]).add(prerequisite[0]);
            int start = prerequisite[1],end = prerequisite[0];
            graph[start].add(end);
        }//construct a graph;
        //check no loops
        boolean visited[] = new boolean[numCourses];
        for(int i = 0; i< numCourses; i++){
                if(!dfs(i,visited,graph))
                    return false;
        }
        return true;
    }
    boolean dfs(int vertex, boolean[]visited,ArrayList<Integer>[]graph){
        //if(!graph.containsKey(vertex)) return true; //key
        if(visited[vertex]) return false;
        else
            visited[vertex] = true;
        for(int neighbour:graph[vertex]){
            if(!dfs(neighbour,visited,graph))
                return false;
        }
        visited[vertex] = false;
        return true;
    }
}
///////////////////////////////////////////
//BFS:
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]indegrees = new int[numCourses];
        int[][]matrix = new int[numCourses][numCourses];
        for(int[]prerequisite:prerequisites){
            int ready = prerequisite[0],pre = prerequisite[1];
            if(matrix[pre][ready] == 0)//key part : since we only minus 1 from indegree(we can only count once)
                indegrees[ready]++;
            matrix[pre][ready] = 1;
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i<numCourses;i++){
            if(indegrees[i] == 0) q.add(i);
        }
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int i = 0; i< numCourses;i++){
                if(matrix[cur][i] == 1){
                    if(--indegrees[i] == 0)
                        q.add(i);
                }
                
            }
            
            
        }
        return count == numCourses;
    }
}
