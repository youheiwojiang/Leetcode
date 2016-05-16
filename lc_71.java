//this is my stupid code
public class Solution {
    public String simplifyPath(String path) {
        StringBuilder str = new StringBuilder();
        //String paths[] = path.subs.split("/");
        Stack<String>stack = new Stack<>();
        int i = 0;
        int last = -1;
        while(i < path.length()){
            if(path.charAt(i) == '/' ){
                if(last < 0){
                    i++;
                    continue;
                }
                String section = path.substring(last+1,i);
                if(section.equals(".")){}
                else if(section.equals("..")){
                    if(!stack.isEmpty())
                        stack.pop();
                }else 
                    stack.push(section);
                while(i<path.length()-1&&path.charAt(i+1)== '/') i++;
                last = i;
            }
            else if(last < 0)
                last = i-1;
            i++;
        }
        if(last >=0 && last < path.length()-1 ){
            String end = path.substring(last+1) ;    
            if(end.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!end.equals("."))
                stack.push(end);
        }
        while(!stack.isEmpty()){
            //String cur = stack.pop();
            str.insert(0,stack.pop());
            str.insert(0,"/");
        }
        return str.length()==0?"/":str.toString();
        
    }
}
/////////////////////////////////////////////////////////////////////////////////////////
public class Solution {
    public String simplifyPath(String path) {
        Stack<String>stack = new Stack<>();
        Set<String>set = new HashSet<>(Arrays.asList(".","..",""));//needs attention
        for(String str:path.split("/")){
            if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
            }else if(!set.contains(str)){
                stack.push(str);
            }
        }
        String res = "";
        for(String str:stack)
            res = res+"/"+str;
        return res.length() == 0?"/":res;
    }
}
