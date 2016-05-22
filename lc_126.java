public class Solution {
    List<List<String>>results;
    Map<String,List<String>>map = new HashMap<String, List<String>>() ;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        results = new ArrayList<>();
        if(wordList.size() == 0) return results;
        int min = Integer.MAX_VALUE;
        Queue<String>q = new LinkedList<>();
        wordList.add(endWord);
        q.add(beginWord);
        Map<String,Integer>ladder = new HashMap<>();
        for(String word:wordList)
            ladder.put(word,Integer.MAX_VALUE);
        ladder.put(beginWord,0);
        while(!q.isEmpty()){ //consider use word-ladder 1's bfs to simplify this code
            String word = q.poll();
            int step = ladder.get(word) + 1;
            if(step > min) break; //?
            for (int i = 0; i < word.length(); i++){
               StringBuilder builder = new StringBuilder(word); 
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();             
                    if (ladder.containsKey(new_word)) {

                        if (step>ladder.get(new_word))//Check if it is the shortest path to one word.
                            continue;
                        else if (step<ladder.get(new_word)){
                            q.add(new_word);
                            ladder.put(new_word, step);
                        }else;// It is a KEY line. If one word already appeared in one ladder,
                              // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
                        if (map.containsKey(new_word)) //Build adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> list= new LinkedList<String>();
                            list.add(word);
                            map.put(new_word,list);
                        }
                        if (new_word.equals(endWord))
                            min=step;
                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While
        LinkedList<String> result = new LinkedList<String>();
        backTrace(endWord,beginWord,result);
        return results;     
    }
    private void backTrace(String end, String begin, List<String>result){
        if(end.equals(begin)){
            result.add(0,end);
            results.add(new LinkedList<>(result));
            result.remove(0);
            return;
        }
        result.add(0,end);
        if(map.get(end) != null)
        for(String neighbour:map.get(end)){
            backTrace(neighbour,begin,result);
        }
        result.remove(0);
        return;
        
    }
}
