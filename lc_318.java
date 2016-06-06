public class Solution {
    
    public int maxProduct(String[] words) {
      int max = Integer.MIN_VALUE;
      int[]table = new int[words.length];
      for(int i = 0; i< words.length; i++){
          for(char c:words[i].toCharArray()){
                table[i] |= (1<<(c-'a'));      
          }
      }
      for(int i = 0; i< words.length;i++){
          for(int j = i+1;j<words.length;j++){
                if(words[i].length() * words[j].length() < max) continue;   
                if((table[i] & table[j]) == 0) max = words[i].length() * words[j].length();
          }
      }
      return max == Integer.MIN_VALUE?0:max;
    }
}
