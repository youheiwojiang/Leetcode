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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return Sum(root,sum);
    }
    private boolean Sum(TreeNode root ,int num){
        //if(root == null) return num == 0;//sometimes we can't use null as base case ,we need the leaf node
        if(root.left == null && root.right == null) 
            return root.val== num;
        else if(root.left == null)
            return Sum(root.right,num -root.val);
        else if(root.right == null)
            return Sum(root.left, num - root.val);
        return Sum(root.left,num - root.val) || Sum(root.right, num - root.val);
    }
}
