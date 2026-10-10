# Data Structure & Graph Performance Analyzer
CIT300 Graded Practical Assignment 2 - integrated Java console application.

## Description
A single menu-driven console application that demonstrates Array, Stack, Queue, Linked List, Linear/Binary Search and Graph (BFS/DFS) operations, and compares their performance using step counts and execution time.

## Team Members
| Student Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| Sumla (Team Leader) | 23DA2-0852 | Graph, main menu & system integration | - Implemented `Graph.java` (adjacency list, add vertex/edge, display, BFS, DFS)<br>- Built `Main.java` main menu with input validation and results log<br>- Integrated all modules, managed GitHub repository and merged pull requests |
| Nuska | 23DA2-0936 | Array & Searching | - Implemented `IntArray.java` (insert, delete, search, display, auto-resize)<br>- Implemented `Searching.java` (linear and binary search with step counting and timing) |
| Atheefa | 23DA2-0953 | Stack & Queue | - Implemented `Stack.java` (array-based push, pop, peek, display, underflow handling)<br>- Implemented `Queue.java` (linked-node enqueue, dequeue, peek, display, underflow handling) |
| Shamil | 23DA2-0521 | Linked List & Performance Comparison | - Implemented `LinkedList.java` (insert front/end, delete, search, display)<br>- Implemented `Performance.java` (linear vs binary search and BFS vs DFS comparison table) |

## Technologies
Java 17+ (console application), Git/GitHub.

## Project Structure
`Main.java` (menu) · `Node.java` · `IntArray.java` · `Searching.java` · `Stack.java` · `Queue.java` · `LinkedList.java` · `Graph.java` · `Performance.java`

## Features
- Array, Stack, Queue, Linked List and Graph operations with empty-structure handling
- Linear vs Binary search comparison (steps and time)
- Graph traversal using BFS (queue) and DFS (stack)
- Performance comparison table and "Display All Results"
- Input validation for all menu choices

## Time Complexity
Array insert O(1) amortised, delete O(n) · Stack/Queue ops O(1) · Linked list insert front O(1), others O(n) · Linear search O(n) · Binary search O(log n) · BFS/DFS O(V+E)

## How to Run
```
javac *.java
java Main
```
