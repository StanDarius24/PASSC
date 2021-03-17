package ComponentsPackage;

import Interfaces.Components;

public class Feet implements Components {
    private static Feet instance=null;
    public static Feet getInstance()
    {
        if(instance==null)
            instance=new Feet();
        return instance;
    }
}
