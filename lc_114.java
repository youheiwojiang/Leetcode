//a short post order traversal code:
private TreeNode prev = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
}

//////////////////////////////////////////////////
//my code:
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
    TreeNode tail = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        tail = root; // attention!tail will be changed by the rightmost node in the left subtree of root
        TreeNode left= root.left;
        TreeNode right =root.right;
        flatten(left);
        root.right = left;
        TreeNode tmp = tail;
        flatten(right);
        tmp.right = right;
        root.left =null; // key
    }
}
