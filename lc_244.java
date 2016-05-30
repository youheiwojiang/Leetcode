public class WordDistance {
    Map<String,List<Integer>>map;
    public WordDistance(String[] words) {
        map = new HashMap<String,List<Integer>>();
        for(int i = 0; i<words.length;i++){
            if(!map.containsKey(words[i]))   map.put(words[i],new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int ret = Integer.MAX_VALUE;
        List<Integer>w1 = map.get(word1);
        List<Integer>w2 = map.get(word2);
        for(int i = 0, j = 0; i < w1.size() && j < w2.size(); ) {
        int index1 = w1.get(i), index2 = w2.get(j);
        if(index1 < index2) {
            ret = Math.min(ret, index2 - index1);
            i++;
        } else {
            ret = Math.min(ret, index1 - index2);
            j++;
        }
    }
    return ret;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
