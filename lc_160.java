/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 1, lenB = 1;
        ListNode p1 = headA,p2 = headB;
        while(p1.next != null){ p1 = p1.next;lenA++;}
        while(p2.next != null){p2 = p2.next; lenB++;}
        if(p1 != p2) return null;
        if(lenA < lenB){
            for(int i = 0; i< lenB- lenA;i++)
                headB = headB.next;
        }else{
            for(int i = 0; i< lenA- lenB;i++)
                headA = headA.next;
        }
        
        while(headA!= null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null; //keypart
    }
}
