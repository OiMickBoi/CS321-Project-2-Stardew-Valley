import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskInterface.TaskType;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTester {
	MaxHeap maxHeap, overloadedHeap;

	Task task1, task2, task3, task4, max, bigMax, task6, task7, task8, task9, task10, task11, task12, task13;
	Task newTask1, taskEqual1, taskEqual2, taskEqual3, taskEqual4,taskEqual5, taskEqual6, taskEqual7, taskEqual8;

	@BeforeEach
	void setUp() throws Exception {
		maxHeap = new MaxHeap();
		overloadedHeap = new MaxHeap(3);
		max = new Task(5, 1);
		task1 = new Task(3, 1);
		task2 = new Task(1, 1);
		task3 = new Task(4, 1);
		task4 = new Task(2, 1);

		bigMax = new Task(20, 1);
		task6 = new Task(6, 1);
		task7 = new Task(7, 1);
		task8 = new Task(8, 1);
		task9 = new Task(9, 1);
		task10 = new Task(10, 1);
		task11 = new Task(11, 1);
		task12 = new Task(12, 1);
		task13 = new Task(13, 1);
		taskEqual1 = new Task(10, 1);
		taskEqual2 = new Task(10, 12);
		taskEqual3 = new Task(10, 1);
		taskEqual4 = new Task(10, 1);

		taskEqual5 = new Task(10, 1);
		taskEqual6 = new Task(10, 1);
		taskEqual7 = new Task(10, 1);
		taskEqual8 = new Task(10, 1);
		
		newTask1 = new Task(3, Task.TaskType.MINING, "mining stuff");
	}
	
	@Test
	void testHeapifyUp() {
		Task [] taskArray = {null, task1, task2, max};
		maxHeap.setHeapArray(taskArray);
		maxHeap.setHeapSize(3);
		maxHeap.heapifyUp(3);
		assertEquals(maxHeap.getIndex(max), 1, "error testHeapifyUp");
		assertEquals(maxHeap.getIndex(task1), 3, "error testHeapifyUp");
		assertEquals(maxHeap.getIndex(task2), 2, "error testHeapifyUp");
	}

	@Test
	void testExtractMax() {
		maxHeap.insert(max);
		maxHeap.insert(task1);
		maxHeap.insert(task2);
		assertEquals(maxHeap.extractMax().getPriority(), max.getPriority(), "error testExtractMax");
	}

	@Test
	void testOverloadedExtractMax() {
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		assertEquals(overloadedHeap.extractMax().getPriority(), max.getPriority(), "error overloadedExtractMax");
	}

	@Test
	void testHeapDoubling() {
		// test if Heap doubles when heapSize max is reached.
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		overloadedHeap.insert(task3);
		Task[] array = overloadedHeap.getHeapArray();
		assertEquals(array.length, 8, "error testHeapDoubling");
	}

	@Test
	void testParent() {
		// parent() test
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		Task[] array = overloadedHeap.getHeapArray();
		assertEquals(array[maxHeap.parent(3)].getPriority(), max.getPriority(), "error testParent");
	}

	@Test
	void testLeft() {
		// left() test
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		Task[] array = overloadedHeap.getHeapArray();
		assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testLeft");
	}

	@Test
	void testRight() {
		// right() test
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		Task[] array = overloadedHeap.getHeapArray();
		assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testRight");
	}

	@Test
	void testInsert() {
		maxHeap.insert(max);
		Task[] array = maxHeap.getHeapArray();
		assertEquals(array[1].getPriority(), max.getPriority(), "error testInsert");
	}

	@Test
	void testInsert2() {
		maxHeap.insert(max);
		maxHeap.insert(task1);
		Task[] array = maxHeap.getHeapArray();
		assertEquals(array[1].getPriority(), max.getPriority(), "error testInsert");
		assertEquals(array[2].getPriority(), task1.getPriority(), "error testInsert");
	}

	@Test
	void testInsertLess() {
		maxHeap.insert(task1);
		maxHeap.insert(task2);
		maxHeap.insert(max);
		Task[] array = maxHeap.getHeapArray();
		assertEquals(array[1].getPriority(), max.getPriority(), "error testInsert");
		assertEquals(array[2].getPriority(), task2.getPriority(), "error testInsert");
		assertEquals(array[3].getPriority(), task1.getPriority(), "error testInsert");
	}
	@Test
	void testMax() {
		maxHeap.insert(max);
		maxHeap.insert(task1);
		maxHeap.insert(task2);
		assertEquals(maxHeap.max().getPriority(), max.getPriority(), "error testMax");
	}

	@Test
	void testGetIndex() {
		maxHeap.insert(task2);
		maxHeap.insert(max);
		maxHeap.insert(task1);
		assertEquals(maxHeap.getIndex(task2), 2, "error testGetIndex");
	}

	@Test
	void testHeapify() {
		overloadedHeap.insert(task2);
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.heapify(1);
		assertEquals(overloadedHeap.getIndex(max), 1, "error testHeapify");
		assertEquals(overloadedHeap.getIndex(task1), 3, "error testHeapify");
		assertEquals(overloadedHeap.getIndex(task2), 2, "error testHeapify");
	}

	@Test
	void testBuildMaxHeap() {
		Task [] taskArray = {null, task6, task7, task8, task9};
		overloadedHeap.setHeapArray(taskArray);
		overloadedHeap.setHeapSize(4);
		overloadedHeap.buildMaxHeap();
		assertEquals(1, overloadedHeap.getIndex(task9), "error testBuildMaxHeap");
		assertEquals(2, overloadedHeap.getIndex(task7), "error testBuildMaxHeap");
		assertEquals(3, overloadedHeap.getIndex(task8), "error testBuildMaxHeap");
		assertEquals(4, overloadedHeap.getIndex(task6), "error testBuildMaxHeap");
	}

	@Test
	void testBuildMaxHeap2() {
		Task [] taskArray = {null, task6, task7, task8, task9, task10};
		overloadedHeap.setHeapArray(taskArray);
		overloadedHeap.setHeapSize(5);
		overloadedHeap.buildMaxHeap();
		assertEquals(1, overloadedHeap.getIndex(task10), "error testBuildMaxHeap2");
		assertEquals(2, overloadedHeap.getIndex(task9), "error testBuildMaxHeap2");
		assertEquals(3, overloadedHeap.getIndex(task8), "error testBuildMaxHeap2");
		assertEquals(4, overloadedHeap.getIndex(task6), "error testBuildMaxHeap2");
		assertEquals(5, overloadedHeap.getIndex(task7), "error testBuildMaxHeap2");
	}

	@Test
	void testIncreaseKey() {
		overloadedHeap.insert(task6);
		overloadedHeap.insert(task7);
		overloadedHeap.insert(task8);
		overloadedHeap.insert(task9);
		overloadedHeap.insert(task10);
		overloadedHeap.insert(task1);
		overloadedHeap.increaseKey(task1, 3);
		assertEquals(task1.getKey(), 3, "error testIncreaseKey");
	}

	@Test
	void testIsEmpty() {
		boolean test = maxHeap.isEmpty();
		assertTrue(test);
	}

	@Test
	void testExchangeTasks() {
		maxHeap.insert(task1);
		maxHeap.insert(task2);
		maxHeap.exchangeTasks(1, 2);
		assertEquals(maxHeap.getIndex(task1), 2, "error testExchangeTasks");
		assertEquals(maxHeap.getIndex(task2), 1, "error testExchangeTasks");
	}

	@Test
	void testGetHeapSize() {
		maxHeap.insert(task1);
		maxHeap.insert(task2);
		maxHeap.insert(task3);
		assertEquals(maxHeap.getHeapSize(), 3, "error testGetHeapSize");
	}

	@Test
	void testSetHeapSize() {
		maxHeap.setHeapSize(3);
		assertEquals(maxHeap.getHeapSize(), 3, "error testSetHeapSize");
	}

	@Test
	void testGetHeapArray() {
		overloadedHeap.insert(max);
		overloadedHeap.insert(task1);
		overloadedHeap.insert(task2);
		overloadedHeap.insert(task3);
		Task[] array = overloadedHeap.getHeapArray();
		assertEquals(array, overloadedHeap.getHeapArray(), "error testGetHeapArray");
	}

	@Test
	void testSetHeapArray() {
		Task[] array = { max, task1, task2, task3 };
		overloadedHeap.setHeapArray(array);
		assertEquals(array, overloadedHeap.getHeapArray(), "error testSetHeapArray");
	}

	@Test
	void testFullConstructor() {
		Task[] array = { max, task1, task2, task3 };
		MaxHeap userHeap = new MaxHeap(array);
		assertEquals(array, userHeap.getHeapArray(), "error testFullConstructor");
	}

	@Test
	void testGetTaskDescription() {
		assertEquals(newTask1.getTaskDescription(), "mining stuff", "error testFullConstructor");
	}

	@Test
	void testCompareToEqualPriority() {
		assertEquals(taskEqual1.compareTo(taskEqual2), -1, "error testCompareToEqualPriority");
	}

	@Test
	void testCompareToEqualPriority2() {
		assertEquals(taskEqual2.compareTo(taskEqual1), 1, "error testCompareToEqualPriority");
	}

	@Test
	void testCompareToEqualPriority3() {
		assertEquals(taskEqual3.compareTo(taskEqual4), 0, "error testCompareToEqualPriority");
	}

	@Test
	void testCompareToEqualPriorityQueue() {
		taskEqual5.setTimeInQueue(0);
		taskEqual6.setTimeInQueue(1);
		taskEqual7.setTimeInQueue(1);
		assertEquals(taskEqual5.compareTo(taskEqual6), -1, "error testCompareToEqualPriority");
		assertEquals(taskEqual6.compareTo(taskEqual5), 1, "error testCompareToEqualPriority");
		assertEquals(taskEqual6.compareTo(taskEqual7), 0, "error testCompareToEqualPriority");
	}
}