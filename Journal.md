# Project 2 Stardew Valley
## 09-20-2022 12:24
Started stardew valley project
### Task.java
implemented the Task class using the interface file.

### MaxHeap.java
Getting started with max heap.
Currently need to find how to switch two objects in an index. 
This is for the maxHeapify method.

## 09-21-2022
11:16
need to find what values for constructor

TODO Fix getTaskType()

11:47
TODO I have been using array.length to determine the size
of the heap, but this is the size of the array not the heap.
I need to change all the a.length to heapsize
and make getters and setters for heapsize.

14:58
I completed the above todo.
16:06
made a new branch where i have the array built into MaxHeap class
I changed all the methods so instead of passing in parameter array A
of type Task it now how it built it.

## 09-22-2022
10:09
Find out if MaxHeap's getIndex, increaseKey, and max should use try catch
         
Read insert pseudocode to find what the following means:
    // TODO map x to index heap-size in the array
Read increase pseudocde to find what follwing means:
    // priority queue objects to array indices

## 09-29-2022
2:26 pm
need to do more testing on BuildMaxHeap. I have done three levels on the left
but not the right.

Also I should have more Null cases. I mean where I try the opposite
of how my test cases should work. That is the true way to test something

TODO: iron out the javaDocs they are still inconsistent.

I switched the project to Eclipse IDE. 

## Sources to cite:
https://www.w3schools.com/java/java_constructors.asp // Java Constructors

https://www.geeksforgeeks.org/final-keyword-in-java/ // Final Keyword

https://www.tutorialspoint.com/How-to-pass-Arrays-to-Methods-in-Java // Pass arrays

https://www.w3schools.com/java/java_interface.asp // Java Interface

https://www.w3schools.com/java/java_encapsulation.asp // Encapsulation

https://stackoverflow.com/questions/872310/javascript-swap-array-elements // Swap elements in a array

https://www.geeksforgeeks.org/arrays-in-java/ // array declarations

https://en.wikipedia.org/wiki/Heap_(data_structure) // info on Heap

https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html // comparable interface

https://www.javatpoint.com/Comparable-interface-in-collection-framework

https://stackoverflow.com/questions/21263607/can-a-normal-class-implement-multiple-interfaces // multiple interfaces

https://www.geeksforgeeks.org/constructor-chaining-java-examples/ // constructors

https://www.w3schools.com/java/java_encapsulation.asp // getters and setters.

https://stackoverflow.com/questions/12952024/how-to-implement-infinity-in-java // infinity

https://www.tutorialkart.com/java/java-array/java-check-if-array-is-empty/ // check if array is empty

https://www.w3schools.com/java/java_try_catch.asp // try catch

https://www.geeksforgeeks.org/null-pointer-exception-in-java/

https://java2blog.com/junit-asserttrue/ // asserttrue junit

https://www.tutorialkart.com/java/java-array/java-check-if-array-is-empty/ // empty array