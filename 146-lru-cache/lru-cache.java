// class Node{
//     int key;
//     int val;
//     Node prev;
//     Node next;

//     public Node(int key, int val){
//         this.key=key;
//         this.val =val;
//         this.prev = null;
//         this.next = null;
//     }
// }

// class LRUCache {

//     private int cap;
//     private Map<Integer,Node> cache;
//     private Node oldest;
//     private Node latest;

//     public LRUCache(int capacity) {
//         this.cap =capacity;
//         this.cache = new HashMap<>();
//         this.oldest = new Node(0,0);
//         this.latest = new Node(0,0);
//         this.oldest.next = this.latest;
//         this.latest.prev =this.oldest;
        
//     }
    
//     public int get(int key) {

//         if(cache.containsKey(key)){
//             Node node = cache.get(key);
//             remove(node);
//             insert(node);
//             return node.val;
//         }
//         return -1;       
//     }

//     private void remove (Node node){
//         Node prev = node.prev;
//         Node next = node.next;
//         prev.next = next;
//         next.prev = prev;
//     }

//     private void insert (Node node){
//         Node prev = latest.prev;
//         Node next = latest;
//         prev.next = next.prev = node;
//         node.next = next;
//         node.prev = prev; 
//     }
    
//     public void put(int key, int value) {
//         if(cache.containsKey(key)){
//             remove(cache.get(key));

//         }
//         Node newNode = new Node(key,value);
//         cache.put(key,newNode);
//             insert(newNode);

//             if(cache.size()>cap){
//                 Node lru = oldest.next;
//                 remove(lru);
//                 cache.remove(lru.key);
            
//         }
        
//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */





class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    public Node[] map; //store each node
    public int count, capacity;
    public Node head, tail; //store the order of recently used node
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.map = new Node[10000+1]; //0 <= key <= 10000

        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    //Deleting the node in LRU cache
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //Adding the node at the head of LRU cache
    private void addToHead(Node node) {
        node.next = this.head.next;
        node.prev = this.head;

        node.next.prev = node;
        this.head.next = node;
    }
    
    public int get(int key) {
        //Check if node is present in LRU cache
        if(map[key] != null) {
            Node node = map[key];
            deleteNode(node); //Delete the node in LRU cache
            addToHead(node); //Then add it at the head and make it as the most recently used node
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        //Check if node is present in LRU cache
        if(map[key] != null) {
            //If exist, replace the value and make the node as the most recently used node
            Node node = map[key];
            node.value = value; //Replace with the new value
            //Make the node as the most recently used node
            deleteNode(node);
            addToHead(node);
        } else {
            //Create a new node
            Node node = new Node(key, value);
            map[key] = node;

            //Check if space is available
            if(count < capacity) {
                //Add it directly
                count++;
                addToHead(node);
            } else {
                //Delete the least recently used node
                Node least = tail.prev;
                map[least.key] = null;
                deleteNode(least);
                //Make the curr node be the most recently used node
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */