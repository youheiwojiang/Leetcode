public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String>res = new LinkedList<>();
        if(s.length() < 2) return res;
        for(int i = 0; i< s.length() -1;i++){
            if(s.substring(i,i+2).equals("++"))
                res.add(s.substring(0,i) + "--" + s.substring(i+2));
           // else if(s.substring(i,i+2).equals("--"))
             //   res.add(s.substring(0,i) + "++" + s.substring(i+2));
        }
        return res;
    }
}
