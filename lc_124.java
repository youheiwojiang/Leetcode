//**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
       
        maxPathDown(root);
        return max;
    }
    public int maxPathDown(TreeNode root){//besides return the max down path value also update the maxPathsum!
         if(root == null) return 0;
         int left = Math.max(0,maxPathDown(root.left));//attention we may throw all the subtree if it's max < 0
         int right = Math.max(0,maxPathDown(root.right));
         max = Math.max(max,root.val +right + left);
         return Math.max(left,right) + root.val;
    }

