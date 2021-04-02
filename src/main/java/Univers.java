

public class Univers {
    private static ExistingEntitiesClass x;
    private static TeleportedEntities t;
    public static void  main(String[] args)
    {
       x=new ExistingEntitiesClass();
    try {
        new Thread(x).start();
    }catch (Exception e) { e.printStackTrace(); }


    t = new TeleportedEntities();
    while(true)
    {
        try{
            new Thread(t).start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    }

}
