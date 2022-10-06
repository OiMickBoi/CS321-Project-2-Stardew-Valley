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
    	super.insert(task);
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
//    public void update(int timeToIncrementPriority, int maxPriority) {
//    	Task[] tempArray = new Task[super.getHeapArray().length];
//    	for(int i = 1; i <= super.getHeapSize(); i++) {
//    		try {
//    			tempArray[i] = super.extractMax();
//    		}
//    		catch (HeapException e) {}
//    		tempArray[i].incrementWaitingTime();
//    		if (tempArray[i].getWaitingTime() >= timeToIncrementPriority) {
//    			tempArray[i].resetWaitingTime();
//    			if (tempArray[i].getPriority() < maxPriority) {
//    				tempArray[i].incrementPriority();
//    			}
//    		}
//
//    	}
//    	for(int i = 1; i <= super.getHeapSize(); i++) {
//    		this.enqueue(tempArray[i]);
//    	}
//    }

    public void update(int timeToIncrementPriority, int maxPriority) {
    	Task[] tempArray = new Task[super.getHeapArray().length];
    	for(int i = 1; i <= super.getHeapSize(); i++) {
    		try {
    			tempArray[i] = this.extractMax();
    			super.increaseHeapSize();
    		}
    		catch (HeapException e) {}
    		super.getHeapArray()[i].incrementWaitingTime();
    		if (super.getHeapArray()[i].getWaitingTime() >= timeToIncrementPriority) {
    			super.getHeapArray()[i].resetWaitingTime();
    			if (super.getHeapArray()[i].getPriority() < maxPriority) {
    				super.getHeapArray()[i].incrementPriority();
    				super.increaseKey(super.getHeapArray()[i],super.getHeapArray()[i].incrementPriority());
//    				this.increaseKey(, i);
//    				this.get
    			}
    		}
    	}
    }

}