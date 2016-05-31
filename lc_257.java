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
    List<String>res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        dfs(root,"");
        return res;
    }
    void dfs(TreeNode root,String path){
        if(path.length() ==0)
            path+= ""+root.val;
        else
            path += "->" + root.val ;
        if(root.left == null && root.right == null) res.add(path);
        if(root.left != null) dfs(root.left, path);
        if(root.right != null) dfs(root.right,path);
    }
}
