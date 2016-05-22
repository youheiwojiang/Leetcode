//concise version:
public class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    private int dfs(TreeNode root, int num){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return num*10 + root.val;
        return dfs(root.left, num*10 + root.val ) + dfs(root.right ,  num*10 + root.val);
    }
}

///////////////////////////////
//my version:
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
    public int res = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        dfs(root,root.val);
        return res;
    }
    private void dfs(TreeNode root, int val){
        if(root.left == null && root.right == null) {res += val ; return;}
        if(root.left != null)  dfs(root.left, 10*val + root.left.val);
        if(root.right != null)  dfs(root.right, 10*val + root.right.val);
        
    }
}
