public class Solution {
    public List<String> findStrobogrammatic(int n) {
        Queue<String>res = new LinkedList<>();
        if(n % 2 == 0) res.add("");
        else{
            res.add("0");res.add("1");res.add("8");
        }
        for(int i = n/2 ; i>0; i-= 1){
            int sz = res.size();
            for(int j = 0;j<sz;j++){
                String cur = res.poll();
                res.add("1"+cur+"1");
                res.add("6"+cur+"9");
                res.add("9"+cur+"6");
                res.add("8"+cur+"8");
                if(i != 1)
                res.add("0"+cur+"0");
            }
            
        }
        
        return new ArrayList<>(res);
        
    }
}
