public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1,index2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<words.length;i++){
           if(words[i].equals(word2)){
                if(words[i].equals(word1))
                    index2 = index1;
                else
                index2 = i;
           }
            if(words[i].equals(word1))
                index1 = i;
         
            if(index1 >=0 && index2 >=0)
                res = Math.min(res, Math.abs(index1 - index2));
            
        }
        return res;
    }
}
