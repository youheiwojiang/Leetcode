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
    private int no = 0;
    private int num = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k-1);
        return num;
    }
    private void dfs(TreeNode root, int k){
        if(root.left != null ) dfs(root.left,k);
        if(k == no++) num = root.val;
        if(root.right!= null) dfs(root.right,k);
        return;
    }
}
