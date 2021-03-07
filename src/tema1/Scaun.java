package tema1;

public class Scaun {
    private int id;
    private static int index =0;
    private String Task;
    public Scaun()
    {
        Task = index +" : ";
        id=index++;
    }
    public void make(Tasks t)
    {
        Task = Task + String.valueOf(t);
    }


   public int getId(){
        return id;
    }
}
