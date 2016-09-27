public class Solution {
    class point{
        int x;
        int y;
        int height;
        public point(int x, int y, int height){
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0) return 0;
        int rowNum = heightMap.length;
        int colNum = heightMap[0].length;
        PriorityQueue<point>pq = new PriorityQueue<>(new Comparator<point>(){
            public int compare(point a, point b){
                return a.height - b.height;
            }   
        });
        boolean[][]visited = new boolean[rowNum][colNum];
        for(int i = 0; i< rowNum; i++){
            pq.add(new point(i,0,heightMap[i][0]));
            pq.add(new point(i,colNum-1,heightMap[i][colNum-1]));
            visited[i][0] = true;
            visited[i][colNum-1] = true;
        }
        for(int j = 1; j< colNum-1; j++){
            pq.add(new point(0,j,heightMap[0][j]));
            pq.add(new point(rowNum-1,j,heightMap[rowNum-1][j]));
            visited[0][j] = true;
            visited[rowNum-1][j] = true;
        }
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};
        int res = 0;
        while(!pq.isEmpty()){
            point tmp = pq.remove();
            for(int i = 0; i< 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >0 && nx < rowNum && ny > 0 && ny < colNum && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    res+= Math.max(0,tmp.height - heightMap[nx][ny]);
                    pq.add(new point(nx,ny,Math.max(tmp.height,heightMap[nx][ny])));
                }
            }
        }
        return res;
    }
}
