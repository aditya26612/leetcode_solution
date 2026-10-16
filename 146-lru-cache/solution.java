// 13 ms | 58.1 MB
import java.util.HashMap;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>(capacity);

        // Dummy nodes
        head = new Node();
        tail = new Node();

        // Empty list
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        // Key doesn't exist
        if (!map.containsKey(key)) {
            return -1;
        }

        // Get the actual Node
        Node node = map.get(key);

        // This node was just used,
        // so make it most recently used
        remove(node);
        insertAtFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        // --------------------------------
        // CASE 1: Key already exists
        // --------------------------------
        if (map.containsKey(key)) {

            Node node = map.get(key);

            // Update value
            node.value = value;

            // Make it most recently used
            remove(node);
            insertAtFirst(node);

            return;
        }

        // --------------------------------
        // CASE 2: New key + cache is full
        // --------------------------------
        if (map.size() == capacity) {

            // Least recently used node
            Node lru = tail.prev;

            // Remove from HashMap
            map.remove(lru.key);

            // Remove from linked list
            remove(lru);
        }

        // --------------------------------
        // CASE 3: Create new Node
        // --------------------------------
        Node node = new Node();

        node.key = key;
        node.value = value;

        // New node becomes most recently used
        insertAtFirst(node);

        // Store key -> Node
        map.put(key, node);
    }

    // Remove node from current position
    void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }

    // Insert node immediately after head
    void insertAtFirst(Node node) {

        Node first = head.next;

        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }
}