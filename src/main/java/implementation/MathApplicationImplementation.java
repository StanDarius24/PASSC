package implementation;

import interfaces.MathApplication;

public class MathApplicationImplementation implements MathApplication {

    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
