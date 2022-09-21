public class MaxHeap {
    private int heapSize = 0;
    private int key = 0;
    private Task [] heapArray;

    /**
     * Default constructor to build empty max heap
     */
    public MaxHeap () {
        // this(20, arrayHeap);
        this(20);
    }

    /**
     * Overloaded constructor to build the heap
     * @param n: size 
     * @param heapArray: heapArrayrray to pass in
     */
    public MaxHeap (int n) {
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
            heapify(heapArray, i);
        }
    }

    // Get the parent node using index
    private int parent(int i) {
        return i / 2; // integer division
    }

    // Get the right node using index
    private int right(int i) {
        return 2 * i + 1;
    }

    // Get the left node using index
    private int left(int i) {
        return 2 * i;
    }

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
//            b = heapArray[largest];
//            heapArray[largest] = heapArray[i];
//            heapArray[i] = b;
            exchangeTasks(heapArray, largest, i);
            heapify(largest);
        }
    }

    public Task max() {
        if (heapSize < 1) {
            System.out.println("heap underflow");
            return null;
        } else {
            return heapArray[1];
        }
    }

    public Task extractMax(Task[] heapArray) {
        Task m = max(heapArray);
        heapArray[1] = heapArray[heapSize];
        heapSize = heapSize - 1; 
        heapify(heapArray, 1);
        return m;
    }

    public void insert(Task[] heapArray, Task x, int n) {
        double negInf = Double.NEGATIVE_INFINITY;
        if (heapSize == n) {
            System.out.println("error: heap overflow");
        }
        heapSize += 1;
        int k = x.getKey();
        x.setKey((int)negInf);  
        heapArray[heapSize] = x;
        // TODO map x to index heap-size in the array
        increaseKey(heapArray, x, n);
    }

    public void increaseKey(Task[] heapArray, Task x, int k) {
        Task b;
        int i; // TODO initialize variable
        if (k < x.getKey()) {
            System.out.println("new key is smaller than current key");
        }
        x.setKey(k);
        //find the index i in array heapArray where object x occurs
        while (i > 1 && heapArray[parent(i)].getKey() < heapArray[i].getKey()){
            // exchange heapArray[i] with heapArray[Parent(i)], updating the information that maps
            // priority queue objects to array indices
//            b = heapArray[largest];
//            heapArray[largest] = heapArray[i];
//            heapArray[i] = b;
            exchangeTasks(heapArray, i, parent(i));
//            heapify(heapArray, largest);
        }
    }

    public boolean isEmpty() {
        return false;
    }

    public void exchangeTasks(Task[] heapArray, int x, int y) {
        Task b;
        b = heapArray[y];
        heapArray[y] = heapArray[x];
        heapArray[x] = b;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public Task [] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(Task[] heapArray) {
        this.heapArray = heapArray;
    }



}