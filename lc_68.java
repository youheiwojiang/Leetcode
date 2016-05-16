public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>res = new ArrayList<>();
        //List<String>cache = new ArrayList<>();
        //boolean full = false;
        
        for(int i = 0 ,w; i< words.length ; i=w){
            int len = -1;
            for( w= i;w < words.length && words[w].length() +len + 1 <= maxWidth ;w++)
                len+= words[w].length() + 1;
            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if(w != i+ 1 && w!= words.length){//neither 1 in line nor last line
                 space = (maxWidth - len) / (w - i - 1) + 1;//one space covered for each word in len
                 extra = (maxWidth - len) % (w - i - 1);
            }
          for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = maxWidth - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');//for the last line or one-word line
            res.add(strBuilder.toString());
        }

        return res;
    }
}
