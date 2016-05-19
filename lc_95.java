/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        return help(1,n);
        
    }
    public List<TreeNode> help(int l, int r){
      
       List<TreeNode>list = new ArrayList<>();
        if(l>r) {
            list.add(null);
            return list;
        }
       if(l == r)  {
           list.add(new TreeNode(l));
           return list;
       }
       for(int i = l;i<=r;i++){
           List<TreeNode>ll = help(l,i-1);
           List<TreeNode>rr = help(i+1,r);
          
           for(TreeNode ln:ll){
               for(TreeNode rn:rr){
                  TreeNode root = new TreeNode(i);//attention this position can't put it outside the for loop;
                   root.left = ln;
                   root.right = rn;
                   list.add(root);
                   
               }
           }
       }
        return list;
    }
}
