# CS321-Project-2-Stardew-Valley-

* Joshua Boyle
* CS321 Section 3
* Fall 2022 

## Overview
This Program Implements a MaxHeap PriorityQueue to simulate
StarDew Valley.

## Reflection
I found this project extremely challenging. Converting pseudo-code
to a language like Java was hard. There were many times where I would
get error and veer off from the pseudo-code to fix it. Additionally,
I switched between several IDE's because the program kept breaking.
Lastly, debugging this project  was a nightmere until I learned 
about conditional breakpoints.

Something I did enjoy, that is not specific to this project, was
using version control. Having just completed the version control class,
I applied what I learned and used git branching often to test out different
ways of writing methods before settling on one and commiting it to the main.
Additionally, I used conditional breakpoints, JUnit testing, and other 
testing methods like isMaxHeap, to make debugging a lot easier. 

## Compiling and Using
To compile the main program, simply type:
```
$ javac MyLifeInStarDew.java
```
and then
```
$ java MyLifeInStarDew
```
to run the program.
The program requires the following command-line arguments to run
properly:
```
java MyLifeInStarDew 
<max-priority-level> <time-to-increment-priority> 
<total simulation-time in days> 
<task-generation-probability> [<seed>]
```
Where: 
<max-priority-level> - is the highest priority in the simulation

<time-to-increment-priority> - is the amount of days that must pass before
	an unused Task can be incremented again.

<total simulation-time in days> - The days/rounds the simulation will run

<task-generation-probability> - The probability that a task will
	be generated each day. 

Optional:
<seed> - A seed for the random generator.

## Results 

This section presents timing and other results of the experiments that
you were asked to perform as part of the project.

## Sources used
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

https://www.javatpoint.com/how-to-generate-random-number-in-java // Random

https://stackoverflow.com/questions/11840902/how-do-i-get-eclipse-to-show-the-entire-javadoc-for-a-class // get javadocs eclipse

https://github.com/tobeking01/heapifyUp-HeapifyDown/blob/main/GamesHeap.java // heapifyUp Inspiration

https://www.scaler.com/topics/tostring-method-in-java/ // toString Method

https://www.w3schools.com/java/java_try_catch.asp // tryCatch and Exceptions
----------
This README template is using Markdown. To preview your README output,
you can copy your file contents to a Markdown editor/previewer such
as [https://stackedit.io/editor](https://stackedit.io/editor).
