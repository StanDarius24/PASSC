package tema1;

public class Scaun {
    private int id;
    private static int index =0;
    private String Task;
    // fiecare scaun o sa fie contorizat si o sa abstractizam starea de prelucrare, printr-un string
    // daca acesta contine anumiti parametrii consideram ca scaunuli i s-au adaugat respectivele parti
    public Scaun()
    {
        Task = index +" : ";
        id=index++;
    }
    // adaugare de componente, un alt mod se putea rezolva prin valori boolene pt fiecare componenta in parte
    public void make(Tasks t)
    {
        Task = Task + String.valueOf(t);
    }


   public int getId(){
        return id;
    }
}
