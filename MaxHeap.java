import java.util.Arrays;

/* start at index one. you used the
   pseudocode straight from the book.
   so you have to use index 0 as dummy 
   index.
*/ 

public class MaxHeap {
    private int heapSize = 0;
    // private int key = 0;
    private Task [] heapArray;

    /**
     * Default constructor to build empty max heap
     */
    public MaxHeap () {
        heapArray = new Task[30];
        heapSize = 0;
    }

    /**
     * Overloaded constructor to build the heap
     * @param n: the size of the heap
     */
    public MaxHeap (int n) {
        heapSize = n;
        heapArray = new Task[n];
        buildMaxHeap(n);
    }

    /**
     * Overloaded constructor to build the heap
     * @param n: user's heap array
     * @param n: the heap array's size 
     */
    public MaxHeap (Task [] A, int n) {
        heapSize = n;
        heapArray = A;
        buildMaxHeap(n);
    }

    /**
     * Builds a max heap out of an unsorted array
     * @param n: the size of the heap
     */
    public void buildMaxHeap(int n) {
        // heapArray[1:n] is an unsorted array
        // 1. heapArray.heap-size = n
        // 2. for i = n/2 downto 1 // skip the leaves
        // 3. do MAX-HEAPIFY(heapArray, i)
        // Task [] heapArray = new Task[n];
        for (int i = n/2; i > 0; i--) {
            heapify(i);
        }
    }

    // Get the parent node using index
    /**
     * Get the parent node using index
     * @param n: the index of the child
     * @return the index of the parent node 
     */
    private int parent(int i) {
        return i / 2; // integer division
    }

    /**
     * Get the right node using index
     * @param n: the index of the parent node
     * @return the index of the right child node 
     */
    private int right(int i) {
        return 2 * i + 1;
    }

    /**
     * Get the left node using index
     * @param n: the index of the parent node
     * @return the index of the left child node 
     */
    private int left(int i) {
        return 2 * i;
    }

    /**
     * TODO Write description for heapify
     * @param n: the index of the parent node
     * @return the index of the left child node 
     */
    public void heapify(int i) { // heapification downward
        /*
        Pre-condition: Both the left and right subtrees of node i are max-heaps
        and i is less than or equal to heap-size[A]
        Post-condition: The subtree rooted at node i is a max-heap
        */
        // Task b;
        int largest;
        int l = left(i);
        int r = right(i);
        if (l <= heapSize && heapArray[l].getPriority() > heapArray[r].getPriority())
            largest = l;
        else
            largest = i;

        if (r <= heapSize && heapArray[r].getPriority() > heapArray[largest].getPriority())
            largest = r;

        if (largest != i) {
            // exchange heapArray[i] and heapArray[largest]
            exchangeTasks(largest, i);
            heapify(largest);
        }
    }

    /**
     * Get the top node of the max heap
     * @return the the top node of the max heap
     */

    public Task max() {
        if (heapSize < 1) {
            System.out.println("heap underflow");
            return null;
        } else {
            return heapArray[1];
        }
    }

    /**
     * Remove the top node from the max heap and return it
     * @return the the top node of the max heap
     */
    public Task extractMax() {
        Task m = max();
        heapArray[1] = heapArray[heapSize];
        heapSize = heapSize - 1; 
        heapify(1);
        return m;
    }

    //TODO find out why insert has int n as a parameter
    /**
     * Insert a Task into the heap.
     * @param Task x is the Task to insert into the heap
     * @param is the position to insert into the heap 
     */
    public void insert(Task x, int n) {
        //check if the heapsize is equal to array size
        if (heapSize == heapArray.length) {
            heapArray = Arrays.copyOf(heapArray, heapArray.length);
        }

        double negInf = Double.NEGATIVE_INFINITY;
        if (heapSize == n) {
            System.out.println("error: heap overflow");
        }
        heapSize += 1;
        int k = x.getKey();
        x.setKey((int)negInf);  
        heapArray[heapSize] = x;
        // TODO map x to index heap-size in the array
        increaseKey(x, n);
    }

    /**
     * Increase the key of the heap
     * @param Task x is the Task to insert into the heap
     * @param int k is the new key. 
     */
    public void increaseKey(Task x, int k) {
        int i; 
        if (k < x.getKey()) {
            System.out.println("new key is smaller than current key");
        }
        x.setKey(k);
        //find the index i in array heapArray where object x occurs
        i = getIndex(x);
        while (i > 1 && heapArray[parent(i)].getKey() < heapArray[i].getKey()){
            // exchange heapArray[i] with heapArray[Parent(i)], updating the information that maps
            exchangeTasks(i, parent(i));
            // priority queue objects to array indices
        }
    }

    /**
     * Find out if heap is full or empty
     * @return boolean false if full 
     * @return boolean true if empty
     */
    public boolean isEmpty() {
        if (heapArray == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Switches two elements in array. The user inputs the
     * indexes of the two arrays.
     * @param int x is the index of the first element
     * @param int y is the index of the second element
     */
    public void exchangeTasks(int x, int y) {
        Task b;
        b = heapArray[y];
        heapArray[y] = heapArray[x];
        heapArray[x] = b;
    }

    /**
     * Getter for heapSize
     * @return heapSize Value
     */
    public int getHeapSize() {
        return heapSize;
    }

    /**
     * Setter for heapSize
     * @param heapSize new Value
     */
    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    /**
     * Getter for heapArray
     * @return heapArray;
     */
    public Task [] getHeapArray() {
        return heapArray;
    }

    /**
     * set an array to be the heapArray
     * @param heapArray
     */
    public void setHeapArray(Task[] heapArray) {
        this.heapArray = heapArray;
    }

    /**
     * Get the index of an object in the heap Array
     * @param t
     * @return i
     */
    public int getIndex(Task t) {
        for (int i = 0; i < heapArray.length; i++) {
            if (t.equals(heapArray[i])) {
                return i;
            }
        }
        System.out.println("Error Task is not found");
        return heapArray.length; // will throw error because out of range
    } 
}