public class Task implements TaskInterface, Comparable<Task> {
    private int priority = 0;
    private int waitingTime = 0;
    private int key = 0;
    private TaskInterface.TaskType taskType;

    // Just a test constructor
    public Task(int priority, int waitingTime) {
        this.priority = priority;
        this.waitingTime = waitingTime;
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
    //TODO implement tasktype
    public Task.TaskType getTaskType() {
        return taskType;
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
     * Compares the priority of two tasks
     * @param task
     * @return
     */

    public int compareTo(Task task) {
        if(getPriority() > task.getPriority()) {
            return 1;
        }
        else if(getPriority() < task.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Creates a string containing the Task's information.
     *
     * @return String of the Task
     */
    @Override
    public String toString() {
        return "Task.toString() needs implementation.";
    }
}