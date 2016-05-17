public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
       help(new ArrayList<>(), 0 , 0,n,k);
       return res;
    }
    void help(List<Integer>list, int max, int size,int n, int k){
        if(size == k){
            res.add(list);
            return;
        }
        for(int i = max+1;i+k-size-1<=n;i++){//an improvement i<=n is also good
            List<Integer>newlist = new ArrayList<>(list);
            newlist.add(i);
            help(newlist,i,size+1,n,k);
            
        }
        
        return;
    }
}
