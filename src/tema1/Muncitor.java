package tema1;

import java.util.concurrent.BlockingQueue;

public class Muncitor implements Runnable{

    private String Name;
    private Tasks Task;
    private int id;
    private static int index=0;
    private BlockingQueue <Scaun> intrare,iesire;
    public Muncitor(String name, Tasks task)
    {
        this.Name=name;
        this.Task=task;
        this.id= index++;
    }

    public BlockingQueue<Scaun> getFirst()
    {
        return intrare;
    }
    public BlockingQueue<Scaun> getLast()
    {
        return iesire;
    }

    public void setIn(BlockingQueue<Scaun> start)
    {
        this.intrare=start;
    }
    public void setOut(BlockingQueue<Scaun> end)
    {
        this.iesire=end;
    }

    public void run()
    {
        if(intrare==null) //primul muncitor
        {
            while(true)
            {
                try {
                    Thread.sleep(500);
                    Scaun scaun = new Scaun();
                    System.out.println(this.Name + " incepe scaunul " + scaun.getId() + " cu taskul " + this.Task.toString());
                    scaun.make(this.Task);
                    iesire.put(scaun);
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }

        }else
            if(iesire == null)
            {
                while(true)
                {
                    try {
                        Scaun scaun = intrare.take();
                        scaun.make(this.Task);
                        System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString());
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
            }else
                if(iesire!= null && intrare != null)
                {
                    while(true)
                    {
                        try {
                            Scaun scaun = intrare.take();
                            System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString());
                            scaun.make(this.Task);
                            iesire.put(scaun);
                        }catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }

    }
}
