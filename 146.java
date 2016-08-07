// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
//
// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
class ListNode{
  ListNode prev, next;
  int key;
  int value;
  public ListNode(int key, int value){
    this.key = key; this.value = value; prev = null; next = null;
  }
}
class DoubleList{
  ListNode head = null;
  ListNode tail = null;
  public void addFirst(ListNode node){
    if (head == null || tail == null){
      head = node; tail = node;
    }
    else {
      node.next = head; head.prev = node; head = node;
    }
  }
  public void removeLast(ListNode node){
    ListNode prev = node.prev;
    ListNode next = node.next;
  }
  public void moveToFirst(ListNode node){

  }
}

public class LRUCache {
    private int capacity;
    Map<Integer, ListNode> map;
    public LRUCache(int capacity) {
      this.capacity = capacity;
      map = new HashMap<>();
    }

    public int get(int key) {

    }

    public void set(int key, int value) {

    }
}
