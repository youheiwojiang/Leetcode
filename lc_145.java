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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode>s = new Stack<>();
        List<Integer> res = new LinkedList<>();
        TreeNode p  = root;
        while(!s.isEmpty() || p != null){
            if(p != null) {
                res.add(0,p.val);
                s.push(p);
                p = p.right;// key part
            }else{
                p = s.pop().left;
            }
            
        }
        return res;
    }
}
