package tema1;

public class ScaunFaraStabilizator extends Scaun{

    public boolean isok(Task t)
    {

        String c=t.toString();
        if(tasks.contains(c))
            return false;
        else
        if(c.equals("C") && !tasks.contains("C"))
            return true;
        else
        if(c=="F"&& !tasks.contains("F"))
            return tasks.contains("C");
        else
        if(c=="B" && !tasks.contains("B"))
            return tasks.contains("C");
        else
        if(c=="S" )
            return false;
        else
        if(c=="P" && !tasks.contains("P"))
            return tasks.contains("C") && tasks.contains("B")
                    && tasks.contains("F");
        else
            return false;
    }


    public boolean done()
    {
        return tasks.length()==4;
    }
}
