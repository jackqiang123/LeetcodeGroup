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
        public DoubleLinkedList(){
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

        public void set(int key, int val){
          if (get(key) != -1){
            map.get(key).val = val;
            moveToHead(map.get(key));
          }
          else{// create a new node
            DoubleLinkedListNode cur = new DoubleLinkedListNode(key, val);
            map.put(key, cur);
            if (head == null){// if the current list is empty, put it there by marking head
              head = cur; tail = cur;
            }
            else { // if not, put it at the head.
              head.prev = cur;
              cur.next = head;
              head = cur;
            }
          }
        }

        public void moveToHead(DoubleLinkedListNode node){// a newly visit node
          if (head == node)  return; // if this node is already head do nothing.
          if (tail == node) { // there are at least two nodes, while node is tail
                DoubleLinkedListNode prevNode = node.prev;
                tail = prevNode;
                prevNode.next = null;
                node.prev = null;
                head.prev = node;
                node.next = head;
                head = node;
                return;
          }
          // if node is not head or tail
          DoubleLinkedListNode prevNode = node.prev;
          DoubleLinkedListNode nextNode = node.next;
          prevNode.next = nextNode;
          nextNode.prev = prevNode;
          head.prev = node;
          node.next = head;
          head = node;
        }

        public void removetail(){
          if (tail == null) return;
          if (head == tail){
            map.remove(tail.key);
            head = null;
            tail = null;
          }
          else{// tail is differnet from head
            map.remove(tail.key);
            DoubleLinkedListNode last = tail.prev;
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
