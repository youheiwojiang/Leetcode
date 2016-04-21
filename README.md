#Solutions for Leetcode

Some tips in the java programming:
  
-----------------------------------------------------------------------------------	


  PriorityQueue in java: if the element is your own object not primitive you should give an comparator to do this
  
  + both are generics:<Object>
  + can use both anonymous or explicit implementation to the comparator interface
  + override the compare method
  	- return a int number of two object
  	- compare(A,B) < 0 means A comes before B, so if you want a min heap just make the corresponding key to do minus 
  + usage of anonymous class for comparator:
  	
  	```
  	 PriorityQueue<ListNode>queue = new PriorityQueue<>(new Comparator<ListNode>(){
          public int compare(ListNode A, ListNode B){
               return A.val - B.val;
           }  
        });
  	
  	```
 -----------------------------------------------------------------------------------	
  	
  Bit shift :
  always remember << >> >>> your target is on the left,
  
  a<<b means a*2^b
  
  a<<1 means a*2