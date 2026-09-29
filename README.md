# CIT300 — University Student & Campus Management System

A console-based Java application that manages student records and campus locations using core data structures: linked list, stack, queue, binary search tree, hash table, and graph.

## About the System

The system presents a single menu-driven interface (see `Main.java`) with the following features:

- **Student record management** — add, update, delete, and display student records (implemented with a custom linked list).
- **Service request handling** — student service requests are queued and processed in first-in, first-out order (implemented with a queue).
- **Recent action tracking** — every action performed is recorded and can be reviewed, most recent first (implemented with a stack).
- **Sorted student listing** — students can be listed in sorted order of their ID (implemented with a binary search tree).
- **Fast student search** — students can be looked up by ID in constant average time (implemented with a hash table using separate chaining).
- **Campus location mapping** — campus locations and the connections between them can be added, removed, and explored (implemented with a graph using an adjacency list).

## Data Structures Used

| Data Structure | Class | Purpose |
|---|---|---|
| Linked List | `StudentLinkedList` | Store and manage student records |
| Stack | `ActionStack` | Store recent actions (LIFO) |
| Queue | `ServiceQueue` | Process service requests in order (FIFO) |
| Binary Search Tree | `StudentBST` | Display students in sorted order |
| Hash Table | `StudentHashTable` | Fast student search by ID |
| Graph (adjacency list) | `CampusGraph` | Manage campus locations and connections |

## Project Structure

```
├── Main.java              # Menu-driven console interface
├── Student.java           # Student details model
├── StudentLinkedList.java # Linked list for student records
├── ActionStack.java       # Stack for recent actions
├── ServiceQueue.java      # Queue for service requests
├── StudentBST.java        # BST for sorted student display
├── StudentHashTable.java  # Hash table for fast search
└── CampusGraph.java       # Graph for campus locations
```

## How to Compile and Run

Requires Java (JDK 8 or later).

```bash
javac *.java
java Main
```

## Contributions

Each member worked on their own branch (`member-1` → `member-4`), with each branch building on the previous one.

| Member | Name | Index Number | Contribution | Branch |
|---|---|---|---|---|
| Member 1 | Fazil Farhan | 23da2-0772 | Student model, StudentLinkedList, Main menu (repository setup) | `member-1` |
| Member 2 | Amjath | 23da2-1038 | ActionStack, ServiceQueue | `member-2` |
| Member 3 | Hiyas | 23da2-0795 | StudentBST, StudentHashTable | `member-3` |
| Member 4 | Peros | 23da2-0844 | CampusGraph | `member-4` |
