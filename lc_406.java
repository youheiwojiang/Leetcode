public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<int[]>pq = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int []a, int[] b){
               if(a[1] != b[1]){
                   return a[1] - b[1];
               }else
                   return a[0] - b[0];
           }
            
        });
        for(int[]person:people){
            pq.add(person);
        }
        List<int[]>res = new ArrayList<>();
        while(!pq.isEmpty()){
            int[]tmp = pq.remove();
            if(tmp[1] == 0){
                res.add(tmp);
            }else{
                int index = tmp[1];
                int i = 0;
                while(index != 0){
                    if(res.get(i)[0] >= tmp[0]){
                        index--;
                    }i++;
                }
                while(i < res.size() && res.get(i)[1] == tmp[1]){
                    i++;
                }
                res.add(i,tmp);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
