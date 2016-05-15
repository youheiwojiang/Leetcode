  public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>cur= new ArrayList<>();
        res.add(cur);
        for(int num :nums){
           List<List<Integer>>newlist = new ArrayList<>();
           for(List<Integer>list : res){
               for(int i = 0; i<=list.size();i++){
                   List<Integer>tmp = new ArrayList<>(list);
                   tmp.add(i,num);
                   newlist.add(tmp);
               }
           }
           res = newlist;
        }
        return res;
    }
}
