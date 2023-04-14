package polymorph;

public class MainFunc implements Func2 {
    @Override
    public double func(double x, double y) {
        return Func2.super.func(x, y);
    }

    @Override
    public void funcMessage() {

    }
}
