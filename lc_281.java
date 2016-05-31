public class ZigzagIterator {
    //use a list to finish k 
    Iterator<Integer>i1;
    Iterator<Integer>i2;
    boolean first = true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v1.iterator();
        i2 = v2.iterator();
    }

    public int next() {
        if(i1.hasNext() && i2.hasNext()){
            if(first){int tmp = i1.next();first = false;return tmp;}
            else{int tmp = i2.next();first = true;return tmp;}
        }else
            return i1.hasNext()?i1.next():i2.next();
    }

    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
