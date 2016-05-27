class TrieNode {
    // Initialize your data structure here.
    public boolean end;
    public TrieNode[]sons; 
    public TrieNode() {
        end = false;
        sons = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    //help method:
    private void insert(String word, TrieNode root){
        char cur = word.charAt(0);
        if(root.sons[cur-'a'] == null)
            root.sons[cur-'a'] = new TrieNode();
        if(word.length() == 1)
            root.sons[cur-'a'].end = true;
        else
            insert(word.substring(1),root.sons[cur-'a']);
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        insert(word,root);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        int i = 0;
        while(i < word.length()){
            if(cur.sons[word.charAt(i) - 'a'] == null)
                return false;
            cur = cur.sons[word.charAt(i)-'a'];
            i++;
        }
        return cur.end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        int i = 0;
        while(i < prefix.length()){
            if(cur.sons[prefix.charAt(i) - 'a'] == null)
                return false;
            cur = cur.sons[prefix.charAt(i)-'a'];
            i++;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
