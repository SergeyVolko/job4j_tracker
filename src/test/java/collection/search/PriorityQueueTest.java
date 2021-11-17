package collection.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherPriorityFive() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("five", 5));
        queue.put(new Task("one", 1));
        queue.put(new Task("three", 3));
        queue.put(new Task("three", 3));
        queue.put(new Task("four", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("one"));
        result = queue.take();
        assertThat(result.getDesc(), is("three"));
        result = queue.take();
        assertThat(result.getDesc(), is("three"));
        result = queue.take();
        assertThat(result.getDesc(), is("four"));
        result = queue.take();
        assertThat(result.getDesc(), is("five"));
    }
}