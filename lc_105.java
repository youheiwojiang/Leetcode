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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,preorder.length);
    }
    private TreeNode build(int[]preorder,int[]inorder, int pl, int il,int len){
        if(len == 0) return null;
        if(len == 1) return new TreeNode(inorder[il]);
        TreeNode root = new TreeNode(preorder[pl]);
        int index = il;
        for(; inorder[index] != root.val; index++){};
        root.left =  build(preorder,inorder,pl+1,il,index-il);
        root.right = build(preorder,inorder,pl+index-il+1,index+1,len -1 - index+il);
        return root;
    }
}
