import Interfaces.ChairInterface;
import Interfaces.Components;

import java.util.ArrayList;

public class Chair implements ChairInterface {
    public int getId() {
        return id;
    }

    private int id;
    private static int nrt=1;
    ArrayList<Components> components;
    public Chair()
    {
        this.id=nrt++;
        this.components=new ArrayList<>();
    }


    public boolean CanIAssamble(Components c)
    {
        if(components.contains(c))
            return false;
        return true;
    }

    public void Assamble(Components c)
    {
        this.components.add(c);
    }


}
