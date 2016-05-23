//my TLE version(forward DP)
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String>result = new LinkedList<>();
        if(s.length() == 0){
            if(wordDict.contains(s)) result.add(s);
            return result;
        }
        Map<Integer,List<String>>map = new HashMap<>();
        //List<String>[] results = new List[s.length()+1];
        for(int i = 0; i<=s.length();i++)
          map.put(i,new ArrayList<>());
        map.get(0).add("");
        for(int i = 1; i<=s.length();i++){
            for(String word:wordDict){
                if(word.length() <= i && map.get(i-word.length()).size()!=0 && word.equals(s.substring(i-word.length(),i)))
                    for(String str: map.get(i-word.length())){
                        if(str == "")
                            map.get(i).add(word);
                        else
                            map.get(i).add(str+" "+word);
                    }
            }
        }
        return map.get(s.length());
        
    }
}

//////////////////////////////////
//accepted version(backtracking)
public class Solution {
    Map<String,List<String>>map = new HashMap<>();//backtracking method
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(map.containsKey(s))
            return map.get(s);
        int len = s.length();
        List<String> ret = new ArrayList<String>();
        if(wordDict.contains(s))
            ret.add(s);
        for(int i=1;i<len;i++){
            String curr = s.substring(i);
            if(wordDict.contains(curr)){
                List<String> strs = wordBreak(s.substring(0,i),wordDict);
                if(strs.size() != 0 ){
                    for(Iterator<String> it = strs.iterator(); it.hasNext();){
                        ret.add(it.next() + " " + curr);
                    }
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
