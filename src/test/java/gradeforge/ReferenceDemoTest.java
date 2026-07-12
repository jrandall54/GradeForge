package gradeforge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class demonstrating the difference between Java's primitive value semantics
 * and object reference semantics (Stack vs Heap, aliasing, and == vs. equals).
 */
public class ReferenceDemoTest {

    // Helper class to demonstrate object mutation since Course/Student are immuatable
    private static class MutableCourse {
        String name;

        MutableCourse(String name) {
            this.name = name;
        }
    }

    //  Helper method to demonstrate primitive passing
    private void modifyPrimitive(int value) {
        value = 99; // Modifies local copy on the stack
    }

    // Helper method to demonstrate reference mutation
    private void mutateObject(MutableCourse course) {
        course.name = "History"; // Mutates object on the heap via copied reference
    }

    // Helper method to demonstrate reference reassignment
    private void reassignReference(MutableCourse course) {
        course = new MutableCourse("Science"); // Reassigns local copy of reference
    }

    @Test
    void testPrimitivePassing() {
        int originalCredits = 4;
        modifyPrimitive(originalCredits);

        // The original variable on teh stack in unaffected
        assertEquals(4, originalCredits);
    }

    @Test
    void testReferencePassingMutation() {
        MutableCourse course = new MutableCourse("Math");
        mutateObject(course);

        // The object on the heap was mutated, so the change is visable to the caller
        assertEquals("History", course.name);
    }

    @Test
    void testReferenceReassignment() {
        MutableCourse course = new MutableCourse("Math");
        reassignReference(course);

        // Caller's reference still points to the original object
        assertEquals("Math", course.name);
    }

    @Test
    void testReferenceAliasing() {
        MutableCourse c1 = new MutableCourse("Math");
        MutableCourse c2 = c1; // c2 is now an alias for c1

        // Both point to the exact same memory address on the heap
        assertSame(c1, c2);

        // Mutating c2 mutates c1
        c2.name = "English";
        assertEquals("English", c1.name);
    }

    @Test
    void testIdentityVsEquivalence() {
        Course c1 = new Course("Math", 3, "A");
        Course c2 = new Course("Math", 3, "A");

        // c1 and c2 point to different memory addresses on the heap
        assertFalse(c1 == c2);

        // Under default Object inheritance, .equals() performs a reference check (==)
        assertFalse(c1.equals(c2));
    }
}
