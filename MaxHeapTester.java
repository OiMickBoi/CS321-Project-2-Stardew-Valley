import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TaskInterface.TaskType;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTester {
	MaxHeap maxHeap, overloadedHeap;

	Task task1, task2, task3, task4, max, bigMax, task6, task7, task8, task9, task10, task11, task12, task13;
	Task newTask1;

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
		
		newTask1 = new Task(3, Task.TaskType.MINING, "mining stuff");
		
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
		maxHeap.insert(task4);
		assertEquals(maxHeap.getIndex(task2), 1, "error testHeapify");
		assertEquals(maxHeap.getIndex(max), 2, "error testHeapify");
		assertEquals(maxHeap.getIndex(task1), 3, "error testHeapify");
		assertEquals(maxHeap.getIndex(task4), 4, "error testHeapify");
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
		overloadedHeap.insert(task6);
		overloadedHeap.insert(task7);
		overloadedHeap.insert(task8);
		overloadedHeap.insert(task9);
		overloadedHeap.buildMaxHeap();
		assertEquals(overloadedHeap.getIndex(task9), 1, "error testBuildMaxHeap");
		assertEquals(overloadedHeap.getIndex(task7), 2, "error testBuildMaxHeap");
		assertEquals(overloadedHeap.getIndex(task8), 3, "error testBuildMaxHeap");
		assertEquals(overloadedHeap.getIndex(task6), 4, "error testBuildMaxHeap");
	}

	@Test
	void testBuildMaxHeap2() {
		overloadedHeap.insert(task6);
		overloadedHeap.insert(task7);
		overloadedHeap.insert(task8);
		overloadedHeap.insert(task9);
		overloadedHeap.insert(task10);
		overloadedHeap.buildMaxHeap();
		assertEquals(overloadedHeap.getIndex(task10), 1, "error testBuildMaxHeap2");
		assertEquals(overloadedHeap.getIndex(task9), 2, "error testBuildMaxHeap2");
		assertEquals(overloadedHeap.getIndex(task8), 3, "error testBuildMaxHeap2");
		assertEquals(overloadedHeap.getIndex(task6), 4, "error testBuildMaxHeap2");
		assertEquals(overloadedHeap.getIndex(task7), 5, "error testBuildMaxHeap2");
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
}