package ComponentsPackage;

import Interfaces.Components;

public class Backrest implements Components {
    private static Backrest instance=null;
    public static Backrest getInstance()
    {
        if(instance==null)
            instance=new Backrest();
        return instance;
    }
}
