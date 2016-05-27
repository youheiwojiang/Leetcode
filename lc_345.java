public class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char arrays[] = s.toCharArray();
        int l = 0, r= s.length()-1;
        while(l < r){
            while(!vowels.contains(arrays[l]+"") && l < r) // attention
                l++;
            while(!vowels.contains(arrays[r]+"") && l < r)
                r--;
            char tmp = arrays[l];
            arrays[l] = arrays[r];
            arrays[r] = tmp;
            l++;//attention
            r--;
        }
        return String.valueOf(arrays);
    }
}
