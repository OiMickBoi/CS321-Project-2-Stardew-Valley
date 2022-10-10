/**
 * Defines a max-heap using an array. 
 * The heap doubles automatically when 
 * it becomes full.  
 * Each node within the max-heap contains one of 
 * the six types of tasks.  
 * @author Joshua Boyle 
 */
import java.util.Arrays;

/* start at index one. you used the
   pseudocode straight from the book.
   so you have to use index 0 as dummy 
   index.
*/

public class MaxHeap {
	private int heapSize;
	protected Task[] heapArray;

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
	 * @param n the size of the heap
	 */
	public MaxHeap(int n) { // tested
		heapSize = 0;
		heapArray = new Task[n + 1];
	}

	/**
	 * Overloaded constructor to build the heap.
	 * 
	 * @param A user's heap array
	 * @param n the heap array's size
	 */
	public MaxHeap(Task[] A) { // tested
		heapSize = 0;
		heapArray = A;
	}

	/**
	 * Overloaded constructor to build the heap.
	 * 
	 * @param A user's heap array
	 */
	public MaxHeap(Task[] A, int n) { // not tested
		heapSize = 0;
		heapArray = A;
	}

	/**
	 * Builds a max heap out of an unsorted array.
	 * 
	 * @param n the size of the heap
	 */
	public void buildMaxHeap() { // tested
		for (int i = heapSize / 2; i > 0; i--) {
			heapify(i);
		}
	}

	// Get the parent node using index
	/**
	 * Get the parent node using index.
	 * 
	 * @param i the index of the child.
	 * @return Returns the parent node's index.
	 */
	public int parent(int i) { // tested
		return i / 2; // integer division
	}

	/**
	 * Get the right node using index.
	 * 
	 * @param i the index of the parent node
	 * @return Returns the index of the right child node.
	 */
	public int right(int i) { // tested
		return 2 * i + 1;
	}

	/**
	 * Get the left node using index.
	 * 
	 * @param i the index of the parent node
	 * @return Returns the index of the left child node.
	 */
	public int left(int i) { // tested
		return 2 * i;
	}

	/**
	 * Assuming that the left and right subtrees are max-heaps, heapify downward.
	 * 
	 * @param i the index of the parent node
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

		if (l <= heapSize && heapArray[l].compareTo(heapArray[largest]) > 0) {
			largest = l;
		}

		if (r <= heapSize && heapArray[r].compareTo(heapArray[largest]) > 0) {
			largest = r;
		}

		if (largest != i) {
			// exchange heapArray[i] and heapArray[largest]
			exchangeTasks(largest, i);
			heapify(largest);
		}
	}

	/**
	 * Get the top node of the max heap.
	 * 
	 * @return Index of the top node
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
	 * Remove the top node from the max heap and return it.
	 * 
	 * @return m - The top node of the max heap.
	 * @throws HeapException heap underflow
	 */
	public Task extractMax() throws HeapException { // tested
		if (heapSize <= 0) {
			throw new HeapException("error: heap underflow");
		}
		Task m = max();
		heapArray[1] = heapArray[heapSize];
		heapSize -= 1;
		heapify(1);
		return m;
	}


	/**
	 * Increase the key of some object inside heap.
	 * 
	 * @param x The Task to increase the key.
	 * @param k The new key.
	 * @throws HeapException new key is smaller than current key
	 */
	public void increaseKey(Task x, int k) throws HeapException { // tested
		int i;
			i = getIndex(x);
			while (i > 1 && heapArray[parent(i)].compareTo(heapArray[i]) < 0) {
				// exchange heapArray[i] with heapArray[Parent(i)], updating the information
				// that maps
				exchangeTasks(i, parent(i));
				i = parent(i);
			}
		}
//	}

	/**
	 * Insert a object into the heap.
	 * 
	 * @param x the object to insert into the heap
	 * @param n the position to insert into the heap
	 * @throws HeapException 
	 */
	public void insert(Object x) throws HeapException { // tested
		// check if the heapsize is equal to array size
		if (heapSize + 1 == heapArray.length) {
			heapArray = Arrays.copyOf(heapArray, heapArray.length * 2);
		}
		// insert task
		heapSize+=1;
		heapArray[heapSize] = (Task)x; 
		increaseKey((Task)x, heapSize);
	}

	/**
	 * Find out if heap is full or empty. Returns
	 * false if it is full and true if it is empty
	 * 
	 * @return true or false - determines if the heap is full or empty
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
	 * @param x the index of the first element
	 * @param y the index of the second element
	 */
	public void exchangeTasks(int x, int y) { // tested
		Task b;
		b = heapArray[y];
		heapArray[y] = heapArray[x];
		heapArray[x] = b;
	}

	/**
	 * Getter for heapSize.
	 * 
	 * @return heapSize - The size of the heap.
	 */
	public int getHeapSize() { // tested
		return heapSize;
	}

	/**
	 * Setter for heapSize.
	 * 
	 * @param heapSize new size of the heap
	 */
	public void setHeapSize(int heapSize) { // tested
		this.heapSize = heapSize;
	}

	/**
	 * Increase the size of the heap by 1.
	 */
	public void increaseHeapSize() { // tested
		this.heapSize += 1;
	}

	/**
	 * Get the array containing the heap.
	 * 
	 * @return heapArray - the array containing the heap
	 */
	public Task[] getHeapArray() { // tested
		return heapArray;
	}

	/**
	 * Set an array to be the heapArray.
	 * 
	 * @param heapArray array to contain the heap
	 */
	public void setHeapArray(Task[] heapArray) { // tested
		this.heapArray = heapArray;
	}

	/**
	 * Get the index of an object in the heap Array.
	 * 
	 * @param t task to get index
	 * @return i - The index of the searched task.
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
	
	/**
	 * Given a index i, the method will traverse the
	 * array and determine if the array contains
	 * a MaxHeap.
	 * @param i node in a heap
	 * @return true or false - if it is truly a heap.
	 */
	public boolean isMaxHeap(int i) {
		int largest = i;
		int l = left(i);
		int r = right(i);

		if (l <= heapSize && heapArray[l].compareTo(heapArray[largest]) < 0) {
			boolean isHeap = isMaxHeap(l);
			if (isHeap ==  false) {
				return false;
			}
		} else if (l <= heapSize && heapArray[l].compareTo(heapArray[largest]) > 0) {
			return false;
		}

		if (r <= heapSize && heapArray[r].compareTo(heapArray[i]) < 0) {
			boolean isHeap = isMaxHeap(r);
			if (isHeap ==  false) {
				return false;
			}
		} else if (r <= heapSize && heapArray[r].compareTo(heapArray[largest]) > 0) {
			return false;
		}
		return true;
		
	}

}