public class MaxHeapTest {
    public static void test_Insert() {
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
        for (int i = 1; i <= 10; i++) {
            System.out.println(array[i].getPriority());
        }
    }

//    public static void test_BuildMaxHeap() {
//        Task task1 = new Task(1, 2);
//        Task task2 = new Task(2, 2);
//        Task task3 = new Task(3, 2);
//        Task task4 = new Task(4, 2);
//        Task task5 = new Task(5, 2);
//        Task task6 = new Task(6, 2);
//        Task task7 = new Task(7, 2);
//        Task task8 = new Task(8, 2);
//        Task task9 = new Task(9, 2);
//        Task task10 = new Task(10, 2);
//
//
//        MaxHeap maxHeap = new MaxHeap();
//        maxHeap.insert(task1, 1);
//        maxHeap.insert(task2, 2);
//        maxHeap.insert(task3, 3);
//        maxHeap.insert(task4, 4);
//        maxHeap.insert(task5, 5);
//        maxHeap.insert(task6, 6);
//        maxHeap.insert(task7, 7);
//        maxHeap.insert(task8, 8);
//        maxHeap.insert(task9, 9);
//        maxHeap.insert(task10, 10);
//
//        Task[] before = maxHeap.getHeapArray();
//         System.out.println("Before Build Heap");
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(before[i].getPriority());
//        }
//
//        maxHeap.buildMaxHeap(10);
//
//        Task[] after = maxHeap.getHeapArray();
//        System.out.println("After Build Heap");
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(after[i].getPriority());
//            }
//        }
//   }
   public static void test_max(MaxHeap heap) {
        if (heap.max().getPriority() == 10) {
            System.out.println("test_max passes");
        }
   }

    public static void main(String[] args) {
        int passes = 0;
        int numOfTasks = 10;

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
        maxHeap.insert(task4, 1);
        maxHeap.insert(task2, 2);
        maxHeap.insert(task10, 3);
        maxHeap.insert(task3, 4);
        maxHeap.insert(task5, 5);
        maxHeap.insert(task1, 6);
        maxHeap.insert(task6, 7);
        maxHeap.insert(task9, 8);
        maxHeap.insert(task7, 9);
        maxHeap.insert(task8, 10);



//        test_Insert();
//        test_BuildMaxHeap();
        maxHeap.buildMaxHeap(10);
        test_max(maxHeap);


    }
}

