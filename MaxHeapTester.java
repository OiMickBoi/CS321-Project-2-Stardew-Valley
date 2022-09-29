import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxHeapTester {
    MaxHeap maxHeap;
    MaxHeap overloadedHeap;
    Task max;
    Task task1;
    Task task2;

    @BeforeEach
    void setUp() throws Exception {
        maxHeap = new MaxHeap();
        overloadedHeap = new MaxHeap(3);
        max = new Task(5, 1);
        task1 = new Task(3, 1);
        task2 = new Task(1, 1);
    }

    @Test
    void testOne() {
        // extractMax()
        maxHeap.insert(max, 1);
        maxHeap.insert(task1, 2);
        maxHeap.insert(task2, 3);
        assertEquals(maxHeap.extractMax().getPriority(), max.getPriority(), "error testOne");
    }

    @Test
    void testTwo() {
        // extractMax() with overloaded constructor
        overloadedHeap.insert(max, 1);
        overloadedHeap.insert(task1, 2);
        overloadedHeap.insert(task2, 3);
        assertEquals(overloadedHeap.extractMax().getPriority(), max.getPriority(), "error testTwo");
    }

    @Test
    void testThree() {
        // parent() test
        overloadedHeap.insert(max, 1);
        overloadedHeap.insert(task1, 2);
        overloadedHeap.insert(task2, 3);
        assertEquals(overloadedHeap.getParent(3), max.getPriority(), "error testFour");
    }


}