public class MaxHeap {
    /**
     * Default constructor to build empty max heap 
     */
    //TODO write compare to method.
    public void buildMaxHeap() {
        // A[1:n] is an unsorted array
        // 1. A.heap-size = n
        // 2. for i = n/2 downto 1 // skip the leaves
        // 3. do MAX-HEAPIFY(A, i)
        int n = 20;
        Task [] A = new Task[n];
        for (int i = n/2; i > 0; i--) {
            heapify(A, i);
        }
    }

    /**
     * Overloaded constructor to build array out of provided array
     */
    public void buildMaxHeap(int [] array) {
        // A[1:n] is an unsorted array
        // 1. A.heap-size = n
        // 2. for i = n/2 downto 1 // skip the leaves
        // 3. do MAX-HEAPIFY(A, i)
        Task [] A = new Task[n];
        for (int i = n/2; i > 0; i--) {
            heapify(A, i);
        }
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
        if (l <= A.length && A[l].getPriority() > A[r].getPriority())
            largest = l;
        else
            largest = i;

        if (r <= A.length && A[r].getPriority() > A[largest].getPriority())
            largest = r;

        if (largest != i) {
            // exchange A[i] with A[largest];
            // heapify(A, largest);
//            private void exchange(int x, int y) {
//                int b = y;
//                y = x;
//                x = b;
//                exchange(A[i], A[largest]);
//            }
            // exchange A[i] and A[largest]
            b = A[largest];
            A[largest] = A[i];
            A[i] = b;
            heapify(A, largest);
        }
    }

    public Task max() {
        return null;
    }

    public Task extractMax() {
        return null;
    }

    public void insert(Task t) {

    }

    public void increaseKey(int i,  Task K) {

    }

    public boolean isEmpty() {
        return false;
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

}
