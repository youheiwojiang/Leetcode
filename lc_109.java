/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return build(head,tail);
    }
    private TreeNode build(ListNode head, ListNode tail ){
        if(head == null || tail == null)
            return null;
        if(head == tail)
            return new TreeNode(head.val); // key part : otherwise can't handle 1 element list
        ListNode slow = head,fast = head,prev = null;
        while(fast!=null && fast.next != null  && fast!= tail  && fast.next != tail){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head,prev);
        root.right = build(slow.next,tail);
        return root;
    }
}
/// other genius code:
public class Solution {
public TreeNode sortedListToBST(ListNode head) {
    if(head==null) return null;
    return toBST(head,null);
}
public TreeNode toBST(ListNode head, ListNode tail){
    ListNode slow = head;
    ListNode fast = head;
    if(head==tail) return null;

    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }
    TreeNode thead = new TreeNode(slow.val);
    thead.left = toBST(head,slow);
    thead.right = toBST(slow.next,tail);
    return thead;
}
