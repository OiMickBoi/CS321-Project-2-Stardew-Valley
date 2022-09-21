public class Task implements TaskInterface, Comparable<Task> {
    private int priority = 0;
    private int waitingTime = 0;
    private int key = 0;

    public Task() {
        
    }
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    /**
     * Returns the priority.
     *
     * @return 1 if greater, -1 if less than
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Sets the priority to the specified value.
     *
     * @param priority value to set priority
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Gets the waiting time of a process.
     *
     * @return - Task.TaskType - the Task's type
     */
    public Task.TaskType getTaskType() {
        return TaskType.TaskType;
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
     * Gets the waiting time of a process
     *
     * @return the waiting time
     */
    public int getWaitingTime() {
        return waitingTime;
    }

    //priorities
    public int compareTo(Task task) {
        if(getPriority() > task.getPriority()) {
            return 1;  
        }
        else if(getPriority() < task.getPriority()) {
            return -1;  
        }
    }

    /**
     * Creates a string containing the Task's information.
     *
     * @return String of the Task
     */
    public String toString() {
        return "Task.toString() needs implementation.";
    }


}