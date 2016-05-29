public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
       help(new ArrayList<Integer>(),  n , k ,1, 0);
       return res;
        
    }
    private void help(List<Integer>list, int n , int k ,int start,int sum ){
        if(list.size() == k){
            if(sum == n)
                res.add(list);
            return;
        }
        for(int i = start; i<=9;i++){
            if(sum + i <= n){
                List<Integer>newl = new ArrayList<>(list);
                newl.add(i);
                help(newl,n,k,i+1,sum+i);
            }
        }
        return;
    }
}
