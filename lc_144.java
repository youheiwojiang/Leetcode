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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode>stack = new Stack<>();
        List<Integer>res = new ArrayList<>();
        // if(root == null) return res;
        TreeNode p = root;
        
        while(!stack.isEmpty() || p!= null){
            if(p!=null){
                stack.push(p);
                res.add(p.val);
                p = p.left;
            }else{
                TreeNode q = stack.pop();
                p = q.right;
            }
        }
        return res;
    }
}
