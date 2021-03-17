package ComponentsPackage;

import Interfaces.Components;

public class Package implements Components {
    private static Package instance=null;
    public static Package getInstance()
    {
        if(instance==null)
            instance=new Package();
        return instance;
    }
}
