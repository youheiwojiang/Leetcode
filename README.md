#Solutions for Leetcode

Some tips in the java programming:
  
-----------------------------------------------------------------------------------

    Trapping water problems(only considering the shorter end of the wall)	
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
  
  __________________________________________________________________________________
  About Binary Search:
  
  + two common terminate condition
  	- while ( l < r ) 
  	    - the following is focus on the find first satisfying problem
  		- not handling the 1 length array need detect A[l] == target
  		- return the mid or l or r;
  		- can use l = mid + 1 and r = mid(won't cause TLE)
  	- while ( l <= r)
  		- used to find the first element satisfying some f(i)
  		- always use l = mid + 1, r = mid -1 (otherwise cause TLE)
  		- if you wanna first element satisfying some f(), you need to return l,and determine whether it's out of index 
  		
  		
 ```
 vector<int> searchRange(int A[], int n, int target) {
    int i = 0, j = n - 1;
    vector<int> ret(2, -1);
    // Search for the left one
    while (i < j)
    {
        int mid = (i + j) /2;
        if (A[mid] < target) i = mid + 1;
        else j = mid;
    }
    if (A[i]!=target) return ret;
    else ret[0] = i;

    // Search for the right one
    j = n-1;  // We don't have to set i to 0 the second time.
    while (i < j)
    {
        int mid = (i + j) /2 + 1;   // Make mid biased to the right
        if (A[mid] > target) j = mid - 1;  
        else i = mid;            // So that this won't make the search range stuck.
    }
    ret[1] = j;
    return ret; 
}
 
 ```