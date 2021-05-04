import Proxys.MathApplicationClientProxy;
import ToyOrb.ToyOrb;
import interfaces.MathApplication;

public class MathAppClient {
    public static void main(String[] args) {
        MathApplication x = (MathApplication) ToyOrb.getObjectReference("mate");
        System.out.println("Rez = " + x.add(2,113));
    }
}
