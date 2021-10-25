package oop;

import org.junit.Test;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest  {

    @Test
    public void whenP000ToP111ThenPDistance3d() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 1, 1);
        assertThat(a.distance3d(b), closeTo(1.732, 0.001));
    }
}