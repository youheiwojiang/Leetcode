
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode fast = null;// save the start of next reverse
    ListNode slow = null;// save the last of cur reverse
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            cur = cur.next;
            len++;
        }
        if(len < k || head == null || k < 2 )
            return head;
        ListNode newhead = reverse(head,k);
        for(int i = 1; i< len/k;i++){
            cur = slow;
            head = reverse(fast,k);
            cur.next = head;
        }
        if(fast!=null)
            slow.next = fast;
        return newhead;
    }
    public ListNode reverse(ListNode head , int k){
        slow = head;
        ListNode fake = new ListNode(0);
        ListNode nextnode = null;
        for(int i = 0 ;i<k;i++){
            nextnode = head.next;
            head.next = fake.next;
            fake.next = head;
            head = nextnode;
        }
        fast = nextnode;
        return fake.next;
    }
}
