PURPOSE
This toolbox provides reusable data-structure implementations from the course.
You are not expected to rebuild the Binary Search Tree or Hash Table from scratch.

The assignment focuses on:
- how to apply an existing algorithmic solution to a concrete problem
- how the same structure behaves under different conditions
- how to collect evidence
- how to explain the evidence using algorithm and data-structure concepts

SUPPLIED AND READY TO USE
Node.java
BinarySearchTree.java
Entry.java
HashTable.java
AssignmentData.java
ToolboxSmokeTest.java

The supplied BST includes generic storage, recursive insert/search/delete,
in-order traversal, height, and a search-comparison counter.

The supplied HashTable includes generic key/value storage, separate chaining,
put/get/remove/containsKey, load factor, rehashing, a get-comparison counter,
and small observation helpers for the experiments.

STUDENT APPLICATION WORK
Book.java
    Complete compareTo(Book other) for the title index.

LibraryCatalogue.java
    Apply the supplied BST and HashTable together in one catalogue.

CatalogueAnalytics.java
    Apply Set and Map to the incoming batch problem.

EXPERIMENT FILES
Task1TitleIndexExperiment.java
Task2HashTableExperiment.java
Task3CatalogueExperiment.java
Task4AnalyticsExperiment.java
Task5PerformanceExperiment.java

These experiment files provide controlled situations. They are not complete
assignment answers. Predict first, run the experiment, record evidence, and explain.

RECOMMENDED WORKFLOW
1. Run ToolboxSmokeTest before changing anything.
2. Read the relevant supplied data-structure code before each task.
3. Write your prediction in the report.
4. Implement only the scenario-specific part requested.
5. Run the corresponding experiment.
6. Record evidence.
7. Explain what the evidence means.
8. Reflect on what you learned.

COMPILE
Windows:
  javac -d out src\*.java

macOS / Linux:
  javac -d out src/*.java

RUN THE TOOLBOX CHECK
  java -cp out ToolboxSmokeTest

RUN THE ASSIGNMENT EXPERIMENTS
  java -cp out Task1TitleIndexExperiment
  java -cp out Task2HashTableExperiment
  java -cp out Task3CatalogueExperiment
  java -cp out Task4AnalyticsExperiment
  java -cp out Task5PerformanceExperiment

IMPORTANT
Book.compareTo(), LibraryCatalogue, and CatalogueAnalytics intentionally contain
TODO sections. The project compiles, but those scenario-specific parts will throw
UnsupportedOperationException until you complete them.

Algorithm is more than code: use the program to produce evidence, then explain
what the structure and algorithm are doing.
