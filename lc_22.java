
public class Solution {
    List<String>res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        help(0,0,"",n);
        return res;
    }
    void help(int left, int right, String cur,int n){
        if(left == n && right == n){
            res.add(cur);
            return;
        }
        if(left < n){
            String tmp = new String(cur);
            tmp+= '(';
            help(left+1,right,tmp,n);
        }
        if(right < left){
            String tmp = new String(cur);
            tmp+= ')';
            help(left,right+1,tmp,n);
        }
        return ;
    }
}
