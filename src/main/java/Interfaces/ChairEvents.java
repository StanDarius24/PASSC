package Interfaces;

public abstract class ChairEvents {
    private ChairInterface chair=null;
    public boolean taken=false;
    public ChairInterface getChair() {
        return chair;
    }

    public void attachChair(ChairInterface c)
    {
        this.chair=c;
    }

    public void take()
    {

        taken=true;
    }

    public boolean canItake()
    {
        return taken;
    }

    public void available()
    {
        this.taken=false;
    }
}
