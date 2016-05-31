/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int l = 0,r = n-1;
        while(l < r){
            if(knows(l,r) && knows(r,l) || !knows(l,r) && !knows(r,l))
                {l++;r--;}
            else if(knows(l,r))
                l++;
            else
                r--;
        }
        if(l!=r) return -1;//
        for(int i = 0; i< n; i++){
            if(i == r) continue;
            if(!knows(i,r) || knows(r,i)) return -1;
        }return r;
    }
}

/////////////////////////////////////
//more consice code:
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }
}
