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
            // Simulate: Name -> Course -> Credits -> Grade -> Sentinel Exit
            String simulatedInput = "John Doe\nComputer Science\n4\nA\nexit\n";
            System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

            assertDoesNotThrow(() -> App.main(new String[] {}));
        } finally {
            // Restore original System.in
            System.setIn(originalSystemIn);
        }
    }
}
