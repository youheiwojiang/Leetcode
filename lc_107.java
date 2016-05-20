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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>>res = new ArrayList<>();
        Queue<TreeNode>q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i = 0; i< size ;i++){
                TreeNode tmp = q.poll();
                list.add(tmp.val);
                if(tmp.left!=null) q.add(tmp.left);
                if(tmp.right!= null) q.add(tmp.right);
            }
            res.add(0,list);
        }
        return res;
    }
}
