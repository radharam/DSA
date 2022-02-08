package src.main.java.interviewbit.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 *
 * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
 *
 * NOTE: If you are using any global variables, make sure to clear them in the constructor.
 *
 * Example :
 *
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 */
public class LRUCache {

    class Node {
        int value;
        Node next, prev;

        Node() {
            super();
        }

        Node(int val) {
            this();
            this.value = val;
        }
    }

    Map<Integer, Node> mapNodes = new HashMap<>();
    Node head, tail;
    int size, capacity;

    public LRUCache(){
        super();
    }

    public LRUCache(int capacity) {
        this();

        // initialize
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.size = 0; this.capacity = capacity;
    }

    public int get(int key) {
        return mapNodes.get(key).value;
    }

    public void set(int key, int value) {
        // HIT SCENARIO
        if(mapNodes.containsKey(key)) {
            Node node = mapNodes.get(key);
            node.value = value;
            remove(node);
            addToTail(node);

            // MISS SCENARIO
        } else {
            if(size == capacity) { // if capacity is full, remove from LRU and add new node at end
                mapNodes.remove(head.next.value); // remove first node from map and LL
                remove(head.next);
                Node node = new Node(value); // create new node n add to tail
                node.value = value;
                addToTail(node);
            } else { // if capacity is not full, add new node at end
                Node node = new Node(value); // create new node n add to tail
                node.value = value;
                mapNodes.put(key, node);
                addToTail(node);
            }
        }
    }

    public void remove(Node node) { // remove node, connection prev n next node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToTail(Node node) { // add to end, before tail, add prev to tail
        node.next = tail;
        node.prev = tail.prev;

        if(tail.prev != null) {
            tail.prev.next = node;
        }
        tail.prev = node;
    }
}

/*class Node {
    int value;
    Node next, prev;

    Node() {
        super();
    }

    Node(int val) {
        this();
        this.value = val;
    }
} */

