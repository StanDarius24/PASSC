package tema1;

import java.util.concurrent.BlockingQueue;

public class Muncitor implements Runnable{

    private String Name;
    private Tasks Task;
    private int id;
    private static int index=0;
    private BlockingQueue <Scaun> intrare,iesire;

    // Muncitorul are un nume si stie sa rezolve un anumit task
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

    //setam pipe-ul de intrare si de iesire
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
                    // aici se creaza primul scaun la un interval de 0,5s
                    Thread.sleep(500);
                    Scaun scaun = new Scaun();
                    System.out.println(this.Name + " incepe scaunul " + scaun.getId() + " cu taskul " + this.Task.toString());
                    // se adauga partea aferenta primului muncitor si se adauga in pipe-ul de iesire respectivul scaun
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
                        //ultimul muncitor preia scaunul din pipe-ul de intrare
                        Scaun scaun = intrare.take();
                        // il impacheteaza si printeazape ecran ca scaunul e gata.
                        scaun.make(this.Task);
                        System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString() + " SCAUNUL E GATA!");
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
                            // se preia primul scaun din pipe
                            Scaun scaun = intrare.take();
                            System.out.println(this.Name + " a termiant " + scaun.getId() + " cu taskul " + this.Task.toString());
                            // se monteaza partea aferenta respectivului muncitor
                            scaun.make(this.Task);
                            // se adauga in pipe-ul de iesire scaunul procesat.
                            iesire.put(scaun);
                        }catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                }

    }
}
