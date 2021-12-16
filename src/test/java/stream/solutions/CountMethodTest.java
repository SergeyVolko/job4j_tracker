package stream.solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
public class CountMethodTest {
    @Test
    public void test() {
        assertEquals(3, CountMethod.count(List.of(1, 2, 3).stream()));
    }
}