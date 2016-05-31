// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    int peek = 0 ;
    Iterator<Integer>ite;
    boolean peeked = false;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        ite = iterator;
        peeked = true;
        peek = ite.next();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      
       return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
           int tmp = peek;
           peeked = ite.hasNext();
           if(peeked) peek = ite.next();
           return tmp;
    }

    @Override
    public boolean hasNext() {
        return peeked;
    }
}
