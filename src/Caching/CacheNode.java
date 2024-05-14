package Caching;

public class CacheNode {
    int key, value;
    CacheNode next, prev;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
