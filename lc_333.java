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
    private int largest = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return largest;
    }
    private int[] helper(TreeNode root){
        //size 3 array 1 bit shows the number of nodes 2 bit is the rightmost 3 bit is the leftmost
        int res[] = new int[3];
        if(root == null) return res;
        int []leftres = helper(root.left);
        int []rightres = helper(root.right);
        if((leftres[0] == 0 || (leftres[0] > 0 && leftres[2] <= root.val)) && (rightres[0] == 0 || (rightres[0] > 0 && rightres[1] >= root.val)) ){
            res[0] = 1 + leftres[0]+ rightres[0];
            largest = Math.max(res[0],largest);
            int leftbound = leftres[0] == 0?root.val:leftres[1];
            int rightbound = rightres[0] ==0?root.val:rightres[2];
            res[1] = leftbound;
            res[2] = rightbound;
        }else
            res[0] = -1;
        return res;
        
    }
}
