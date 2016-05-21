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
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return res;
        build(root,sum, new ArrayList<>());
        return res;
    }
    private void build(TreeNode root, int sum , List<Integer>list){
        list.add(root.val);
        if( root.left == null && root.right == null){
            if(root.val == sum) res.add(list);
        }else if(root.left == null){
            build(root.right, sum - root.val, list);
        }else if(root.right == null){
            build(root.left, sum - root.val, list);
        }else{
            List<Integer>tmp = new ArrayList<>(list);
            build(root.left, sum -root.val, list);
            build(root.right, sum -root.val,tmp);
        }
    }
}
