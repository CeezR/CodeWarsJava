import org.example.BraceChecker;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BraceCheckerTester {

    private BraceChecker checker;

    @BeforeAll
    public void setUp() {
        checker = new BraceChecker();
    }

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("()"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("[(])"));
        assertEquals(false, checker.isValid("(})"));
    }
}
