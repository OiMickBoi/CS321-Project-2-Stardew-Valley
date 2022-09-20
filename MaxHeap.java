public class MaxHeap {
    /**
     * Default constructor to build empty max heap 
     */
    public void buildMaxHeap() {
        //A[1:n] is an unsorted array
//        1. A.heap-size = n
//        2. for i = n/2 downto 1 //skip the leaves
//        3. do MAX-HEAPIFY(A, i)
    }

    /**
     * Overloaded constructor to build array out of provided array
     */
    public void buildMaxHeap(int [] array) {
    }

    public void heapify() {
    }

    public void max() {
    }

    public void extractMax() {
    }

    public void insert() {
    }

    public void isEmpty() {
    }

    // Get the parent node using index
    private int parent(int i) {
        return i / 2; // integer division
    }

    // Get the right node using index
    private int right(int i) {
        return 2 * i;
    }

    // Get the left node using index
    private int left(int i) {
        return 2 * i + 1;
    }

    // TODO find array type
    private void maxHeapify(Task.TaskType [] A, int i) { // heapification downward
        /*
        Pre-condition: Both the left and right subtrees of node i are max-heaps
        and i is less than or equal to heap-size[A]
        Post-condition: The subtree rooted at node i is a max-heap
        */
        int l = left(i);
        int r = right(i);
        if (l <= A.length && A[l].> A )
            int largest = l;
        else
            largest = i;

        if (r <= A.heap-size && A[r] > A[largest])
            largest = r;

        if (largest != i){
            exchange A[i] with A[largest];
            maxHeapify(A, largest);
        }
    }
}
