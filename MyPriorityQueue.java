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
    	this.insert(task);
    }

	/**
	 *{@inheritDoc}
	 */
    public Task dequeue() {
    	try {
			return super.extractMax();
    	} catch(HeapException e) {
    		return null;
    	}
    }

	/**
	 *{@inheritDoc}
	 */
    public boolean isEmpty() {
        return this.isEmpty();
    }

	/**
	 *{@inheritDoc}
	 */
    public void update(int timeToIncrementPriority, int maxPriority) {
    	Task[] tempArray = new Task[this.getHeapSize()];
    	for(int i = 1; i <= tempArray.length; i++) {
    		try {
    			tempArray[i] = this.extractMax();
    		}
    		catch (HeapException e) {}
    		tempArray[i].incrementWaitingTime();
    		if (tempArray[i].getWaitingTime() >= timeToIncrementPriority) {
    			tempArray[i].resetWaitingTime();
    			if (tempArray[i].getPriority() < maxPriority) {
    				tempArray[i].incrementPriority();
    			}
    		}
    	}
    }

//    public void update(int timeToIncrementPriority, int maxPriority) {
//    	Task[] tempArray = new Task[this.getHeapSize()];
//    	for(int i = 1; i <= tempArray.length; i++) {
//    		try {
//    			tempArray[i] = this.extractMax();
//    		}
//    		catch (HeapException e) {}
//    		this.getHeapArray()[i].incrementWaitingTime();
//    		if (this.getHeapArray()[i].getWaitingTime() >= timeToIncrementPriority) {
//    			this.getHeapArray()[i].resetWaitingTime();
//    			if (this.getHeapArray()[i].getPriority() < maxPriority) {
////    				this.getHeapArray()[i].incrementPriority();
//    				this.increaseKey(, i);
////    				this.get
//    			}
//    		}
//    	}
//    }
//
}