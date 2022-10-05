public class MyPriorityQueue implements PriorityQueueInterface {
	MaxHeap maxheap = new MaxHeap();

	/**
	 *{@inheritDoc}
	 */
    public void enqueue(Object task) {
    	maxheap.insert(task);
    }

	/**
	 *{@inheritDoc}
	 */
    public Task dequeue() {
    	return maxheap.extractMax();
    }

	/**
	 *{@inheritDoc}
	 */
    public boolean isEmpty() {
        return maxheap.isEmpty();
    }

	/**
	 *{@inheritDoc}
	 */
    public void update(int timeToIncrementPriority, int maxPriority) {
    	/*
    	 * waitingTime++
    	 * if waitingTime >= timeToIncrementPriority
    	 * 		waitingTime = 0
    	 * 		if(priorityLevel < maxPriorityLevle
    	 * 			priorityLevel++
    	 * 			Call increaseKey on this task
    	 */
    	Task array[] = maxheap.getHeapArray();
    	for(int i = 1; i <= maxheap.getHeapSize(); i++) {
//    	for(Task i : array) {
    		array[i].incrementWaitingTime();
    		if (array[i].getWaitingTime() >= timeToIncrementPriority) {
    			array[i].resetWaitingTime();
    			if (array[i].getPriority() < maxPriority) {
    				array[i].incrementPriority();
    				array[i].increaseKey();
    			}
    		}
    	}
    }
}
