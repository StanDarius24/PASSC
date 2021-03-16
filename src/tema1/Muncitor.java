package tema1;

public class Muncitor implements Runnable{
    private Task task;
    private static int val=1;
    private int nr;
    private int nrtotal;
    private int index=0;
    private String name;
    private BlackBoard BlackBoard;

    // fiecare ks are o referinta catre Bb prelucrarea facandu se in felul urmator
    // se extrag date , daca datele respective pot fi rezolvate partial, se prelucreaza in acest sens
    // iar apoi se adauga inapoi in blackboard, fiecare ks prelucrand respectiva data doar cu specializarea acestuia
    public Muncitor(String name,Task t,BlackBoard b)
    {
        this.name=name;
        this.task=t;
        this.BlackBoard=b;
        this.nr=this.val++;
        nrtotal=BlackBoard.getscaune();
    }

    public void run(){
        Scaun scaun ;
        while(true)
        {

            synchronized (BlackBoard){scaun = BlackBoard.getscaun(this.task);}
            if(scaun!=null)
            {

                if(scaun.isok(task)) {

                     System.out.println("Thread " + this.nr + " lucreaza la " + scaun.getval() +" care mai are " + scaun.printtasks() + " cu task-ul " + task.toString());
                    scaun.addtask(task);
                     synchronized (BlackBoard){
                         if(!scaun.done())
                         BlackBoard.addscaun(scaun);
                         else
                         {
                             System.out.println("Scaunul " + scaun.getval() + " este gata");
                            index++;
                            if(index==nrtotal) {
                                System.out.println("Am terminat scaunele");
                                System.exit(1);
                            }
                         }
                   }

                }
                else
                    try {
                        Thread.sleep(100);

                    }catch(InterruptedException e){e.printStackTrace();}
            }

        }
    }

}
