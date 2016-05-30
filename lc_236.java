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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        
        TreeNode leftA =  lowestCommonAncestor( root.left,p,q);
        TreeNode rightA =  lowestCommonAncestor( root.right,p,q);
        /* need to be improved
        if(leftA == p && rightA == q || leftA == q && rightA == p) return root;
        else if(leftA == null) return lowestCommonAncestor( rightA,p,q);
        else return lowestCommonAncestor( leftA,p,q);
        */
        if(leftA != null && rightA != null) return root;
        return leftA == null?rightA:leftA;
    }
}
