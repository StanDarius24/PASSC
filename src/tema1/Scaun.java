package tema1;

public class Scaun {
    protected String tasks;
    protected int nr;
    protected static int val=1;
    public Scaun()
    {
        this.tasks="";
        this.nr=this.val++;
    }

    public int getval()
    {
        return this.nr;
    }
    public void addtask(Task Q)
    {
        tasks=tasks+Q.toString();
    }
    public String printtasks()
    {
        return tasks;
    }

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
                    if(c=="S" && !tasks.contains("S"))
                        return tasks.contains("F");
                    else
                        if(c=="P" && !tasks.contains("P"))
                            return tasks.contains("C") && tasks.contains("B")
                                    && tasks.contains("F") && tasks.contains("S");
                        else
                            return false;
    }
    public boolean done()
    {
        return tasks.length()==5;
    }
}
