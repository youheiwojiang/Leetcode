public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String>res = new ArrayList<>();
        int[]table = new int[256];
        for(int i = 0; i<s.length();i++){
            table[s.charAt(i)]++;
        }
        String mid = "";
        for(int i = 0;i<256;i++){
            if(table[i] % 2 != 0  ){
                if(mid.length()>0)
                    return res;
                else
                    mid = mid+(char)i;
            }
            table[i]/=2;
        }
        dfs(res,table,mid, s.length());
        return res;
    }
    void dfs(List<String>res, int[]table, String mid, int len){
        if(mid.length() == len){
            res.add(mid);
            return;
        }
        for(int i = 0; i<256;i++){
            if(table[i] == 0) continue;
            mid = (char)i+mid + (char)i;
            table[i]--;
            dfs(res,table,mid,len);
            mid = mid.substring(1,mid.length()-1);
            table[i]++;
        }
        return;
    }
}
