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
    TreeNode rightmost = null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        if(root.left == null){
            rightmost = root;
            return root;
        }
        TreeNode newroot= upsideDownBinaryTree(root.left);
        rightmost.right = root;
        rightmost.left = upsideDownBinaryTree(root.right);
        rightmost = root;
        root.left= null;
        root.right = null;
        return newroot;
    }
}
