public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]res = new int[numCourses];
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
            res[count++] = cur;
            //count++;
            for(int i = 0; i< numCourses;i++){
                if(matrix[cur][i] == 1){
                    if(--indegrees[i] == 0)
                        q.add(i);
                }
            }
        }
        return count == numCourses?res:new int[0];
    }
}
