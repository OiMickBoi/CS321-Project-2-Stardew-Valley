import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTester {
    MaxHeap maxHeap;
    MaxHeap overloadedHeap;
    Task max;
    Task task1;
    Task task2;
    Task task3;
    Task task4;

    @BeforeEach
    void setUp() throws Exception {
        maxHeap = new MaxHeap();
        overloadedHeap = new MaxHeap(3);
        max = new Task(5, 1);
        task1 = new Task(3, 1);
        task2 = new Task(1, 1);
        task3 = new Task(4, 1);
        task4 = new Task(2, 1);
    }

    @Test
    void testExtractMax() {
        // extractMax()
        maxHeap.insert(max);
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(maxHeap.extractMax().getPriority(), max.getPriority(), "error testExtractMax");
    }

    @Test
    void testOverloadedExtractMax() {
        // extractMax() with overloaded constructor
        overloadedHeap.insert(max);
        overloadedHeap.insert(task1);
        overloadedHeap.insert(task2);
        assertEquals(overloadedHeap.extractMax().getPriority(), max.getPriority(), "error overloadedExtractMax");
    }

    @Test
    void testParent() {
        // parent() test
        overloadedHeap.insert(max);
        overloadedHeap.insert(task1);
        overloadedHeap.insert(task2);
        Task [] array = overloadedHeap.getHeapArray();
        assertEquals(array[maxHeap.parent(3)].getPriority(), max.getPriority(), "error testParent");
    }

    @Test
    void testLeft() {
    	// left() test
        overloadedHeap.insert(max);
        overloadedHeap.insert(task1);
        overloadedHeap.insert(task2);
        Task [] array = overloadedHeap.getHeapArray();
        assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testLeft");
    }

    @Test
    void testRight() {
    	// right() test
        overloadedHeap.insert(max);
        overloadedHeap.insert(task1);
        overloadedHeap.insert(task2);
        Task [] array = overloadedHeap.getHeapArray();
        assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testRight");
    }

    @Test
    void testInsert() {
    	// ) test
        maxHeap.insert(max);
        Task [] array = maxHeap.getHeapArray();
        assertEquals(array[1].getPriority(), max.getPriority(), "error testInsert");
    }

    @Test
    void testMax() {
    	// max() test
        maxHeap.insert(max);
        maxHeap.insert(task1);
        maxHeap.insert(task2);
        assertEquals(maxHeap.max().getPriority(), max.getPriority(), "error testMax");
    }

    @Test
    void testHeapify() {
    	// max() test
        overloadedHeap.insert(task2);
        overloadedHeap.insert(max);
        overloadedHeap.insert(task1);
        overloadedHeap.heapify(3);
        assertEquals(overloadedHeap.getIndex(max), 1, "error testHeapify");
        assertEquals(overloadedHeap.getIndex(task1), 3, "error testHeapify");
        assertEquals(overloadedHeap.getIndex(task2), 2, "error testHeapify");
    }
}