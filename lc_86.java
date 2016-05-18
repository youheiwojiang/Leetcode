/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        ListNode dum1 = new ListNode(0);
        ListNode dum2 = new ListNode(0);
        ListNode p1 = dum1,p2 = dum2;
        //ListNode cur = head;
        while(head!=null){
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else{
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;//need attention
        p1.next = dum2.next;
        return dum1.next;
        
    }
}
