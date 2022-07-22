/*
 *  LRU Cache
Medium

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

 

Constraints:

    1 <= capacity <= 3000
    0 <= key <= 104
    0 <= value <= 105
    At most 2 * 105 calls will be made to get and put.

Accepted
1,123,987
Submissions
2,788,664
 */

import java.util.*;
public class LRUCache
{
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    private void insert(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        headNext.prev = node;
        node.prev = head;
    }
    
    private void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            int v = cache.get(key).value;
            delete(cache.get(key));
            cache.remove(key);
            Node nn = new Node(key, v);
            insert(nn);
            cache.put(key, nn);
            return v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node nn = new Node(key, value);
        if(cache.containsKey(key)){
            delete(cache.get(key));
            cache.remove(key);
        }
        else if(cache.size()==capacity){
            int k = tail.prev.key;
            delete(tail.prev);
            cache.remove(k);
        }
        insert(nn);
        cache.put(key, nn);
        // System.out.println("Key : " + nn.key + " Value : " + nn.value);
    }
    
    class Node {
        int key, value;
        Node next, prev;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String args[])
    {
        LRUCache obj = new LRUCache(2);
        obj.put(2,1);
        obj.put(1,1);
        obj.put(2,3);
        obj.put(4,5);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
    }    
}
