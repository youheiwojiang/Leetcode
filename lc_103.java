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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        int layer = 0;
        while(!q.isEmpty()){
            int size = q.size();
            layer++;
            List<Integer>list = new ArrayList<>();
            for(int i = 0; i< size ;i++){
                TreeNode tmp = q.poll();
                if(layer %2 == 0) // key part
                    list.add(0,tmp.val);
                else 
                    list.add(tmp.val);
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!= null) q.add(tmp.right);
            }
            res.add(list);
        }
        return res;
    }
}
