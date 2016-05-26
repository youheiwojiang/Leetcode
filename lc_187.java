public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String>seen = new HashSet<>();
        Set<String>dup = new HashSet<>();
        for(int i = 0; i+9< s.length();i++){
            String ten = s.substring(i,i+10);
            if(!seen.add(ten))
                dup.add(ten);
        }
        return new ArrayList<String>(dup);
    }
}
