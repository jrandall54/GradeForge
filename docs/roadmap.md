# GradeForge — Development Roadmap

> A Student Grade & Course Tracker built incrementally to cover every CS1 and CS2 concept.
> Each Phase is a major milestone. Each Commit is an atomic unit of work with its own PAW loop.

---

## Phase 0: Foundation — Environment & Java Basics Review

**Goal**: Verify the development environment works and review fundamental Java concepts (variables, types, operators, control flow, basic I/O) by building the simplest possible version of the app — a single-class GPA calculator.

**CS Topics Covered**: Primitive types, type casting, `Scanner` input, `System.out` output, arithmetic operators, `if/else`, `switch`, `for` loops, `while` loops, `do-while` loops, `String` basics.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 0.1 | **Verify Gradle & JUnit**: Run `./gradlew build` and `./gradlew test`. Confirm the project compiles and the smoke test passes. | Build tools, project structure, classpath |
| 0.2 | **Hello GradeForge — Console Output**: Modify `App.java` to print a formatted welcome banner with the app name and version. | `System.out.println`, `System.out.printf`, escape characters, `String` concatenation |
| 0.3 | **User Input with Scanner**: Prompt the user to enter their name and a course name. Echo back a formatted greeting. | `Scanner`, `nextLine()`, `nextInt()`, variable declaration, `String` methods |
| 0.4 | **Simple GPA Calculator (Arithmetic)**: Ask the user for a letter grade, convert it to grade points, and display the GPA. | `double` vs `int`, type casting, arithmetic operators, `switch` statement |
| 0.5 | **Multi-Course GPA with Loops**: Extend the calculator to accept multiple courses using a loop. Calculate cumulative GPA. | `for` loop, `while` loop, `do-while` loop, accumulators, sentinel values |
| 0.6 | **Input Validation**: Add validation — reject invalid grades, handle non-numeric input gracefully. | `if/else` chains, `try/catch` (introduction), `String.equalsIgnoreCase()` |

---

## Phase 1: Object-Oriented Foundations — The Core Domain Model

**Goal**: Introduce OOP by replacing the monolithic calculator with well-designed classes. The student learns to model real-world entities as objects with state and behavior.

**CS Topics Covered**: Classes & objects, instance variables, constructors (default, parameterized, overloaded), `this` keyword, encapsulation (`private` fields, getters/setters), `toString()`, `static` members, method overloading, reference vs. value semantics.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 1.1 | **Create the `Course` class**: Fields for name, credit hours, and letter grade. Parameterized constructor. Getters. | Class design, fields, constructor, `this` keyword, access modifiers |
| 1.2 | **Add `toString()` to `Course`**: Override `toString()` for clean console display. | `@Override`, `String.format()`, object representation |
| 1.3 | **Create the `Student` class**: Fields for name and student ID. Constructor with validation. | Multi-class design, validation in constructors |
| 1.4 | **Grade point conversion as a method**: Add `getGradePoints()` to `Course`. Replace the `switch` from Phase 0. | Instance methods, return values, encapsulation of logic |
| 1.5 | **Static utility method — `GradeUtils`**: Create a utility class with `static` methods for grade conversion and validation. | `static` vs instance, utility class pattern, when to use `static` |
| 1.6 | **Reference vs. Value semantics demo**: Create a test that demonstrates passing objects vs. primitives to methods. | Stack vs heap, reference aliasing, `==` vs `.equals()` |
| 1.7 | **Write JUnit tests for `Course` and `Student`**: Test constructors, getters, `toString()`, and edge cases. | `@Test`, `assertEquals`, `assertThrows`, `assertNotNull`, test method naming |

---

## Phase 2: Collections & Data Management — Arrays to ArrayLists

**Goal**: Give the `Student` a collection of courses. Transition from raw arrays to `ArrayList`. Build a functional CLI menu system.

**CS Topics Covered**: 1D arrays, 2D arrays, array traversal, `ArrayList<>`, generics introduction (`<Course>`), enhanced `for` loop, `Iterator`, wrapper classes (`Integer`, `Double`), autoboxing.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 2.1 | **Store courses in a 1D array**: Give `Student` a fixed-size `Course[]` array. Implement `addCourse()` and `listCourses()`. | Array declaration, indexing, bounds checking, array traversal |
| 2.2 | **2D array — Grade matrix**: Create a grade report that displays courses vs. semesters in a 2D table. | 2D array initialization, nested `for` loops, row-major traversal |
| 2.3 | **Migrate to `ArrayList<Course>`**: Replace the fixed array with a dynamic `ArrayList`. Discuss why. | `ArrayList` API, generics syntax `<T>`, `.add()`, `.get()`, `.size()`, `.remove()` |
| 2.4 | **Enhanced `for` loop & iteration**: Refactor all array traversals to use the enhanced `for` loop. Discuss `Iterator` basics. | Enhanced `for`, `Iterable` interface, `Iterator` pattern |
| 2.5 | **Wrapper classes & autoboxing**: Use `ArrayList<Double>` to store GPA history. Demonstrate autoboxing/unboxing. | `Integer`, `Double`, autoboxing, `null` handling for wrappers |
| 2.6 | **Build the CLI menu system**: Create an interactive menu loop using `Scanner` — add course, view courses, calculate GPA, quit. | Application loop pattern, `switch` with user input, method decomposition |
| 2.7 | **JUnit tests for collections logic**: Test add, remove, list operations. Test GPA calculation with empty/full lists. | Testing collections, boundary conditions, empty list edge cases |

---

## Phase 3: Inheritance & Polymorphism — Assignment Type Hierarchy

**Goal**: Introduce inheritance by modeling different types of assignments (Homework, Exam, Project, Lab). Use abstract classes and interfaces to create flexible grading strategies.

**CS Topics Covered**: Inheritance (`extends`), `super` keyword, method overriding (`@Override`), abstract classes, interfaces, polymorphism (dynamic dispatch), `instanceof`, casting, the `Comparable` interface, `Comparator`.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 3.1 | **Create abstract `Assignment` class**: Common fields (name, points earned, points possible, weight). Abstract method `getCategoryName()`. | `abstract` keyword, abstract methods, concrete vs. abstract classes |
| 3.2 | **Concrete subclasses — `Homework`, `Exam`, `Lab`, `Project`**: Each implements `getCategoryName()` and optionally adds unique fields (e.g., `Exam` has `isFinal`). | `extends`, `super()` constructor call, method overriding |
| 3.3 | **Polymorphism in action**: Store mixed assignment types in `ArrayList<Assignment>`. Iterate and call `getCategoryName()` — observe dynamic dispatch. | Polymorphic references, runtime binding, `ArrayList<ParentType>` |
| 3.4 | **Create `Gradable` interface**: Define `getPercentageScore()` and `getLetterGrade()`. Have `Assignment` implement it. | `interface` keyword, `implements`, multiple inheritance of behavior |
| 3.5 | **Create `Exportable` interface**: Define `toCSVRow()` for data export. Implement on `Assignment`, `Course`, and `Student`. | Interface as a contract, implementing multiple interfaces |
| 3.6 | **Weighted grade calculation**: Implement `calculateWeightedAverage()` in `Course` using assignment weights and polymorphic calls. | Strategy-like computation, leveraging polymorphism for flexible grading |
| 3.7 | **`Comparable` & `Comparator` — Sorting assignments**: Implement `Comparable<Assignment>` for natural ordering (by score). Create `Comparator` instances for sorting by name, category, or weight. | `Comparable`, `compareTo()`, `Comparator`, `Collections.sort()`, lambda introduction |
| 3.8 | **`instanceof`, casting, and type safety**: Demonstrate safe downcasting to access subclass-specific fields (e.g., `Exam.isFinal`). | `instanceof`, type casting, why to avoid excessive casting |
| 3.9 | **JUnit tests for inheritance hierarchy**: Test polymorphic behavior, weighted calculations, sorting, and interface contracts. | Testing polymorphism, testing interface implementations |

---

## Phase 4: Data Structures from Scratch — Custom Implementations

**Goal**: Build fundamental data structures by hand to understand how they work internally. Each structure is motivated by a real feature need in GradeForge.

**CS Topics Covered**: Nodes and references, singly linked list, doubly linked list, stack (LIFO), queue (FIFO), binary search tree, hash map, generics (`<T>`), `Iterable<T>` implementation, Big-O introduction.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 4.1 | **Generic `Node<T>` class**: Create a generic node that holds data and a reference to the next node. | Generics `<T>`, self-referential structures, `null` as terminal |
| 4.2 | **Singly linked list — `GFLinkedList<T>`**: Implement `addFirst`, `addLast`, `removeFirst`, `size`, `contains`, `toString`. | Pointer/reference manipulation, head tracking, traversal |
| 4.3 | **Make `GFLinkedList` iterable**: Implement `Iterable<T>` and create an inner `Iterator` class. Use it with enhanced `for` loops. | `Iterable<T>`, `Iterator<T>`, `hasNext()`, `next()`, inner classes |
| 4.4 | **Doubly linked list enhancements**: Add `prev` references, `addLast` in O(1) with a tail pointer, and `removeLast`. | Doubly linked nodes, tail pointer, bidirectional traversal |
| 4.5 | **Stack — `GFStack<T>` (Undo history)**: Build a stack using your linked list. Use it to implement an undo feature for grade edits in the CLI. | LIFO, `push`, `pop`, `peek`, `isEmpty`, real-world stack application |
| 4.6 | **Queue — `GFQueue<T>` (Notification system)**: Build a queue for pending notifications (e.g., "Assignment due soon"). | FIFO, `enqueue`, `dequeue`, `peek`, real-world queue application |
| 4.7 | **Binary search tree — `GFTreeMap<K, V>`**: Build a BST that stores course grade entries sorted by course name. Implement `insert`, `search`, `inOrderTraversal`. | BST property, recursive insert/search, tree traversal (in-order, pre-order, post-order) |
| 4.8 | **BST deletion & balancing discussion**: Implement `delete` (handling 0, 1, 2 children). Discuss why unbalanced BSTs degrade to O(N) and mention AVL/Red-Black trees conceptually. | Node deletion cases, successor finding, balanced vs. unbalanced trees |
| 4.9 | **Hash map — `GFHashMap<K, V>` (Course registry)**: Build a hash map with separate chaining. Use it as a fast course-name-to-course lookup. | Hash functions, `hashCode()`, bucket arrays, collision handling, load factor |
| 4.10 | **`equals` and `hashCode` contract**: Implement proper `equals()` and `hashCode()` on `Course`. Demonstrate what breaks when they're inconsistent. | Object equality contract, why both must be overridden together |
| 4.11 | **JUnit tests for all data structures**: Comprehensive tests — empty structures, single element, many elements, edge cases, iteration. | Testing data structures, boundary testing, property-based thinking |

---

## Phase 5: Algorithms & Analysis — Sorting, Searching, Big-O

**Goal**: Implement classic sorting and searching algorithms. Learn to analyze and compare algorithmic efficiency using Big-O notation.

**CS Topics Covered**: Big-O notation (O(1), O(log N), O(N), O(N log N), O(N²)), bubble sort, selection sort, insertion sort, merge sort, quick sort, linear search, binary search, recursion (base case, recursive case, call stack), backtracking.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 5.1 | **Big-O notation fundamentals**: Conceptual commit — no new code. Study loop analysis, nested loop analysis, and growth rate comparisons through the PAW quiz stages. | Time complexity, space complexity, worst/average/best case, growth rate hierarchy |
| 5.2 | **Linear search**: Implement `linearSearch()` to find an assignment by name. Analyze as O(N). | Sequential scan, early return, O(N) analysis |
| 5.3 | **Binary search**: Implement `binarySearch()` on a sorted assignment list. Analyze as O(log N). Contrast with linear search. | Sorted prerequisite, divide-and-conquer concept, O(log N) analysis, `Comparable` use |
| 5.4 | **Bubble sort**: Implement `bubbleSort()` for assignments. Analyze as O(N²). Visualize passes with console output. | Swapping, nested loops, optimization with early termination flag |
| 5.5 | **Selection sort**: Implement `selectionSort()`. Compare behavior and performance with bubble sort. | Finding minimum, reducing unsorted region, in-place sorting |
| 5.6 | **Insertion sort**: Implement `insertionSort()`. Discuss why it performs well on nearly-sorted data. | Shifting elements, best-case O(N) for sorted input, adaptive algorithms |
| 5.7 | **Merge sort (recursion deep dive)**: Implement `mergeSort()`. This is the primary recursion lesson — trace the call stack, understand base case vs. recursive case. | Recursion, base case, recursive splitting, merging, O(N log N), call stack visualization |
| 5.8 | **Quick sort**: Implement `quickSort()` with Lomuto partition. Analyze average O(N log N) vs. worst-case O(N²). | Pivot selection, partitioning, in-place sorting, worst-case analysis |
| 5.9 | **Algorithm comparison report**: Create a `SortBenchmark` class that times all five sorts on varying input sizes and prints a comparison table. | Empirical analysis, `System.nanoTime()`, confirming theoretical complexity |
| 5.10 | **Recursion practice — GPA scenarios**: Implement recursive methods: factorial (warm-up), recursive list sum, recursive max-grade finder, and a simple backtracking problem (e.g., find all course combinations that total a target credit count). | Recursive thinking, helper methods, backtracking with pruning |
| 5.11 | **JUnit tests for all algorithms**: Test sorts with empty, single, sorted, reversed, and random arrays. Test search with present/absent targets. | Algorithm correctness verification, edge case testing |

---

## Phase 6: File I/O & Persistence — Save/Load System

**Goal**: Add the ability to save and load all student data to disk. Learn file handling, exception management, and data serialization.

**CS Topics Covered**: `File`, `FileReader`/`FileWriter`, `BufferedReader`/`BufferedWriter`, `try-with-resources`, checked vs. unchecked exceptions, custom exceptions, CSV parsing, basic JSON concepts, `StringBuilder`.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 6.1 | **Exception handling deep dive**: Introduce `try/catch/finally`, checked vs. unchecked exceptions, and the exception hierarchy (`Throwable` → `Exception` → `RuntimeException`). | Exception types, `throws` clause, `try/catch/finally`, stack traces |
| 6.2 | **Custom exceptions**: Create `InvalidGradeException` and `CourseNotFoundException`. Use them throughout existing code. | Extending `Exception`, meaningful error messages, when to create custom exceptions |
| 6.3 | **Writing to files — CSV export**: Implement `exportToCSV()` using `BufferedWriter`. Save all courses and assignments for a student. | `FileWriter`, `BufferedWriter`, `try-with-resources`, file paths |
| 6.4 | **Reading from files — CSV import**: Implement `importFromCSV()` using `BufferedReader`. Parse lines, split by delimiter, reconstruct objects. | `FileReader`, `BufferedReader`, `String.split()`, `StringBuilder`, parsing |
| 6.5 | **JSON concepts (read-only library)**: Use a lightweight JSON library (e.g., Gson) to serialize/deserialize `Student` objects. Compare JSON vs. CSV. | JSON structure, serialization, deserialization, library dependencies in Gradle |
| 6.6 | **Robust error handling for I/O**: Handle missing files, corrupt data, permission errors. Create a `DataManager` class that centralizes all persistence logic. | Defensive programming, error recovery, separation of concerns |
| 6.7 | **Auto-save and load on startup**: Modify `App.java` to automatically load saved data on startup and save on exit. | Application lifecycle, graceful shutdown, user-friendly error messages |
| 6.8 | **JUnit tests for I/O**: Test export/import round-trips. Test error handling with corrupt or missing files. Use temporary files in tests. | `@TempDir`, testing I/O, testing exception paths |

---

## Phase 7: Advanced OOP & Design Patterns

**Goal**: Deepen OOP mastery with enums, records, sealed classes, and introductory design patterns. Refactor existing code to apply professional patterns.

**CS Topics Covered**: Enums (with fields and methods), records, sealed classes, `Optional`, Strategy pattern, Observer pattern, Factory pattern, command pattern (via undo system refactor), deeper lambda/functional interface exposure.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 7.1 | **Enums — `LetterGrade` and `AssignmentCategory`**: Replace string-based grade and category handling with type-safe enums. Add fields and methods to enums. | `enum` keyword, enum constructors, enum methods, type safety |
| 7.2 | **Records — `GradeEntry` and `Semester`**: Create immutable data carriers using Java records. Compare with traditional classes. | `record` keyword, immutability, auto-generated methods, when to use records |
| 7.3 | **Sealed classes — `GradingPolicy`**: Create a sealed hierarchy for different grading policies (Standard, PassFail, Weighted). | `sealed`, `permits`, exhaustive pattern matching, controlled hierarchies |
| 7.4 | **`Optional<T>` — eliminating null**: Refactor methods that return `null` to return `Optional`. Demonstrate `ifPresent`, `orElse`, `map`. | `Optional` API, null safety, functional chaining |
| 7.5 | **Strategy pattern — Grading strategies**: Refactor weighted grading to use interchangeable strategy objects (e.g., `EqualWeightStrategy`, `CategoryWeightStrategy`). | Strategy pattern, interface-based polymorphism, runtime behavior swapping |
| 7.6 | **Observer pattern — Grade change notifications**: Implement a listener system that fires events when grades change (e.g., GPA alert). | Observer/Listener pattern, decoupling, event-driven design |
| 7.7 | **Factory pattern — Assignment creation**: Create an `AssignmentFactory` that produces the correct subclass based on category. | Factory method, centralized object creation, reducing client coupling |
| 7.8 | **Lambda expressions & functional interfaces**: Refactor `Comparator` usages and the Observer pattern to use lambdas. Introduce `Predicate`, `Function`, `Consumer`. | Lambda syntax, functional interfaces, `@FunctionalInterface`, method references |
| 7.9 | **JUnit tests for patterns and refactors**: Test strategy interchangeability, observer notifications, factory output, and enum behavior. | Testing design patterns, behavior verification |

---

## Phase 8: GUI — JavaFX Desktop Application

**Goal**: Transform GradeForge from a CLI application into a polished JavaFX desktop GUI. Learn event-driven programming, the MVC pattern, and UI development.

**CS Topics Covered**: JavaFX fundamentals (`Stage`, `Scene`, `Pane`), FXML layouts, CSS styling, event handling, MVC architecture, data binding, `ObservableList`, `TableView`, `BarChart`/`PieChart`.

| Commit | Description | Key Concepts |
| :--- | :--- | :--- |
| 8.1 | **JavaFX setup & "Hello GradeForge" window**: Add JavaFX dependencies to Gradle. Create a basic `Stage` with a `Label`. | JavaFX application lifecycle, `Stage`, `Scene`, `start()` method |
| 8.2 | **FXML layout — Dashboard view**: Design the main dashboard layout using FXML. Display student name and overall GPA. | FXML syntax, `FXMLLoader`, controller binding, separation of layout and logic |
| 8.3 | **CSS styling**: Style the dashboard with a custom CSS file — colors, fonts, spacing. | JavaFX CSS, `getStylesheets()`, selectors, design polish |
| 8.4 | **Course list view with `TableView`**: Display all courses in a sortable, scrollable table. | `TableView`, `TableColumn`, `ObservableList`, cell value factories |
| 8.5 | **Add/Edit course dialog**: Create modal dialogs for adding and editing courses. | `Dialog`, `TextInputDialog`, event handling, `setOnAction()` |
| 8.6 | **Assignment management view**: CRUD interface for assignments within a selected course. | Nested navigation, master-detail pattern, `ListView` |
| 8.7 | **Grade charts — `BarChart` and `PieChart`**: Visualize grade distribution and GPA trends over semesters. | `BarChart`, `PieChart`, `XYChart.Series`, data visualization |
| 8.8 | **MVC refactor**: Separate all GUI code into Model, View (FXML), and Controller layers. Connect to existing domain classes. | MVC pattern, controller responsibilities, model-view binding |
| 8.9 | **Connect persistence**: Wire the File I/O system (Phase 6) to the GUI — save on close, load on open. | Integration of backend and frontend, application lifecycle events |
| 8.10 | **Polish & packaging**: Final UI polish, error dialogs, keyboard shortcuts. Discuss JAR packaging for distribution. | Application distribution, user experience, final integration testing |

---

## Summary: Topic Coverage Matrix

This matrix confirms that every major CS1/CS2 topic is addressed in the roadmap:

| Topic | Phase(s) |
| :--- | :--- |
| Variables, types, casting | 0 |
| Arithmetic operators | 0 |
| `String` manipulation | 0, 1, 6 |
| `Scanner` / console I/O | 0, 2 |
| Conditionals (`if/else`, `switch`) | 0, 1, 2 |
| Loops (`for`, `while`, `do-while`, enhanced `for`) | 0, 2 |
| Methods & overloading | 1 |
| Scope & `this` keyword | 1 |
| Classes, objects, constructors | 1 |
| Encapsulation & access modifiers | 1 |
| `static` vs instance | 1 |
| `toString()`, `equals()`, `hashCode()` | 1, 4 |
| Reference vs value semantics | 1 |
| 1D & 2D arrays | 2 |
| `ArrayList` & generics introduction | 2 |
| Wrapper classes & autoboxing | 2 |
| `Iterator` & `Iterable` | 2, 4 |
| Inheritance (`extends`, `super`) | 3 |
| Abstract classes | 3 |
| Interfaces (`implements`) | 3 |
| Polymorphism & dynamic dispatch | 3 |
| `instanceof` & casting | 3 |
| `Comparable` & `Comparator` | 3 |
| Generics (`<T>`) | 4 |
| Linked lists (singly & doubly) | 4 |
| Stacks (LIFO) | 4 |
| Queues (FIFO) | 4 |
| Binary search trees | 4 |
| Hash maps | 4 |
| Big-O complexity analysis | 5 |
| Linear & binary search | 5 |
| Bubble, selection, insertion sort | 5 |
| Merge sort & quick sort | 5 |
| Recursion & backtracking | 5 |
| Exception handling (checked/unchecked) | 6 |
| Custom exceptions | 6 |
| File I/O (`BufferedReader`/`Writer`) | 6 |
| `try-with-resources` | 6 |
| `StringBuilder` | 6 |
| Enums (with fields & methods) | 7 |
| Records | 7 |
| Sealed classes | 7 |
| `Optional<T>` | 7 |
| Design patterns (Strategy, Observer, Factory) | 7 |
| Lambda expressions & functional interfaces | 7 |
| JavaFX GUI fundamentals | 8 |
| FXML & CSS styling | 8 |
| Event-driven programming | 8 |
| MVC architecture | 8 |
| Data visualization (charts) | 8 |
| JUnit 5 testing | 0–8 (every phase) |
| Git version control | 0–8 (every phase) |

---

*GradeForge Roadmap v1.0.0*
*Framework: Pedagogical Agentic Workflow (PAW) v1.0.0*
