  public class Solution {
    Set<List<Integer>>res = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //Arrays.sort(nums);
        res.add(new ArrayList<>());
        for(int num : nums){
            Set<List<Integer>>newl = new HashSet<>();
            for(List<Integer>l : res){
                int start = 0;
                while(start <= l.size()){
                    //while(start <l.size() &&l.get(start) == num){ start++;}       
                    List<Integer>list = new ArrayList<>(l);
                    list.add(start,num);
                    newl.add(list);
                    start++;
                }
            }
            res = newl;
        }
        List<List<Integer>>list = new ArrayList<>(res);
        return list;
    }
}
