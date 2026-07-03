package gradeforge;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void applicationHasMainMethod() {
        InputStream originalSystemIn = System.in;
        try {
            // Simulate entering name, course, and letter grade "A"
            String simulatedInput = "John Doe\nComputer Science\nA\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            assertDoesNotThrow(() -> App.main(new String[] {}));
        } finally {
            // Restore original System.in
            System.setIn(originalSystemIn);
        }
    }
}
