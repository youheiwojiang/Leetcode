public class LRUCache {
    // doubly linked list and a hash 
    class DLinkedNode{
        public int key;//missing
        public int value;
        public DLinkedNode pre;
        public DLinkedNode next;
    }
    // with fake head and fake end;
    private void movetohead(DLinkedNode node){
        this.removenode(node);
        this.addnode(node);
    }
    private void addnode(DLinkedNode node){
       node.next= head.next;
       head.next.pre = node;
       head.next = node;
       node.pre = head;
    }
    private void removenode(DLinkedNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        return;   
    }
    private void removetail(){
        this.removenode(tail.pre);
    }
    
    public DLinkedNode head = null, tail = null;
    int count;
    int size;
    Map<Integer,DLinkedNode>map;
    
    public LRUCache(int capacity) {
        map = new HashMap<Integer,DLinkedNode>();
        size = capacity;
        head = new DLinkedNode();
        head.pre = null;
        tail = new DLinkedNode();
        tail.next = null;
        head.next = tail;
        tail.pre = head;
        count = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            this.movetohead(map.get(key));
            return map.get(key).value;
        }
        
    }
    
    public void set(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null){
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            map.put(key,node);
            this.addnode(node);
            count++;
            if(count > size){
                DLinkedNode rm= tail.pre;
                this.removetail();
                map.remove(rm.key);
                count--;
            }
        }else{
            node.value = value;
            this.movetohead(node);
            
        }
    }
}
