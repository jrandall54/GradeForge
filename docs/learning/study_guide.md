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


---

## Phase 1: Object-Oriented Foundations — The Core Domain Model

*Entries will be added as you progress through Phase 1 commits.*

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
