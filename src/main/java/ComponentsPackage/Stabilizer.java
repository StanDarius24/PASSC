package ComponentsPackage;

import Interfaces.Components;

public class Stabilizer implements Components {
    private static Stabilizer instance=null;
    public static Stabilizer getInstance()
    {
        if(instance==null)
            instance=new Stabilizer();
        return instance;
    }
}
