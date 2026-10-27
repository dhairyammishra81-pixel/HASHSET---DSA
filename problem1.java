class problem1 {
    private static final int BUCKETS = 7919; // A prime number minimizes hash collisions
    private Node[] table;

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public problem1() {
        table = new Node[BUCKETS];
    }
    
    private int hash(int key) {
        return key % BUCKETS;
    }

    public void add(int key) {
        int idx = hash(key);
        Node current = table[idx];
        
        while (current != null) {
            if (current.key == key) {
                return; // Key already exists, do nothing
            }
            current = current.next;
        }
        
        // Insert new node at the head of the bucket
        Node newNode = new Node(key);
        newNode.next = table[idx];
        table[idx] = newNode;
    }

    public void remove(int key) {
        int idx = hash(key);
        Node current = table[idx];
        Node prev = null;
        
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[idx] = current.next; // Remove head node
                } else {
                    prev.next = current.next; // Remove middle/tail node
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Node current = table[idx];
        
        while (current != null) {
            if (current.key == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
