
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)
            return null;
        // notice how to use anonymous class
        PriorityQueue<ListNode>queue = new PriorityQueue<>(new Comparator<ListNode>(){
          public int compare(ListNode A, ListNode B){
               return A.val - B.val;
           }  
        });
        ListNode start = new ListNode(0);
        ListNode cur = start;
        for(ListNode node : lists){
            // this is just for the null node in the k nodes
            if(node == null)
                continue;
            queue.add(node);
        }while(!queue.isEmpty()){
            ListNode tmp = queue.poll();
            cur.next = tmp;
            cur  = cur.next;
            if(tmp.next != null)
                queue.add(tmp.next);
        }
        return start.next;   
    }
}



/////////////////////////////////////////////////////////////
//use a named class to implement the Comparable interface(still need to think why we can't write mycomp<ListNode>)?
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public  class mycomp implements Comparator<ListNode>{
        public int compare(ListNode A, ListNode B){
               return A.val - B.val;
           }  
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)
            return null;
        // notice how to use anonymous class
         PriorityQueue<ListNode>queue = new PriorityQueue<>(new mycomp());
        /*
        PriorityQueue<ListNode>queue = new PriorityQueue<>(new Comparator<ListNode>(){
          public int compare(ListNode A, ListNode B){
               return A.val - B.val;
           }  
        });
        */
        ListNode start = new ListNode(0);
        ListNode cur = start;
        for(ListNode node : lists){
            // this is just for the null node in the k nodes
            if(node == null)
                continue;
            queue.add(node);
        }while(!queue.isEmpty()){
            ListNode tmp = queue.poll();
            cur.next = tmp;
            cur  = cur.next;
            if(tmp.next != null)
                queue.add(tmp.next);
        }
        return start.next;   
    }
}
