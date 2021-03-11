package tema1;

public class Main {
    public static void main(String[] args)
    {
        BlackBoard bl = new BlackBoard();
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());
        bl.addscaun(new Scaun());

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
