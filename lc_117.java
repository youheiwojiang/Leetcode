/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode head = root; // labe the first on the next layer
        TreeLinkNode prev = null; 
        TreeLinkNode cur = null;
        while(head!=null){
            prev = null;
            cur = head;
            head = null;
            while(cur != null){ // attention the flow
                if(head == null && (cur.left != null || cur.right != null)){head = (cur.left!=null?cur.left:cur.right);}
                if(cur.left != null && cur.right != null) {
                    cur.left.next = cur.right;
                    if(prev != null) prev.next = cur.left;
                    prev = cur.right;
                    cur = cur.next;
                }
                else if(cur.left != null || cur.right != null) {
                    if(prev != null)
                        prev.next = (cur.right == null?cur.left:cur.right);
                    prev = (cur.right == null?cur.left:cur.right);
                    cur = cur.next;
                }
                else {
                    while(cur != null && cur.left == null && cur.right == null) 
                    cur = cur.next;
                }
            }
        }
        return;
    }
}
