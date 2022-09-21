public class MaxHeap {
    /**
     * Default constructor to build empty max heap
     */
    private int heapsize = 0;
    private int key = 0;

    public MaxHeap () {
        this(20);
    }

    /**
     * Overloaded constructor to build the heap
     * @param size: the size of the heap
     */
    public MaxHeap (int n, Task[] A) {
        buildMaxHeap(n, A);
    }

    /**
     * Builds a max heap out of an unsorted array
     * @param n: the size of the heap
     */
    public void buildMaxHeap(int n, Task[] A) {
        // A[1:n] is an unsorted array
        // 1. A.heap-size = n
        // 2. for i = n/2 downto 1 // skip the leaves
        // 3. do MAX-HEAPIFY(A, i)
        // Task [] A = new Task[n];
        for (int i = n/2; i > 0; i--) {
            heapify(A, i);
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

    public void heapify(Task [] A, int i) { // heapification downward
        /*
        Pre-condition: Both the left and right subtrees of node i are max-heaps
        and i is less than or equal to heap-size[A]
        Post-condition: The subtree rooted at node i is a max-heap
        */
        Task b;
        int largest;
        int l = left(i);
        int r = right(i);
        if (l <= heapsize && A[l].getPriority() > A[r].getPriority())
            largest = l;
        else
            largest = i;

        if (r <= heapsize && A[r].getPriority() > A[largest].getPriority())
            largest = r;

        if (largest != i) {
            // exchange A[i] and A[largest]
            b = A[largest];
            A[largest] = A[i];
            A[i] = b;
            heapify(A, largest);
        }
    }

    public Task max(Task[] A) {
        if (heapsize < 1) {
            System.out.println("heap underflow");
            return null;
        } else {
            return A[1];
        }
    }

    public Task extractMax(Task[] A) {
        Task m = max(A);
        A[1] = A[heapsize];
        heapsize = heapsize - 1; 
        heapify(A, 1);
        return m;
    }

    public void insert(Task[] A, int n, Task x) {
        double negInf = Double.NEGATIVE_INFINITY;
        if (heapsize == n) {
            System.out.println("error: heap overflow");
        }
        heapsize += 1;
        int k = x.getKey();
        x.setKey((int)negInf);  
        A[heapsize] = x;
        

    }

    public void increaseKey(int i, Task K) {

    }

    public boolean isEmpty() {
        return false;
    }

    public int getHeapSize() {
        return heapsize;
    }

    public void setHeapSize(int heapSize) {
        this.heapsize = heapSize;
    }

}

