// recursive/backtracking version
public class Solution {
    List<String>res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        Map<Character,String>map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()==0) 
            return res;
        help(map,0,digits,new StringBuilder());
        return res;
    }
    public void help(Map<Character,String>map,int i,String s,StringBuilder str){
        if(i == s.length()){
            res.add(str.toString());
            return;
        }
        String tmp = map.get(s.charAt(i));
        /* for some illegal input
        if(tmp == null)
            return;
        */
        for(int j =0; j< tmp.length();j++){
            StringBuilder newstr = new StringBuilder(str);
            newstr.append(tmp.charAt(j));
            help(map,i+1,s,newstr);
        }
        return;
    }
}


///////////////////////////////////////////////////////
//iterative version:
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map ={"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
        // here notice cannot declare a List but a linkedlist?
        // consider why and we can return a linkedlist?
        LinkedList<String>res = new LinkedList<>();
        if(digits.length()==0)
            return res;
        res.add("");
        for(int i = 0; i< digits.length();i++){
            int index = digits.charAt(i) - '0';
            while(res.peek().length() == i ){
                String tmp = res.remove();
                for(char s : map[index].toCharArray()){
                    res.add(tmp+s);
                }
            }
        }
        return res;
    }
}
