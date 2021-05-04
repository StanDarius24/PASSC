import ToyOrb.ToyOrb;
import implementation.MathApplicationImplementation;
import interfaces.MathApplication;

public class MathAppServer {
    public static void main(String[] args) {
        MathApplication m = new MathApplicationImplementation();
        ToyOrb.register("mate",m);
    }
}
