
public class Main {
    public static void main(String[] args){

        Deserialize d = new Deserialize();
        String x = d.deser();

        Serialize s = new Serialize();
        String x2= s.serializa();

        System.out.print(x);
        System.out.println("______________");
        System.out.print(x2);

           boolean xs = true;
        while(x2!=null)
        {
            String subsir = x2.substring(0,x2.indexOf("\n"));
            x2=x2.substring(x2.indexOf("\n")+1);
            if(x2.length()<1)
                x2=null;
            if(!x.contains(subsir))
            {
                xs=false;
                System.out.println("Error" + subsir);
                break;
            }
        }

        if(xs)
            System.out.println("Succes");

    }

}
