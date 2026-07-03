package gradeforge;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Smoke test to verify JUnit 5 is correctly configured.
 */
class AppTest {

    @Test
    void applicationHasMainMethod() {
        assertDoesNotThrow(() -> App.main(new String[] {}));
    }
}
