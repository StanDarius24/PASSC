package tema1;

import java.util.concurrent.BlockingQueue;

public class Muncitor implements Runnable{
    private int nrtotal;
    private String Name;
    private Tasks Task;
    private int id;
    private boolean sw = true;
    private int time;
    private  BlockingQueue<Scaun> intrare,iesire;
    public Muncitor(String name, Tasks task,int time)
    {
        this.Name=name;
        this.Task=task;
        this.time=time;
    }

    public void stop()
    {
        this.sw=false;
    }

    public int gettime(){
        return this.time;
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
            while(sw)
            {
                try {
                    Thread.sleep(this.time*10);
                    if(nrtotal<10)
                    {
                        nrtotal++;
                    Scaun scaun = new Scaun();
                    scaun.make(this.Task,this.time);
                    System.out.println(this.Name + " incepe scaunul " + scaun.getId() + " cu taskul " + this.Task.toString() + " timpul de lucru total pt acest scaun e = " + scaun.gettotaltime());
                    iesire.put(scaun);
                    }
                    else
                        if(nrtotal==10)
                            this.stop();
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }

        }else
            if(iesire == null)
            {
                while(sw)
                {
                    try {
                        if(nrtotal==10)
                            this.stop();
                        nrtotal++;
                        Thread.sleep(this.time*10);
                        Scaun scaun = intrare.take();
                        if(scaun!=null)
                        {
                        scaun.make(this.Task,this.time);
                        System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString() + " timpul de lucru total pt acest scaun e = " + scaun.gettotaltime() );}
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
            }else
                if(iesire!= null && intrare != null)
                {
                    while(sw)
                    {
                        try {
                            Thread.sleep(this.time*10);
                            if(nrtotal==10)
                                this.stop();
                            Scaun scaun = intrare.take();
                            if(scaun != null){
                                scaun.make(this.Task,this.time);
                            System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString() +" timpul de lucru total pt acest scaun e = " + scaun.gettotaltime());
                            iesire.put(scaun);}
                        }catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }

    }
}
