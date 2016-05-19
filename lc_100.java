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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q== null) return q== null && p ==null;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right) && p.val == q.val;
    }
}
