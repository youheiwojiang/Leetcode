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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        dfs(root.left,root.val,1);
        dfs(root.right,root.val,1);
        return max;
    }
    private void dfs(TreeNode root, int val ,int len){
        if(len > max) max = len;
        if(root == null) return;
        if(root.val == val + 1) {
            dfs(root.left,root.val,len+1);
            dfs(root.right,root.val,len+1);
        }
        else{
            dfs(root.left,root.val,1);
            dfs(root.right,root.val,1);
        }
    }
}
