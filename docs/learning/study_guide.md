# GradeForge — Study Guide

> This is your **living study guide** — a personalized textbook built collaboratively between you and your PAW tutor as you progress through GradeForge.

---

## How This Document Works

As you complete each PAW loop (Phase, Commit, or Step), the AI tutor will append entries here recording:

- **Concepts taught** during Overview stages
- **Quiz questions and your answers** from Pre-Quiz and Post-Quiz stages
- **Design decisions** made during Implementation stages
- **Post-Summary takeaways** connecting code back to theory
- **`/explain` definitions** requested during sessions
- **`/skip` logs** noting any items you bypassed for future review

Entries are organized chronologically by Phase and Commit. You can review this document at any time to revisit lessons, study for exams, or refresh your memory before starting a new session.

---

## Phase 0: Foundation — Environment & Java Basics Review

### Commit 0.1 — Verify Gradle & JUnit

#### Concepts Taught
- **Gradle Project Structure**: Production source code resides in `src/main/java/`, and JUnit test code resides in `src/test/java/`. The directory hierarchy matches package names.
- **Gradle Wrapper**: The `gradlew` script downloads and executes a project-specific version of Gradle to guarantee build reproducibility across developer environments.
- **Build and Test Tasks**: `./gradlew build` runs compilation, tests, and packages the application. `./gradlew test` executes JUnit tests specifically.

#### Pre-Quiz
- **Question 1**: Under the standard Gradle directory structure, if we have a production class named `gradeforge.App`, where would its corresponding JUnit test class `gradeforge.AppTest` be located?
  - *Student Answer*: `src/test/java/gradeforge/AppTest.java` (Correct)
- **Question 2**: If we need to add a new external library (for example, a JSON library like Gson) to the project, which file in the project directory must we edit to configure this dependency?
  - *Student Answer*: `build.gradle` (Correct)

#### Post-Quiz
- **Question 1**: If a single unit test fails, does Gradle complete the `./gradlew build` task and generate the final packaged `.jar` file? Why or why not?
  - *Student Answer*: It will not complete the build or generate a packaged `.jar` to prevent bad code from being packaged. (Correct)
- **Question 2**: Locate the generated test reports in your file system. What is the path to the HTML test report file that you can open in a web browser to review test status?
  - *Student Answer*: `build/reports/tests/test/index.html` (Correct)

### Commit 0.2 — Hello GradeForge — Console Output

#### Concepts Taught
- **Java Console Output Methods**: Diff between `print()` (keeps cursor on same line), `println()` (adds a newline), and `printf()` (formatted printing).
- **Format Specifiers**: Placeholders like `%s` (String), `%d` (integer), `%f` (floating-point), and `%n` (system-appropriate newline). Precision control such as `%.1f` outputs a float/double to one decimal place.
- **Escape Characters**: Characters like `\n` (newline), `\t` (tab), `\"` (double quote), and `\\` (backslash) within string literals.
- **String Concatenation**: Combining values using the overloaded `+` operator.

#### Pre-Quiz
- **Question 1**: What is the difference in console cursor behavior after executing `System.out.print("Grade");` versus `System.out.println("Forge");`?
  - *Student Answer*: `println` adds a newline character after it executes so the cursor would be on the next line and `print` leaves the cursor right after the end of the print statement. (Correct)
- **Question 2**: Write a single line of Java code using `System.out.printf` to print a string variable named `appName` and a double variable named `version` in the format: `App: [appName] | Version: [version]` (followed by a newline).
  - *Student Answer*: `System.out.printf("App: [%s] | Version: [%.2f]%n", appName, version);` (Correct)

#### Post-Quiz
- **Question 1**: In the `printf` statement, we used `%.1f`. What does the `.1` specify, and how would the output change if we used `%f` instead?
  - *Student Answer*: `.1` specifies a float/double shown to the first decimal place. By default, `%f` prints with exactly six decimal places (e.g., `1.000000`). (Correct)
- **Question 2**: When you run `./gradlew build`, Gradle executes a task that runs the main method of our class and captures its stdout inside the test suite. If we want to execute our program's main class directly from the command line after compilation, what is the standard Java command to do so?
  - *Student Answer*: Running compiled class files requires compiling to the classpath (`-cp`) and running with the fully qualified class name: `java -cp build/classes/java/main gradeforge.App` (Alternatively, running the single source file directly: `java src/main/java/gradeforge/App.java`). (Correct)

### Commit 0.3 — User Input with Scanner

#### Concepts Taught
- **Reading Input with Scanner**: Using `java.util.Scanner` to read tokens and lines from the standard input stream `System.in`.
- **Parsing Tokens vs. Lines**: Using `next()` for single words, `nextLine()` for complete sentences/lines, and numeric methods like `nextInt()` and `nextDouble()`.
- **The Newline Buffer Issue**: Handling the remaining `\n` left in the input stream after reading primitive values before reading a subsequent line.
- **Resource Management**: Closing standard resources such as scanners, while noting that closing `System.in` prevents future input reading.
- **Mocking standard streams in Unit Tests**: Using `System.setIn` with a `ByteArrayInputStream` to programmatically simulate keyboard input in automated tests.

#### Pre-Quiz
- **Question 1**: What input stream does `System.in` represent, and what is the syntax to create a new `Scanner` instance that reads from it?
  - *Student Answer*: `System.in` represents the standard `InputStream`. The syntax to create a new scanner is: `Scanner sc = new Scanner(System.in);` (Correct)
- **Question 2**: If you execute a numeric scanner call followed by a line scanner call without consuming the trailing newline, what happens?
  - *Student Answer*: The newline character left in the input buffer by the numeric read is immediately consumed by the subsequent line read, returning an empty string. (Correct)

#### Post-Quiz
- **Question 1**: What package is the `Scanner` class a member of, and what is the syntax used to make it accessible to our class?
  - *Student Answer*: It is in the `java.util` package, and we write `import java.util.Scanner;` to make it accessible. (Correct)
- **Question 2**: If we execute `scanner.close()`, what happens to the underlying standard input stream `System.in`, and can we create a new `Scanner(System.in)` to read more inputs later in the program?
  - *Student Answer*: Closing the scanner terminates/closes the underlying `System.in` stream. We cannot create a new scanner to read from `System.in` again in the same program lifecycle. (Correct)

### Commit 0.4 — Simple GPA Calculator (Arithmetic)

#### Concepts Taught
- **Data Types**: Diff between `int` (32-bit whole numbers) and `double` (64-bit precision floating-point numbers).
- **Arithmetic Division**: Handling truncation in integer division (`int / int`) versus floating-point division (`double / int` or `int / double` or casting).
- **Type Casting**: Widening conversions (automatic) and narrowing conversions (explicit using casting operator).
- **Control Flow**: Using traditional `switch` statements with `break` to avoid fall-through, and configuring `default` for invalid inputs.
- **Normalizing Input**: Converting inputs to uppercase using `.toUpperCase()` to simplify case checks and comply with the DRY principle.

#### Pre-Quiz
- **Question 1**: In Java, what does the expression `11 / 4` evaluate to? What are two different ways you can write this expression to evaluate to `2.75`?
  - *Student Answer*: `2`. Ways to get `2.75`: `(double) 11 / 4` or `11 / (double) 4`. (Correct)
- **Question 2**: What is "fall-through" behavior in a traditional Java `switch` statement, and how do you prevent it?
  - *Student Answer*: When a case matches but there is no `break` statement, it falls through to execute subsequent cases regardless of matches. You prevent it by adding a `break` statement to every case block. (Correct)

#### Post-Quiz
- **Question 1**: Why is using `.toUpperCase()` on `letterGrade` inside the `switch` statement expression preferred over checking both uppercase and lowercase cases (e.g., `case "a": case "A":`)?
  - *Student Answer*: It normalizes user input to uppercase, avoiding duplicate checks and adhering to the DRY principle. (Correct)
- **Question 2**: What value does `gradePoints` receive if the user inputs `"B"`? What value does it receive if the user inputs `"E"`?
  - *Student Answer*: `"B"` results in `3.0`, and `"E"` results in `0.0` due to the `default` case. (Correct)

### Commit 0.5 — Multi-Course GPA with Loops

#### Concepts Taught
- **Java Loop Structures**: Syntactical difference between pre-test loops (`while`, `for`) and post-test loops (`do-while` which executes at least once).
- **Accumulator Variables**: Summing values over multiple loop iterations (e.g., `totalQualityPoints` and `totalCredits`).
- **Sentinel Values**: Using a specific inputs (such as `"exit"`) to flag loop termination when the iteration count is unknown beforehand.
- **Weighted GPA Calculation**: Calculating GPA as `sum(grade points * credits) / sum(credits)` to properly weigh course credits.
- **IEEE 754 Division by Zero**: Understanding that dividing a floating-point number by zero yields `Infinity` (for non-zero numerators) or `NaN` (for `0.0 / 0.0`), whereas integer division by zero throws an `ArithmeticException`.

#### Pre-Quiz
- **Question 1**: Under what scenario would you choose to use a `do-while` loop instead of a standard `while` loop?
  - *Student Answer*: In a scenario where you want the loop to run at least once. (Correct)
- **Question 2**: In the context of user input processing, what is a "sentinel value," and why is it useful when the exact number of courses the user wants to enter is unknown?
  - *Student Answer*: A sentinel value determines when a loop will end to prevent infinite looping. It's useful because the loop continues to run indefinitely until the condition is met, meaning you don't have to know the number of iterations beforehand. (Correct)

#### Post-Quiz
- **Question 1**: When evaluating the expression `totalQualityPoints / totalCredits`, `totalQualityPoints` is a `double` and `totalCredits` is an `int`. Why does Java perform floating-point division here and keep the decimal portion, rather than truncating it?
  - *Student Answer*: When dividing two numbers and at least one is a `double` type, Java uses floating-point division via binary numeric promotion. (Correct)
- **Question 2**: What value or exception is produced at runtime if `totalCredits` is `0` and we directly execute `double gpa = totalQualityPoints / totalCredits;` without the ternary check?
  - *Student Answer*: Since `totalQualityPoints` is `0.0` and `totalCredits` is `0`, this evaluates to `0.0 / 0.0` (after promotion), which yields `Double.NaN`. (Correct)

### Commit 0.6 — Input Validation

#### Concepts Taught
- **Input Validation**: Implementing defensive programming techniques to validate user inputs, preventing runtime exceptions and ensuring logical boundaries (e.g., positive credit values, valid letter grade ranges).
- **Exception Handling with try-catch**: Wrapping execution blocks in a `try-catch` structure to intercept specific exceptions such as `java.util.InputMismatchException`.
- **Scanner Buffer Recovery**: Discarding problematic inputs from the scanner buffer in a catch block (using `sc.nextLine()`) to avoid infinite loops when parsing fails.
- **Normalizing Case and White Space**: Normalizing letter grade values and case using `.toUpperCase()` and `.trim()`.

#### Pre-Quiz
- **Question 1**: When `sc.nextInt()` fails and throws an `InputMismatchException`, why does the program enter an infinite loop if you try to read an integer again without calling `sc.nextLine()` or `sc.next()` first?
  - *Student Answer*: It will enter an infinite loop because the invalid input remains in the buffer, causing subsequent reads to continuously attempt parsing the same invalid value. (Correct)
- **Question 2**: If an exception is thrown on the second line inside a `try` block containing five lines of code, does the execution complete the remaining three lines of the `try` block before jumping to the `catch` block?
  - *Student Answer*: No, execution stops immediately at the line throwing the exception and transfers directly to the catch block. (Correct)

#### Post-Quiz
- **Question 1**: In the credits input loop, why is it critical to execute `sc.nextLine();` inside the `catch` block? What happens if you omit it?
  - *Student Answer*: If you don't call `sc.nextLine()`, the invalid input stays in the input buffer and triggers an infinite loop of exceptions. (Correct)
- **Question 2**: If the user enters a decimal number (like `3.5`) when prompted for credit hours, how does our program respond, and why?
  - *Student Answer*: `"3.5"` contains a decimal point and is not a valid integer. `sc.nextInt()` throws an `InputMismatchException` which triggers the `catch` block, prompting the user for input again. (Correct)

### Phase 0 Summary — Environment & Java Basics

#### Post-Quiz
- **Question 1**: Explain the purpose of package declarations (such as `package gradeforge;`) at the top of Java source files, and how they relate to the folder structure of your project.
  - *Student Answer*: Package declarations organize classes into namespace packages to prevent naming conflicts, and Java's package structure directly mirrors the physical folder paths (e.g., `src/main/java/gradeforge/`). (Correct)
- **Question 2**: In Java, how does the runtime environment behave differently when encountering these three distinct situations: (a) integer divided by zero, (b) double divided by zero, and (c) `Scanner.nextInt()` reads a token containing non-numeric text?
  - *Student Answer*: (a) Throws a `java.lang.ArithmeticException: / by zero`. (b) Evaluates to `Double.NaN` (if `0.0 / 0.0`) or `Double.INFINITY` (if non-zero double divided by zero). (c) Throws a `java.util.InputMismatchException`. (Correct)
- **Question 3**: What is the primary benefit of maintaining automated tests alongside your codebase during development, and what did we have to configure in `AppTest` to run a console-interactive program automatically?
  - *Student Answer*: Automated tests catch regression issues during development. We configured `System.setIn` with a `ByteArrayInputStream` containing simulated keystrokes to feed standard input programmatically. (Correct)

---

## Phase 1: Object-Oriented Foundations — The Core Domain Model

### Commit 1.1 — Create the Course Class

#### Concepts Taught
- **Class Blueprinting**: Defining the structure and behavior of a domain entity using a Java class (`Course`).
- **Encapsulation**: Enforcing boundaries on data fields by using the `private` access modifier.
- **State Initialization**: Declaring parameterized constructors to build complete, valid objects and resolving naming collisions with the `this` keyword.
- **Accessor Methods**: Exposing read-only state using getter methods.
- **Immutability**: Omitting setter methods to make instances safe from state modification after creation.

#### Pre-Quiz
- **Question 1**: Write a parameterized constructor for a class named `Book` that resolves naming collisions using the `this` keyword.
  - *Student Answer*: `public Book(String title, int pages) { this.title = title; this.pages = pages; }` (Correct)
- **Question 2**: Why would you design a class to have getters but omit setters? What architectural benefit does this provide?
  - *Student Answer*: If fields are immutable, you don't need setters. The benefit is knowing fields cannot be modified from outside the class. (Correct)

#### Post-Quiz
- **Question 1**: What compilation error occurs if you declare a method as `public void getName()` but include the statement `return name;` in its body?
  - *Student Answer*: A return type mismatch occurs because the method is defined as void but attempts to return a value. (Correct)
- **Question 2**: If we try to read the course name from another class using `course.name`, what compilation error will be thrown by the compiler, and why?
  - *Student Answer*: A compilation error occurs because the field is private and cannot be accessed directly from outside the class. (Correct)


### Commit 1.2 — Add toString() to Course

#### Concepts Taught
- **Inheritance Root Class**: All Java classes implicitly inherit from `java.lang.Object`.
- **Method Overriding**: Replacing a parent class's method behavior in a subclass.
- **The Override Annotation**: Placing `@Override` above overridden methods to direct the compiler to enforce signature matching.
- **String Formatting**: Using `String.format()` to build dynamic strings with format specifiers.
- **Polymorphism / Dynamic Dispatch**: The JVM resolves calls to `toString()` dynamically at runtime based on the object's actual class, enabling `System.out.println(course)` to print our formatted string.

#### Pre-Quiz
- **Question 1**: What does the default `toString()` method return in Java, and why is this representation usually not desired?
  - *Student Answer*: It returns the object's class name, an `@` symbol, and the hexadecimal hashcode. This isn't desired because developers prefer a readable representation of the object's fields. (Correct)
- **Question 2**: If you attempt to override `toString()` but write `tostring()` instead, what difference does it make whether you wrote the `@Override` annotation above the method or not?
  - *Student Answer*: Without the annotation, it compiles normally but acts as a separate method. With the annotation, the compiler flags the typo and halts compilation. (Correct)

#### Post-Quiz
- **Question 1**: When overriding an inherited method in Java, are you allowed to change its return type to an incompatible type? Why or why not?
  - *Student Answer*: No. Java is strictly typed, and changing the return type to an incompatible type violates the contract defined in the superclass, resulting in a compile-time error. This preserves type safety. (Correct)
- **Question 2**: What does Java do under the hood if you pass an object directly to `System.out.println(course);` without explicitly calling the `toString()` method?
  - *Student Answer*: It calls `String.valueOf(course)`, which dynamically invokes our overridden `toString()` method, printing our custom formatted string. (Correct)

### Commit 1.3 — Create the Student Class

#### Concepts Taught
- **Multi-Class Domain Modeling**: Modeling unique, distinct entities (`Student` vs. `Course`) in separate files.
- **Fail-Fast Constructor Validation**: Checking arguments inside the constructor before assigning fields to prevent creation of partially initialized or invalid objects.
- **Exception Throwing**: Throwing standard Java runtime exceptions like `IllegalArgumentException` when parameters fail validation rules.
- **Null Safety & Short-Circuit Evaluation**: Ordering checks like `name == null || name.isBlank()` to prevent a `NullPointerException` when calling methods on a null reference.

#### Pre-Quiz
- **Question 1**: When validating parameters inside a constructor, why is throwing an `IllegalArgumentException` preferred over simply printing an error message like `System.out.println("Error!")` and continuing?
  - *Student Answer*: Throwing an exception is "loud" as it stops the program and brings attention to the issue, instead of quietly printing a message which allows for the bad argument to be passed. (Correct)
- **Question 2**: In Java, what is the difference in behavior between checking `name.isEmpty()` versus checking `name.trim().isEmpty()` when validating a string parameter?
  - *Student Answer*: `name.isEmpty()` only checks for an empty string `""`, while `name.trim().isEmpty()` trims whitespace first. A string with whitespace `" "` returns `false` on `isEmpty()`, but `true` on `trim().isEmpty()`. The `isBlank()` method does both of these. (Correct)

#### Post-Quiz
- **Question 1**: In the constructor check `if (name == null || name.isBlank())`, why is the order of these two checks critical? What would happen if we checked `if (name.isBlank() || name == null)` and passed `null` as the name argument?
  - *Student Answer*: Checking for `null` first prevents calling a string method (`isBlank()`) on a null reference. If the order is reversed, passing `null` will throw a `NullPointerException` (NPE) instead of a handled validation error. (Correct)
- **Question 2**: If we attempt to run the line `Student s = new Student("  ", "S123");`, what behavior occurs? Which block of code intercepts it, and what message is generated?
  - *Student Answer*: An `IllegalArgumentException` is thrown from the `Student` constructor with the message `"Student name cannot be blank"`. (Correct)

### Commit 1.4 — Grade Point Conversion as a Method

#### Concepts Taught
- **Encapsulation of Business Logic**: Moving calculation logic (such as converting grades to points) from the user interface (`App.java`) into the corresponding domain class (`Course.java`).
- **Domain Object Instantiation**: Creating instance objects within control loops to manage data and encapsulate related operations.
- **Instance Methods**: Declaring non-static methods that operate on the specific state of an object instance via implicit reference access.
- **Type Safety and Null References**: Understanding that executing instance methods on a `null` reference throws a `NullPointerException` at the invocation site.

#### Pre-Quiz
- **Question 1**: In object-oriented software design, what is the architectural benefit of encapsulating the letter-grade-to-points translation inside the `Course` class instead of leaving it in the `App.java` user interface?
  - *Student Answer*: It results in a cleaner implementation that supports DRY and isolates domain calculations in a single place. (Correct)
- **Question 2**: When writing an instance method (like `getGradePoints()`) inside `Course`, what keyword is omitted from the method signature compared to a class-level utility method (like `main`), and how does the method access the object's instance fields?
  - *Student Answer*: `static` is omitted from the signature. The method accesses its own fields directly by name or by using the `this` keyword. (Correct)

#### Post-Quiz
- **Question 1**: If we decide to support a new grading scale (e.g. adding `"A+"` worth `4.3` points), in which file(s) must we change the grade-to-points mapping logic? How does this demonstrate the benefit of encapsulation?
  - *Student Answer*: Only the body of `getGradePoints()` in `Course.java` needs to change. This ensures modifications are localized, preventing duplicate edits across multiple files. (Correct)
- **Question 2**: If we declare `Course course = null;` and then attempt to execute `course.getGradePoints();`, what runtime error will occur, and why?
  - *Student Answer*: A `NullPointerException` (NPE) is thrown at the invocation site because we are attempting to call an instance method on a reference that points to nothing (`null`). (Correct)

### Commit 1.5 — Static Utility Method: GradeUtils

#### Concepts Taught
- **Static Keyword**: Declaring members (fields/methods) that belong to the class template rather than instances.
- **Utility Class Pattern**: Designing stateless helper classes as `final` with `private` constructors to prevent instantiation and subclassing.
- **Stateless Methods**: Using `static` for methods whose results depend purely on parameters and do not interact with instance state.
- **Compile-Time vs. Runtime Errors**: Differentiating compiler access control blocks (such as private constructor errors) from runtime exceptions (such as `UnsupportedOperationException`).

#### Pre-Quiz
- **Question 1**: What is the purpose of declaring a private constructor inside a utility class, and what happens if a developer attempts to call `new GradeUtils()` in their code?
  - *Student Answer*: It prevents outside classes from instantiating it. Attempting to call `new GradeUtils()` outside the class results in a compile-time error. (Correct)
- **Question 2**: If a method inside a class does not use the `this` keyword or access any instance fields, should it be declared `static`? Why or why not?
  - *Student Answer*: Yes, because it belongs to the class template itself rather than any specific object instance. (Correct)

#### Post-Quiz
- **Question 1**: In `GradeUtils`, we throw an `IllegalArgumentException` in `toGradePoints(String grade)` if the grade is invalid. Why is it safe to throw this exception here, and what method should callers invoke beforehand if they want to check validity without risking an exception?
  - *Student Answer*: Callers should call `isValidGrade()` beforehand to check validity. Throwing an exception is safe because an invalid grade violates the API contract (precondition) and prevents returning a misleading numeric double value. (Correct)
- **Question 2**: If you try to compile code that contains the statement `GradeUtils myUtils = new GradeUtils();` what error is printed by the compiler, and why?
  - *Student Answer*: A compile-time error occurs stating that the constructor has private access in `GradeUtils`, blocking compilation. (Correct)

---

### Commit 1.6 — Reference vs. Value Semantics Demo

#### Concepts Taught
- **Memory Management**: The LIFO Stack holds local primitives and object reference addresses, while the Heap stores dynamically allocated objects.
- **Value Semantics**: Passing primitive values copies their bits; helper method changes are local and do not modify the caller's variables.
- **Reference Semantics**: Passing objects copies their reference address. Mutating properties inside a method alters the shared object on the Heap.
- **Reference Reassignment**: Reassigning a reference inside a method changes the local pointer on the Stack, leaving the caller's reference unchanged.
- **Reference Aliasing**: Pointing multiple variables to the same heap address, where changes via one reference are visible to all.
- **Identity vs. Equivalence**: `==` compares reference addresses. By default, `equals()` performs a reference check unless overridden in the class to compare field values.

#### Pre-Quiz
- **Question 1**: In Java memory management, what is the role of the Stack compared to the Heap? Which memory area stores local primitive variables, and which stores actual object instances?
  - *Student Answer*: The Stack stores local primitives and execution frames, while the Heap is where object instances live. (Correct)
- **Question 2**: What does `c1 == c2` evaluate to, and what does `c1.equals(c2)` evaluate to for separate instances with identical properties, assuming `Course` has not overridden the default `Object.equals()` method?
  - *Student Answer*: Both evaluate to `false` because they are separate heap instances (different pointers) and `Object.equals()` defaults to a `==` reference comparison. (Correct)

#### Post-Quiz
- **Question 1**: If we later override the `equals()` method in `Course.java` to check that the course name, credits, and grade match, what would `c1.equals(c2)` evaluate to? What would `c1 == c2` evaluate to?
  - *Student Answer*: `c1.equals(c2)` would evaluate to `true` (since we explicitly compare field values), and `c1 == c2` would evaluate to `false` (since they are separate objects on the heap). (Correct)
- **Question 2**: In the `testReferenceReassignment` test, when `reassignReference(course)` executes the line `course = new MutableCourse("Science");`, why is the caller's variable `course` outside the method completely unaffected by this reassignment?
  - *Student Answer*: Java passes references by value. Reassigning `course` inside the method only changes the local stack copy of the reference to point to a new object, leaving the original variable outside pointing to the original heap object. (Correct)

---

## Phase 2: Collections & Data Management — Arrays to ArrayLists

*Entries will be added as you progress through Phase 2 commits.*

---

## Phase 3: Inheritance & Polymorphism — Assignment Type Hierarchy

*Entries will be added as you progress through Phase 3 commits.*

---

## Phase 4: Data Structures from Scratch — Custom Implementations

*Entries will be added as you progress through Phase 4 commits.*

---

## Phase 5: Algorithms & Analysis — Sorting, Searching, Big-O

*Entries will be added as you progress through Phase 5 commits.*

---

## Phase 6: File I/O & Persistence — Save/Load System

*Entries will be added as you progress through Phase 6 commits.*

---

## Phase 7: Advanced OOP & Design Patterns

*Entries will be added as you progress through Phase 7 commits.*

---

## Phase 8: GUI — JavaFX Desktop Application

*Entries will be added as you progress through Phase 8 commits.*

---

## `/explain` Glossary

*Concept definitions requested via `/explain` will be collected here for quick reference.*

---

## `/skip` Log

*Any skipped quiz questions or prediction steps will be logged here for future review.*

---

*GradeForge Study Guide — initialized at project creation*
*Framework: Pedagogical Agentic Workflow (PAW) v1.0.0*
