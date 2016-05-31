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
    public int closestValue(TreeNode root, double target) {
        double val = (double)root.val;
        if(val == target || val > target && root.left == null || val < target && root.right == null) return root.val;
        else if(val > target){
            int left = closestValue(root.left,target);
            if(Math.abs(target - root.val) > Math.abs(target - left)) return left;
            return root.val;
        }
        else
            {
            int right = closestValue(root.right,target);
            if(Math.abs(target - root.val) > Math.abs(target - right)) return right;
            return root.val;
        }
    }
}
