public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String word:strs){
            str.append(word.length()).append("/").append(word);
        }
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String>res = new ArrayList<>();
        int i = 0;
        int lastsplit = -1;
        while(i < s.length()){
            lastsplit = s.indexOf('/',i);
            int sz = Integer.valueOf(s.substring(i,lastsplit));
            res.add(s.substring(lastsplit+1,lastsplit+1+sz));
            i = lastsplit+1+sz;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
