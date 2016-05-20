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
    public boolean isBalanced(TreeNode root) {
        //if(root == null) return true;
        return balanced(root) >= 0;
    }
    private int balanced(TreeNode root){
        if(root == null) return 0;
        //if(balanced(root.lef))
        int left= balanced(root.left);
        int right = balanced(root.right);
        if(left < 0 || right < 0 || Math.abs(right - left) > 1) 
            return -1;
        return Math.max(left,right) + 1;
    }
}
