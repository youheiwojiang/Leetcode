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
    boolean flag = false;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {flag= true;return 1;}
        if(root.left == null) {
             int count = countUnivalSubtrees(root.right);
             flag = (root.right.val == root.val && flag);
             count += flag?1:0;
             return count;
        }else if(root.right == null){
            int count = countUnivalSubtrees(root.left);
            flag = (root.left.val == root.val && flag);
            count+= flag?1:0;
            return count; 
        }else{
            int count1 = countUnivalSubtrees(root.left);
            boolean flag1 = flag;
            int count2 = countUnivalSubtrees(root.right);
            flag = flag1 && flag && root.val == root.left.val && root.val ==root.right.val;
            int count = count2 + count1 ;
            if(flag) count++;
            return count;
        }
        
    }
}
