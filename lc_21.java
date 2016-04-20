
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode cur = fake;
        while(l1!= null && l2!= null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next =l1;
                l1 = l1.next;
            }
             cur = cur.next;
        }if(l1 != null)
            cur.next = l1;
         if(l2 != null)
            cur.next = l2;
            
        return fake.next;
    }
}
