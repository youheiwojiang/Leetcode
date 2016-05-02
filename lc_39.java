    public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        addelement(new ArrayList<Integer>(),candidates,0,target);
        return res;
    }
    public void addelement(List<Integer>list , int[] candidates,int index, int sum){
        if(sum == 0){
            List<Integer>newlist = new ArrayList<>(list);//always need to new a list since it's changeable
            res.add(newlist);
            return;
        }
        for(int i = index; i< candidates.length;i++){
            if(candidates[i] <= sum){
                //List<Integer>newlist = new ArrayList<>(list);
                //newlist.add(candidates[i]);
                list.add(candidates[i]);
                addelement(list,candidates,i,sum-candidates[i]);
                list.remove(list.size()-1);
            }
        }
        return;
    }
}
