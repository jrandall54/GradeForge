package gradeforge;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Smoke test to verify JUnit 5 is correctly configured.
 */
class AppTest {

    @Test
    void applicationHasMainMethod() {
        InputStream originalSystemIn = System.in;
        try {
            // Simulate entering name "John Doe" followed by course "Computer Science"
            String simulatedInput = "John Doe\nComputer Science\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            assertDoesNotThrow(() -> App.main(new String[] {}));
        } finally {
            // Restore original System.in
            System.setIn(originalSystemIn);
        }
    }
}
