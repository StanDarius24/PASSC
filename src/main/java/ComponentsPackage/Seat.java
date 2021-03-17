package ComponentsPackage;

import Interfaces.Components;

public class Seat implements Components {
    private static Seat instance=null;
    public static Seat getInstance()
    {
        if(instance==null)
            instance=new Seat();
        return instance;
    }
}
