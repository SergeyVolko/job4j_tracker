package lambda.solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class PredicateCheckPositiveTest {
    @Test
    public void whenPositive() {
        assertTrue(PredicateCheckPositive.check(1));
        assertFalse(PredicateCheckPositive.check(-1));
        assertFalse(PredicateCheckPositive.check(0));
    }
}