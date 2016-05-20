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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return Symmetric(root.left,root.right);
    }
    private boolean Symmetric(TreeNode a, TreeNode b){
        if(a == null || b== null){
            return a==null && b== null;
        }
        return a.val == b.val && Symmetric(a.left,b.right) && Symmetric(a.right,b.left);
    }
}
