public class MyPriorityQueue implements PriorityQueueInterface {
	private MaxHeap maxHeap = new MaxHeap();
	private Task currentTask = new Task();

	/**
	 *{@inheritDoc}
	 */
    public void enqueue(Object task) {
    	maxHeap.insert(task);
    }

	/**
	 *{@inheritDoc}
	 */
    public Task dequeue() {
//    	currentTask = maxHeap.extractMax();
//    	currentTask.resetWaitingTime();
//    	currentTask.setPriority(0);
//    	return currentTask;
    	return maxHeap.extractMax();
    }

	/**
	 *{@inheritDoc}
	 */
    public boolean isEmpty() {
        return maxHeap.isEmpty();
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
    	Task array[] = maxHeap.getHeapArray();
    	for(int i = 1; i <= maxHeap.getHeapSize(); i++) {
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
