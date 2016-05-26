public class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length == 0) return "";
        String []strs = new String[nums.length];
        for(int i = 0; i< nums.length;i++){
            strs[i] = nums[i] + "";
        }
        Comparator<String>comp = new Comparator<String>(){
           public int compare(String str1, String str2){
               String a = str1+ str2;
               String b = str2 + str1;
               return b.compareTo(a);
           }
        };
        
        Arrays.sort(strs,comp);
        if(strs[0].equals("0")) return "0";//attention duplicate 0
        String res = "";
        for(String tmp:strs) res+= tmp;
        return res;
    }
}
