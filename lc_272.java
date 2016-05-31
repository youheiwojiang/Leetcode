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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer>s1 = new Stack<>();
        Stack<Integer>s2 = new Stack<>();
        inorder(root,target,true,s2);
        inorder(root,target,false,s1);
        List<Integer>res = new ArrayList<Integer>();
        int count = 0;
        while(k-->0){
            if(s1.isEmpty()) res.add(s2.pop());
            else if(s2.isEmpty()) res.add(s1.pop());
            else{
                if(Math.abs(target - s1.peek()) < Math.abs(target-s2.peek())) res.add(s1.pop());
                else res.add(s2.pop());
            }
            
        }
        return res;
        
    }
    private void inorder(TreeNode root, double target, boolean reverse, Stack<Integer>s){
        if(root == null) return;
        inorder(reverse?root.right:root.left,target,reverse,s);
        if(reverse && root.val <= target || !reverse && root.val > target ) return;
        s.push(root.val);
        inorder(reverse?root.left:root.right,target,reverse,s);
    }
}
