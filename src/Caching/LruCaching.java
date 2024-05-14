package Caching;
import java.util.HashMap;

public class LruCaching {
    HashMap<Integer, CacheNode> map;
    int capacity;

    public LruCaching(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public void put(int key, int value) {
        CacheNode node = map.get(key);
        if (map.containsKey(key)) {
            removeKey(node);
        } else if(map.size() == capacity) {
            removeKey(tail);
        } else { // if no mapFull && no isKeyAlreadyExist && isEmpty
            CacheNode newNode = new CacheNode(key, value); // new Node Creation
            insertkey(newNode);
            tail = newNode;
        }
    }

    public int get(int key) {
        CacheNode getNode = map.get(key);

        if (getNode == null) {return -1;}

        removeKey(getNode);
        insertkey(getNode);
        return getNode.value;
    }

    CacheNode dummyHead = new CacheNode(0, 0);
    CacheNode dummyTail = new CacheNode(0, 0);
    CacheNode tail = null;

    void insertkey(CacheNode insertNode) {
        map.put(insertNode.key, insertNode);
        if(dummyHead.next == null || dummyTail.prev == null) {
            dummyHead.next = insertNode;
            insertNode.prev = dummyHead;
            insertNode.next = dummyTail;
            dummyTail.prev = insertNode;
        } else {  // id head and tail not null
            insertNode.prev = dummyHead;
            insertNode.next = dummyHead.next;
            dummyHead.next.prev = insertNode;
            dummyHead.next = insertNode;
        }
    }

    void removeKey(CacheNode removeNode) {
        map.remove(removeNode.key);
        if(removeNode.next != null || removeNode.prev != null) {
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
            removeNode.next = removeNode.prev = null;
        }
    }

}
