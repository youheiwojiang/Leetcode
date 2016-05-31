public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        if(n <= 1) return res;
        backTrack(n,2,new ArrayList<Integer>(),n);
        return res;
    }
    void backTrack(int n,int start,List<Integer>list,int limit){
        if(n == 1){
            res.add(list);
            return;
        }
        for(int i = start; i<limit && i<=n; i++){
            if(n % i == 0){
                List<Integer>tmp = new ArrayList<>(list);
                tmp.add(i);
                backTrack(n/i,i,tmp,limit);
            }
            
        }
        
    }
}
