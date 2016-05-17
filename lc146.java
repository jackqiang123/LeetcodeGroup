// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
public class LRUCache {
    class DoubleLinkedListNode{
        int key;
        int val;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        public DoubleLinkedListNode(int key, int value){
          this.key = key;
          this.val = value;
        }
    }

    class DoubleLinkedList{
        private DoubleLinkedListNode head;
        private DoubleLinkedListNode tail;
        private HashMap<Integer, DoubleLinkedListNode> map;
        public DoubleLinkedListNode(){
          head = null;
          tail = null;
          map = new HashMap<Integer, DoubleLinkedListNode>();
        }

        public int get(int key){
          if(map.get(key) == null) return -1;
          DoubleLinkedListNode cur = map.get(key);
          moveToHead(cur);
          return cur.val;
        }

        public int set(int key, int val){
          if (get(key) != -1){
            map.get(key).val = val;
            moveToHead(map.get(key));
          }
          else{
            DoubleLinkedListNode cur = new DoubleLinkedListNode(key, val);
            map.put(key, cur);
            moveToHead(cur);
          }
        }

        public void moveToHead(DoubleLinkedListNode node){
          if (head == node)  return;
          ListNode prevNode = node.prev;
          ListNode nextNode = node.next;
          prevNode.next = nextNode;
          if (node == tail){
            tail = prevNode;
          }
          else{
            nextNode.prev = prevNode;
          }
          node.prev = null;
          node.next = head;
          head = node;
        }

        public void removetail(){
          if (tail == null) return;
          if (head == tail){
            map.remove(tail.val);
            head = null;
            tail = null;
          }
          else{
            map.remove(tail.val);
            Listnode last = tail.prev;
            last.next = null;
            tail = last;
          }
        }

        public int size(){
          return map.size();
        }
    }

    private DoubleLinkedList data;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        data = new DoubleLinkedList();
    }

    public int get(int key) {
      return data.get(key);
    }

    public void set(int key, int value) {
      data.set(key,value);
      while (data.size() > capacity) data.removetail();
    }
}
