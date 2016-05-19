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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode>s = new Stack<>();
        TreeNode p = root;
        while(!s.isEmpty() || p != null){
           if( p != null){      
               s.push(p);
               p = p.left;
           }else{            // if cur node don't have left child add the val to list and handle the right child 
               TreeNode q = s.pop();
               res.add(q.val);
               p = q.right;
           }
        }
        return res;
    }
}
