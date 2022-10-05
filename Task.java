public class Task implements TaskInterface, Comparable<Task> {
    private int priority;
    private int waitingTime;
    private int key;
    private int hourCreated;
    private String taskDescription = new String();
    private TaskInterface.TaskType taskType;

    /**
     * Default Task Constructor. Sets priority, 
     * waitingTime, and hourCreated to 0.
     */
    public Task() {
    	priority = 0;
    	waitingTime = 0;
    	hourCreated = 0;
    }

    /**
     * Task Constructor for Testing purposes.
     * @param priority
     * @param waitingTime
     */
    public Task(int priority, int waitingTime) {
    	this.priority = priority;
    	this.waitingTime = waitingTime;
    	hourCreated = 0;
    }

    /**
     * Overloaded Constructor for Tasks. Sets Priority and
     * waitingTime to 0.
     * @param hourCreated
     * @param taskType
     * @param taskDescription
     */
    public Task(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
    	priority = 0;
    	waitingTime = 0;
    	this.hourCreated = hourCreated;
    	this.taskType = taskType;
    	this.taskDescription += taskDescription;
        
    }

    /**
     * Getter method to get key.
     * @return key
     */
    public int getKey() {
        return key;
    }
    
    /**
     * Setter method for key.
     * @param key - integer to set key.
     */
    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Increments the key by one.
     */
    public void increaseKey() {
    	key += 1;
    }
    
    /**
     * Getter method for priority.
     *
     * @return 
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Setter method for priority.
     *
     * @param priority - value to set priority.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Increments Priority by 1
     *
     */
    public void incrementPriority() {
        priority += 1;
    }

    /**
     * Gets the TaskType of a certain task
     *
     * @return - Task.TaskType - the Task's type
     */
    //TODO implement tasktype
    public Task.TaskType getTaskType() {
    	
        return this.taskType;
    }

    /**
     * Increments the waiting time by one.
     */
    public void incrementWaitingTime() {
        waitingTime += 1;
    }

    /**
     * Resets the waiting time to 0.
     */
    public void resetWaitingTime() {
        waitingTime = 0;
    }

    /**
     * Gets the waiting time of a process.
     *
     * @return the waiting time
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    /**
     * Compares the priority of two tasks. If Task object is
     * bigger it returns 1.
     * If the parameter is larger than the object, it returns
     * -1.
     * @param task to compare
     * @return - 1, -1, or 0
     */

    public int compareTo(Task task) {
    	// If the two tasks have equal priorities,
    	// use waiting time to compare.
    	if (getPriority() == task.getPriority()) {
			if(getWaitingTime() > task.getWaitingTime()) {
				return 1;
			} else if(getWaitingTime() < task.getWaitingTime()) {
				return -1;
			} else {
				return 0;
			}
			// compare normally with priority
    	} else {
			if(getPriority() > task.getPriority()) {
				return 1;
			} else if(getPriority() < task.getPriority()) {
				return -1;
			} else {
				return 0;
			}
    	}
    }

    /**
     * Getter method for taskDescription
     * @return description
     */
	public String getTaskDescription() {
		return taskDescription;
	}

    /**
     * Creates a string containing the Task's information.
     *
     * @return String of the Task
     */
    @Override
    public String toString() {
        return  taskType + " " + taskDescription + " at Hour: " + hourCreated + ":00";
    }

}