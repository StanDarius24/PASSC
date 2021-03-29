package dummycode;

import java.util.ArrayList;

public class DummyMain {
    public static void main(String[] args)
    {
        ArrayList <String> ar1 = new ArrayList<>();
        ar1.add("Denis");
        ar1.add("Bogdan");

        DummyInterface d1 = new SubclassDummy(ar1);
        d1.calculate("Nume");

        ar1.remove(1);
        ar1.add("Mircea");
        DummyInterface d2 = new SuperDummyClass(ar1);
        System.out.println( d2.toString() );
    }
}
