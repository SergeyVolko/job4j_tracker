package oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax1To2() {
        Assert.assertEquals(2, Max.max(1, 2));
    }

    @Test
    public void whenMax1To2To3() {
        Assert.assertEquals(3, Max.max(1, 2, 3));
    }

    @Test
    public void whenMax1To2To3To4() {
        Assert.assertEquals(4, Max.max(1, 2, 3, 4));
    }
}