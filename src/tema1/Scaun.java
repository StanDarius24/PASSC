package tema1;

public class Scaun {
    private int id;
    private static int index =0;
    private String Task;
    private int time;
    public Scaun()
    {
        Task = index +" : ";
        id=index++;
        this.time=0;
    }
    public void make(Tasks t,int ts)
    {
        Task = Task + String.valueOf(t);
        this.time=this.time+ts;
    }

    public int gettotaltime()
    {
        return this.time;
    }

   public int getId(){
        return id;
    }
}
