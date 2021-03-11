package tema1;

import java.util.ArrayList;

public class BlackBoard {
private ArrayList<Scaun> scaune;
private int nrscaune=0;

public BlackBoard()
{this.scaune = new ArrayList<>();}
public void addscaun(Scaun s)
{
    scaune.add(s);
    nrscaune++;
}
public int getscaune()
{
    return nrscaune;
}

public Scaun getscaun(Task t)
{
    for(int i=0;i<nrscaune;i++)
    {
        Scaun s = scaune.get(i);
        if(s.isok(t))
        {
            scaune.remove(i);
            nrscaune--;
            return s;
        }

    }
    return null;
}

public boolean Bdone()
{
    return scaune.size()==0;
}

}
