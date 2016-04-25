
// It's a simple version:
public class Solution {
    public  List<Integer> findSubstring(String S, String[] L) {
    List<Integer> res = new ArrayList<Integer>();
    if (S == null || L == null || L.length == 0) return res;
    int len = L[0].length(); // length of each word

    Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
    for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

    for (int i = 0; i <= S.length() - len * L.length; i++) {
        Map<String, Integer> copy = new HashMap<String, Integer>(map);
        for (int j = 0; j < L.length; j++) { // checkc if match
            String str = S.substring(i + j*len, i + j*len + len); // next word
            if (copy.containsKey(str)) { // is in remaining words
                int count = copy.get(str);
                if (count == 1) copy.remove(str);
                else copy.put(str, count - 1);
                if (copy.isEmpty()) { // matches
                    res.add(i);
                    break;
                }
            } else break; // not in L
        }
    }
    return res;
    }
}


/////////////////////////////////////////////////////////////////////
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer>res = new LinkedList<>();
        if(s.length() == 0 || words.length == 0 || s.length() < words.length * words[0].length())
            return res;
        Map<String,Integer>map = new HashMap<String,Integer>(),cur = new HashMap<String,Integer>();
        for(String w:words)
            map.put(w,map.containsKey(w)?map.get(w)+1:1);
        int N = s.length(),K = words[0].length(),M = words.length;
        String str =null,tmp = null;
        for(int i = 0; i<K; i++ ){
            int count = 0;
            for(int l = i,r = i;r+K<=N;r+= K){
                str = s.substring(r,r+K);
                if(map.containsKey(str)){
                    if(cur.containsKey(str)) cur.put(str,cur.get(str)+1);
                    else  cur.put(str,1);
                    if(cur.get(str) <= map.get(str)) count++;
                    while(cur.get(str) > map.get(str)){
                        tmp = s.substring(l,l+K);
                        cur.put(tmp,cur.get(tmp)-1);
                        l+= K;
                        if(cur.get(tmp) < map.get(tmp))  count--;
                }
                if(count == M){
                    res.add(l);
                    tmp = s.substring(l,l+K);
                    cur.put(tmp,cur.get(tmp)-1);
                    l+= K;
                    count--;
                }
                }else{
                    cur.clear();
                    l = r + K;
                    count = 0;
                }
            }
            cur.clear();
        }return res;
    }
}
