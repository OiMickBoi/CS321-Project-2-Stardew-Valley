import java.util.Arrays;

/* start at index one. you used the
   pseudocode straight from the book.
   so you have to use index 0 as dummy 
   index.
*/

public class MaxHeap {
	private int heapSize;
	private Task[] heapArray;

	/**
	 * Default constructor to build empty max heap.
	 */
	public MaxHeap() { // tested
		heapArray = new Task[30];
		heapSize = 0;
	}

	/**
	 * Overloaded constructor to build the heap.
	 * 
	 * @param n - the size of the heap
	 */
	public MaxHeap(int n) { // tested
		heapSize = 0;
		heapArray = new Task[n + 1];
	}

	/**
	 * Overloaded constructor to build the heap
	 * 
	 * @param A - user's heap array
	 * @param n - the heap array's size
	 */
	public MaxHeap(Task[] A) { // tested
		heapSize = 0;
		heapArray = A;
	}

	/**
	 * Overloaded constructor to build the heap
	 * 
	 * @param A - user's heap array
	 */
	public MaxHeap(Task[] A, int n) { // not tested
		heapSize = 0;
		heapArray = A;
	}

	/**
	 * Builds a max heap out of an unsorted array
	 * 
	 * @param n - the size of the heap
	 */
	public void buildMaxHeap() { // tested
		// heapArray[1:n] is an unsorted array
		// 1. heapArray.heap-size = n
		// 2. for i = n/2 downto 1 // skip the leaves
		// 3. do MAX-HEAPIFY(heapArray, i)
		// Task [] heapArray = new Task[n];
		for (int i = heapSize / 2; i > 0; i--) {
			heapify(i);
		}
	}

	// Get the parent node using index
	/**
	 * Get the parent node using index
	 * 
	 * @param i - the index of the child
	 * @return the index of the parent node
	 */
	public int parent(int i) { // tested
		return i / 2; // integer division
	}

	/**
	 * Get the right node using index
	 * 
	 * @param i - the index of the parent node
	 * @return the index of the right child node
	 */
	public int right(int i) { // tested
		return 2 * i + 1;
	}

	/**
	 * Get the left node using index
	 * 
	 * @param i - the index of the parent node
	 * @return the index of the left child node
	 */
	public int left(int i) { // tested
		return 2 * i;
	}

	/**
	 * Assuming that the left and right subtrees are max-heaps, heapify downward.
	 * 
	 * @param i - the index of the parent node
	 */
	public void heapify(int i) { // tested
		// heapification downward
		/*
		 * Pre-condition - Both the left and right subtrees of node i are max-heaps and i
		 * is less than or equal to heap-size[A] Post-condition - The subtree rooted at
		 * node i is a max-heap
		 */
		int largest = i;
		int l = left(i);
		int r = right(i);
		// Test to see if right node is missing
		if (r <= heapSize) {
			if (l <= heapSize && heapArray[l].compareTo(heapArray[r]) == 1) {
				largest = l;
			}

			if (r <= heapSize && heapArray[r].compareTo(heapArray[largest]) == 1) {
				largest = r;
			}

		} else {
			if (l <= heapSize)
				largest = l;
			else
				largest = i;
		}
		if (largest != i) {
			// exchange heapArray[i] and heapArray[largest]
			exchangeTasks(largest, i);
			heapify(largest);
		}
	}

	/**
	 * Heapify upwards. Used the following code for inspiration
//	 * <a href = "https://github.com/tobeking01/heapifyUp-HeapifyDown/blob/main/GamesHeap.java">
//	 * tobeking01/heapifyUp-HeapifyDown.</a>
	 * 
	 * @param i - the index of an array
	 */
	public void heapifyUp(int i) { // tested
		int par = parent(i);
		if (i <= heapSize && i > 1) {
			if (heapArray[par].compareTo(heapArray[i]) == -1) {
				exchangeTasks(i, par);
				heapifyUp(par);
			}
		}
	}

	/**
	 * Get the top node of the max heap
	 * 
	 * @return heapArray[1] - the top node of the max heap
	 */

	public Task max() { // tested
		if (heapSize < 1) {
			System.out.println("heap underflow");
			return null;
		} else {
			return heapArray[1];
		}
	}

	/**
	 * Remove the top node from the max heap and return it
	 * 
	 * @return m - the top node of the max heap
	 * @throws HeapException - heap underflow
	 */
	public Task extractMax() throws HeapException { // tested
		if (heapSize <= 0) {
			throw new HeapException("error: heap underflow");
		}
		Task m = max();
		heapArray[1] = heapArray[heapSize];
		heapSize = heapSize - 1;
		heapify(1);
		return m;
	}

	/**
	 * Insert a object into the heap.
	 * 
	 * @param x - the object to insert into the heap
	 * @param n - the position to insert into the heap
	 */
	public void insert(Object x) { // tested
		// check if the heapsize is equal to array size
		if (heapSize + 1 == heapArray.length) {
			heapArray = Arrays.copyOf(heapArray, heapArray.length * 2);
		}
		heapSize+=1;
		heapArray[heapSize] = (Task)x; 
		if (heapSize>=1) {
			heapifyUp(heapSize);
		}
	}

	/**
	 * Increase the key of some object inside heap
	 * 
	 * @param x - the Task to increase the key.
	 * @param k - the new key.
	 * @throws HeapException - new key is smaller than current key
	 */
	public void increaseKey(Task x) throws HeapException { // tested
		int i;
		if (k < x.getKey()) {
			throw new HeapException("new key is smaller than current key");
		} else {

			x.setPriority(k);
			// find the index i in array heapArray where object x occurs
			i = getIndex(x);
//			while (i > 1 && heapArray[parent(i)].getPriority() < heapArray[i].getKey()) {
			while (i > 1 && heapArray[parent(i)].compareTo(heapArray[i]) == -1) {
				// exchange heapArray[i] with heapArray[Parent(i)], updating the information
				// that maps
				exchangeTasks(i, parent(i));
			}
		}
	}

	/**
	 * Find out if heap is full or empty. Returns
	 * false if it is full and true if it is empty
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() { // tested
		if (heapSize > 0) {
			return false;
		} else if (heapSize == 0) {
			return true;
		} else {
			System.out.println("error heap < 0, MaxHeap.isEmpty");
			return false;
		}
	}

	/**
	 * Switches two elements in array. The user inputs the indexes of the two
	 * arrays.
	 * 
	 * @param x is the index of the first element
	 * @param y is the index of the second element
	 */
	public void exchangeTasks(int x, int y) { // tested
		Task b;
		b = heapArray[y];
		heapArray[y] = heapArray[x];
		heapArray[x] = b;
	}

	/**
	 * Getter for heapSize
	 * 
	 * @return heapSize Value
	 */
	public int getHeapSize() { // tested
		return heapSize;
	}

	/**
	 * Setter for heapSize
	 * 
	 * @param heapSize new Value
	 */
	public void setHeapSize(int heapSize) { // tested
		this.heapSize = heapSize;
	}

	/**
	 * Increase HeapSize by 1
	 */
	public void increaseHeapSize() { // tested
		this.heapSize += 1;
	}

	/**
	 * Getter for heapArray
	 * 
	 * @return heapArray;
	 */
	public Task[] getHeapArray() { // tested
		return heapArray;
	}

	/**
	 * set an array to be the heapArray
	 * 
	 * @param heapArray
	 */
	public void setHeapArray(Task[] heapArray) { // tested
		this.heapArray = heapArray;
	}

	/**
	 * Get the index of an object in the heap Array
	 * 
	 * @param t
	 * @return i
	 */
	public int getIndex(Task t) { // tested
		for (int i = 0; i < heapArray.length; i++) {
			if (t.equals(heapArray[i])) {
				return i;
			}
		}
		System.out.println("Error Task is not found");
		return heapArray.length + 1; // will throw error because it is null
	}
	
	
}