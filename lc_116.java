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
        TreeLinkNode head = root;
        TreeLinkNode prev = null;
       // TreeLinkNode next = null;
        while(head.left!= null){
            prev = head;
           // next = prev.next;
            while(prev != null){
                prev.left.next = prev.right;
                if(prev.next!=null)
                     prev.right.next = prev.next.left;
                prev = prev.next;
            }
            /* can be improved
            while(next != null){
                prev.right.next = next.left;
                prev.left.next = prev.right;
                next = next.next;
                prev = prev.next;
            }
            prev.left.next = prev.right;//handle the last prev
            */
            head = head.left;
            
        }
    }
}
