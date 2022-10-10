import java.util.Random;
import java.util.stream.DoubleStream;

public class TaskGenerator implements TaskGeneratorInterface{
    public final int DEFAULT_ENERGY = 200;

    private int hourCreated;
    private TaskInterface.TaskType taskType;
    private String taskDescription;
    private int currentEnergyStorage = DEFAULT_ENERGY;

    private double taskGenerationProbability;
    private long seed;
    private Random random;

    public TaskGenerator(double taskGenerationProbability, long seed){
    	this.taskGenerationProbability = taskGenerationProbability;
    	this.seed = seed;
    	random = new Random(seed);
    }

    public TaskGenerator(double taskGenerationProbability){
    	this.taskGenerationProbability = taskGenerationProbability;
    	random = new Random();
    }


    /**
     * Creates a new Task with default zero priority.
     *
     * @param hourCreated hour that the Task was created
     * @param taskType type of the Task
     * @param taskDescription the Task's description
     */
    public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
        this.hourCreated = hourCreated;
        this.taskType = taskType;
        this.taskDescription = taskDescription;
        Task newtask = new Task(hourCreated, taskType, taskDescription);
        return newtask;
    }

    /**
     * Decrements the total energy storage based on the current task.
     *
     * @param taskType the type of Task
     */
    public void decrementEnergyStorage(Task.TaskType taskType) {
		// Decrement by taskType except socializing
    	// and foraging
    	this.currentEnergyStorage -= taskType.getEnergyPerHour();
    }

    /**
     * Resets the total energy storage to DEFAULT_ENERGY level.
     */
    public void resetCurrentEnergyStorage() {
    	this.currentEnergyStorage = DEFAULT_ENERGY;
    }

    /**
     * Returns the current energy storage.
     *
     * @returns current energy storage
     */
    public int getCurrentEnergyStorage() {
        return this.currentEnergyStorage;
    }

    /**
     * Sets the current energy storage.
     *
     * @param newEnergyNum number to set the energy
     */
    public void setCurrentEnergyStorage(int newEnergyNum) {
    	this.currentEnergyStorage = newEnergyNum;
    }

    /**
     * Determines if a new task is to be generated.
     *
     * return true or false if task should be generated
     */
    public boolean generateTask() {
    	Double x = random.nextDouble();
    	if (x < taskGenerationProbability) {
    		return true;
    	} else {
			return false;
    	}
    }

    /**
     * Determines the likelihood of passing out or dying
     * based on the task and death probability.  Where
     * 0 is not dying or passing out, 1 is passing out,
     * and 2 is dying in the Mines.
     *
     * @param task the Task
     * @param unlucky probability 
     * @returns  0, 1 or 2 depending on the unluckiness
     */
    public int getUnlucky(Task task, double unluckyProbability) {
    	if (unluckyProbability <= task.getTaskType().getPassingOutProbability()) {
    		if (unluckyProbability <= task.getTaskType().getDyingProbabilityProbability() && task.getTaskType() == taskType.MINING) {
    			currentEnergyStorage -= (3 * currentEnergyStorage/4); 
    			task.setPriority(0);
    			return 2;
    		} else {
    			currentEnergyStorage /= 2;
    			return 1;
    		}
    	} else {
    		return 0;
    	}
    }
    
    /**
     * Create a String containing the Task's information.
     *
     * @param task the Task
     * @param taskType the Task's type
     */
    @Override
    public String toString(Task task, Task.TaskType taskType) {
            if(taskType == Task.TaskType.MINING) {
                return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
            }
            if(taskType == Task.TaskType.FISHING) {
                return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
            }
            if(taskType == Task.TaskType.FARM_MAINTENANCE) {
                return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
            }
            if(taskType == Task.TaskType.FORAGING) {
                return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
            }
            if(taskType == Task.TaskType.FEEDING) {
                return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
            }
            if(taskType == Task.TaskType.SOCIALIZING) {
                return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
            }
            else { return "nothing to see here..."; }
    }
}
