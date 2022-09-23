public class MaxHeapTest {
    public static void main(String[] args) {
        Task task1 = new Task(1, 2);
        Task task2 = new Task(2, 2);
        Task task3 = new Task(3, 2);
        Task task4 = new Task(4, 2);
        Task task5 = new Task(5, 2);
        Task task6 = new Task(6, 2);
        Task task7 = new Task(7, 2);
        Task task8 = new Task(8, 2);
        Task task9 = new Task(9, 2);
        Task task10 = new Task(10, 2);

        MaxHeap maxHeap = new MaxHeap();

        maxHeap.insert(task1, 1);
        maxHeap.insert(task2, 2);
        maxHeap.insert(task3, 3);
        maxHeap.insert(task4, 4);
        maxHeap.insert(task5, 5);
        maxHeap.insert(task6, 6);
        maxHeap.insert(task7, 7);
        maxHeap.insert(task8, 8);
        maxHeap.insert(task9, 9);
        maxHeap.insert(task10, 10);

        Task[] array = maxHeap.getHeapArray();
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i].getPriority());
        }
    }
}
