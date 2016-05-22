public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //bfs
        Queue<String>q = new LinkedList<>();
        q.add(beginWord);
        wordList.add(endWord);
        wordList.remove(beginWord);
        int layer = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i< sz; i++){
                String tmp = q.poll();
                if(tmp.equals(endWord))
                    return layer;
                for(String neighbour: neighbours(tmp,wordList))
                    q.add(neighbour);
            }
            layer++;
            
        }
        return 0;
    }
    private List<String>neighbours(String str, Set<String>wordList){
        List<String>res = new ArrayList<>();
        for(int i = 0; i< str.length(); i++){
            char[]arrays = str.toCharArray();
            for(char ch = 'a'; ch <='z';ch++){
                arrays[i] = ch;
                String word = new String(arrays);
                if(wordList.remove(word)) res.add(word);
            }
        }return res;
        
        
    }
}
