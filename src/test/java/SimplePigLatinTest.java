import org.example.SimplePigLatin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SimplePigLatinTest {

    private SimplePigLatin simplePigLatin;


    @BeforeAll
    public void setUp() {
        simplePigLatin = new SimplePigLatin();
    }

    @Test
    public void FixedTest() {
        assertEquals("igPay atinlay siay oolcay", simplePigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", simplePigLatin.pigIt("This is my string"));
        assertEquals("hisTay siay ymay tringsay !", simplePigLatin.pigIt("This is my string !"));
    }
}
