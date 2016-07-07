public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character,Integer>map = new HashMap<>();
        int a = 0, b = 0;
        for(int i = 0; i< secret.length();i++){
            char c = secret.charAt(i);
            if(c == guess.charAt(i)) {a++;continue;}
            if(!map.containsKey(c)) map.put(c,0);
            map.put(c,map.get(c)+1);
        }
        for(int j = 0; j< guess.length(); j++){
            char cur = guess.charAt(j);
            if(cur == secret.charAt(j)) continue;
             if(map.containsKey(cur)){
                    map.put(cur,map.get(cur) -1);
                    if(map.get(cur) == 0) map.remove(cur);
                    b++;
            }
        }
        return a+"A"+b+"B";
    }
}
////////////////////////
//one - pass version:
public String getHint(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}
