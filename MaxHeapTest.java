import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxHeapTest {
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
        Task [] array = overloadedHeap.getHeapArray();
        overloadedHeap.insert(max, 1);
        overloadedHeap.insert(task1, 2);
        overloadedHeap.insert(task2, 3);
        assertEquals(array[maxHeap.parent(3)].getPriority(), max.getPriority(), "error testThree");
    }

    @Test
    void testFour() {
        Task [] array = overloadedHeap.getHeapArray();
        overloadedHeap.insert(max, 1);
        overloadedHeap.insert(task1, 2);
        overloadedHeap.insert(task2, 3);
        assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testFour");
    }

    @Test
    void testFive() {
        Task [] array = overloadedHeap.getHeapArray();
        overloadedHeap.insert(max, 1);
        overloadedHeap.insert(task1, 2);
        overloadedHeap.insert(task2, 3);
        assertEquals(array[maxHeap.left(1)].getPriority(), array[2].getPriority(), "error testFive");
    }

}
