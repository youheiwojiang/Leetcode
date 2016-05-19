//a genious code:
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }
}
/////////////////////////////////////////////
//my backtracking code:
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String>res = new ArrayList<>();
        help(res,new StringBuilder(),0,-1,s);
        return res;
    }
    public void help(List<String>res, StringBuilder cur, int num,int index, String s){
        if(num == 4 ){
            if(index == s.length()-1)
                res.add(cur.toString());
            return;
        }
        int count = 0;
        for(int i = index+1;i<=Math.min(index+3,s.length()-1);i++){
            char c = s.charAt(i);
            if(c>'9' || c<'0' )
                return ;
            if(i != index +1 && count ==0 || count*10+c-'0' > 255)
                return;
            count = 10*count+c-'0';
            StringBuilder newcur = new StringBuilder(cur);//
            if(newcur.length()!=0)
                newcur.append(".");
            newcur.append(s.substring(index+1,i+1));
            help(res,newcur,num+1,i,s);
            
        }
        
        
    }
}
