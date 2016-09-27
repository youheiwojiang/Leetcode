c class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode l3 = new ListNode(0);
        ListNode cur = l3;
        while(l1 != null || l2 != null || carry != 0){
            int tmp = carry + (l1 == null?0:l1.val) + (l2 == null?0:l2.val);
            cur.next = new ListNode(tmp % 10);
            carry = tmp / 10;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            cur = cur.next;
        }
        
       
        return l3.next;
    }
}
