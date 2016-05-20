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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,postorder,inorder.length,0,0);
        
    }
    private TreeNode build(int[] inorder, int[] postorder, int len , int il, int pl){
        if(len == 0) return null;
        TreeNode root = new TreeNode(postorder[pl+len-1]);
        int i = il;
        for(;inorder[i] != root.val ;i++){}
        root.left = build(inorder,postorder,i-il ,il,pl);
        root.right = build(inorder,postorder,len -1 -i+il,i+1,pl+i-il);
        return root;
    }
}
