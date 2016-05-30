public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String>res = new ArrayList<>();
        if(nums.length == 0) return res;
        //if(nums.length == 1) {res.add(String.valueOf(nums[0])); return res;}
        int prev = nums[0],end = prev;
        for(int i = 1; i<nums.length;i++){
            if(nums[i] == end+1) end++;
            else{
                if(prev == end)
                res.add(String.valueOf(prev));
                else
                res.add(prev+"->"+end);
                prev = nums[i];
                end = prev;
            }
        }
         if(prev == end)
         res.add(String.valueOf(prev));
         else
         res.add(prev+"->"+end);
         return res;
    }
}
///////////////////////////////////////////////////
public List<String> summaryRanges(int[] nums){
List<String> list=new ArrayList();
    if(nums.length==1){
        list.add(nums[0]+"");
        return list;
    }
    for(int i=0;i<nums.length;i++){
        int a=nums[i];
        while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
            i++;
        }
        if(a!=nums[i]){
            list.add(a+"->"+nums[i]);
        }else{
            list.add(a+"");
        }
    }
    return list;

}
