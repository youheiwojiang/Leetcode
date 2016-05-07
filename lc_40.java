   public class Solution {
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findcombination(candidates,target,new ArrayList<>(),0);
        return res;
    }
    public void findcombination(int []candidates, int target ,List<Integer>cur,int index){
        if(target == 0){
            res.add(cur);
            return;
        }
        int last = index<candidates.length?candidates[index]:-1;//here need considering
        for(int i = index;i<candidates.length;i++){
           if(candidates[i] > target || (candidates[i] == last && i!= index))
                continue;
            List<Integer>list = new ArrayList<>(cur);
            list.add(candidates[i]);
            //if(i < candidates.length )
            findcombination(candidates,target-candidates[i],list,i+1);
            last = candidates[i];
        }
        return;
    }
}
