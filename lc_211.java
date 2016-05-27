public class WordDictionary {
    class TrieNode{
        boolean end = false;
        TrieNode[]sons = new TrieNode[26];
        TrieNode(){}
        
    }
    private TrieNode root;
    WordDictionary(){
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        int i = 0;
        while(i<word.length()){
            char c = word.charAt(i);
            if(cur.sons[c-'a'] == null)
                cur.sons[c-'a'] = new TrieNode();
            cur =  cur.sons[c-'a'];
            i++;
        }cur.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
       return searchword(root,word);
    }
    private boolean searchword(TrieNode root, String word){
       if(root == null) return false;
       if(word.charAt(0) == '.'){
           if(word.length() == 1){
               for(TrieNode tmp:root.sons){
                    if (tmp!=null && tmp.end)
                        return true;
               }
               return false;
           }else
               for(TrieNode tmp:root.sons)
                    if(tmp!=null && searchword(tmp,word.substring(1)))
                        return true;
                return false;
       }else{
           if(word.length() == 1) return root.sons[word.charAt(0)-'a']!= null && root.sons[word.charAt(0)-'a'].end;
           else return root.sons[word.charAt(0)-'a']!= null && searchword(root.sons[word.charAt(0)-'a'],word.substring(1));
                
       }
       
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
