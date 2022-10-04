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
    	for(Task i : array) {
    		i.incrementWaitingTime();
    		if (i.getWaitingTime() >= timeToIncrementPriority) {
    			i.resetWaitingTime();
    			if (i.getPriority() < maxPriority) {
    				i.incrementPriority();
    				i.increaseKey();
    			}
    		}
    	}
    }
}
