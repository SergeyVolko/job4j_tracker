package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidMoreInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int[] expected = new int[] {1, 2, 3};
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = input.askInt("Enter menu:");
        }
        assertArrayEquals(expected, result);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenInvalidNotInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        input.askInt("Enter menu:");
    }
}