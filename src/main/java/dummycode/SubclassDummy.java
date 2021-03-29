package dummycode;

import java.util.ArrayList;

public class SubclassDummy extends SuperDummyClass{
    public SubclassDummy(ArrayList <String> names)
    {
            super(names);
    }

    public void doSmth()
    {
        System.out.println("do SMTH");
    }
}
