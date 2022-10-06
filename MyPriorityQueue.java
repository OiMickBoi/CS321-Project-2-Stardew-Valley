public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

	public MyPriorityQueue() {
		super();
	}

	public MyPriorityQueue(Task A []) {
		super(A);
	}

	/**
	 *{@inheritDoc}
	 */
    public void enqueue(Object task) {
    	try {
			super.insert(task);
    	} catch (HeapException e) {}
    }

	/**
	 *{@inheritDoc}
	 */
    public Task dequeue() {
    	try {
			return super.extractMax();
    	} 
    	catch(HeapException e) {
    		return null;
    	}
    }

	/**
	 *{@inheritDoc}
	 */
    public boolean isEmpty() {
        return super.isEmpty();
    }

	/**
	 *{@inheritDoc}
	 */
    public void update(int timeToIncrementPriority, int maxPriority) {
    	for(int i = 1; i <= super.getHeapSize(); i++) {
    		heapArray[i].incrementWaitingTime();
    		if (heapArray[i].getWaitingTime() >= timeToIncrementPriority) {
    			heapArray[i].resetWaitingTime();
    			if (heapArray[i].getPriority() < maxPriority) {
    				heapArray[i].incrementPriority();
    				try {
						increaseKey(heapArray[i], 1);
    				} catch (HeapException e) {}
    			}
    		}
    	}
    }

}