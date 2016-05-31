public class ValidWordAbbr {
    Map<String,String>map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String str:dictionary){
            String tmp = "";
            if(str.length() < 2)
                tmp = str;
            else
                tmp = ""+str.charAt(0)+str.charAt(str.length()-1)+str.length();
            if(map.containsKey(tmp)){
                if(!map.get(tmp).equals(str))
                    map.put(tmp,"");
            }
            else map.put(tmp,str);
        }
    }
    public boolean isUnique(String word) {
        String tmp = "";
        if(word.length()<2)
            tmp = word;
         else
         tmp = ""+word.charAt(0)+word.charAt(word.length()-1)+word.length();
         return !map.containsKey(tmp)||map.get(tmp).equals(word);
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
