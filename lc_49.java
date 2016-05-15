  public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs);
        List<List<String>>res=  new ArrayList<>();
        Map<String,List<String>>map = new HashMap<>();
        for(String str:strs){
            char arrays[] = str.toCharArray();
            Arrays.sort(arrays);
            String newstr = String.valueOf(arrays);//remember not use obj toString but use String.valueOf()????
            if(!map.containsKey(newstr)){
                map.put(newstr,new ArrayList<String>());
            }
            map.get(newstr).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}
