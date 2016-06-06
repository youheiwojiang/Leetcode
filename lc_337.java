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
    public int rob(TreeNode root) {
        /*
        if(root == null) return 0;
        int val = 0;
        if(root.left!= null) val+= rob(root.left.left)+rob(root.left.right);
        if(root.right!= null) val+= rob(root.right.left) + rob(root.right.right);
        return Math.max(val + root.val , rob(root.left) + rob(root.right));
        */
        Map<TreeNode,Integer>values = new HashMap<>();
        return robber(root,values);
    }
    private int robber(TreeNode root, Map<TreeNode,Integer>values){
        if(root == null) {values.put(root,0);return 0;}
        if(values.containsKey(root)) return values.get(root);
        
        int val = 0;
        if(root.left != null){
            val+= robber(root.left.left,values)+robber(root.left.right,values);
        }if(root.right != null){
            val+= robber(root.right.right,values)+ robber(root.right.left,values);
        }
        values.put(root,Math.max(val + root.val , robber(root.left,values) + robber(root.right,values)));
        return values.get(root);
    }
}
