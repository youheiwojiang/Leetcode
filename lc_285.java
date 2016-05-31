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
    TreeNode successor  = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root,p);
        return successor;
        
    }
    private void inorder(TreeNode root, TreeNode p){
        if(root == null) return;
        inorder(root.right,p);
        if(root.val > p.val) successor = root;
        inorder(root.left,p);
    }
}
