package tema1;

/*
    @Stan Darius

    Daca respectam structura, avem un Blackboard, Knowledge Sources si Control.
    In Blackboard adaugam datele, care o sa fie comune pentru toate entitatile, urmand a fi prelucrate.
    Sincronizarea se va face astfel incat atunci cand un KnowledgeSource o sa prelucreze anumite date acestea nu o sa mai fie
    valabile in blackboard, dupa prelucrare o sa fie din nou adaugate.
    KnowledgeSource o sa fie muncitorii, fiecare fiind specializat pe o anumita parte a problemei comune.
    Totodata acestia sunt independenti, iar ordinea de lucru nu e prestabilita, aceasta e dinamica in functie de datele din
    Blackboard.

 */

public class Main {
    public static void main(String[] args)
    {
        //definim blackboard-ul, datele fiind diferite ( 3 tipuri de scaune )
        BlackBoard bl = new BlackBoard();
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());
        bl.addscaun(new ScaunFaraSpatar());
        bl.addscaun(new ScaunFaraSpatar());
        bl.addscaun(new ScaunFaraStabilizator());
        bl.addscaun(new ScaunFaraStabilizator());

        //definim KS-urile si stabilim care sunt specializarile acestora
        Muncitor m1=new Muncitor("ION",Task.C,bl);
        Muncitor m2=new Muncitor("VIOREL",Task.F,bl);
        Muncitor m3=new Muncitor("MIRCEA",Task.B,bl);
        Muncitor m4=new Muncitor("ANDREI",Task.S,bl);
        Muncitor m5=new Muncitor("BOGDAN",Task.P,bl);

        new Thread(m1).start();
        new Thread(m2).start();
        new Thread(m3).start();
        new Thread(m4).start();
        new Thread(m5).start();
    }
}
