public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Arrays.sort(strings);
        Map<String,List<String>>map = new HashMap<>();
        for(String str:strings){
            String tmp = move(str);
            if(!map.containsKey(tmp)) map.put(tmp,new ArrayList<>());
            map.get(tmp).add(str);
        }
        return new ArrayList<>(map.values());
    }
    private String move(String s){
        char[] arrs = s.toCharArray();
        int  dist = arrs[0] - 'a';
        for(int i = 0; i< arrs.length;i++) //keypart
            arrs[i] -= arrs[i]-dist<'a'?dist:dist+26;
        return String.valueOf(arrs);
    }
    
    
    
}
