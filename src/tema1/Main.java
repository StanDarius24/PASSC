package tema1;

/*
    @StanDarius
 Pipes and Filters

 Etapele trebuie rulate in regim Multitasking, pentru acest fapt o sa folosim threaduri.
Filtrele sunt muncitorii, iar pentru acestia o sa "pornim" cate un thread pentru fiecare.
O sa avem nevoie de o mod de comunicare intre acestia, adica fiecare sa primeasca o parte din scaun
sa-l prelucreze asa cum stie el mai bine si sa-l dea mai departe, acestea o sa fie pipe-urile.
Pentru acestea, stiind ca threadurile folosesc stiva de date ca acces comun, o sa creem o coada
in main pentru fiecare 2 muncitori care o sa reprezinte modul prin care acestia o sa primeasca materialele.
Componentele neadiacente nu folosesc informatiile comune in acest caz.

Aceste tipuri de filtre sunt Pasive, deoarece activitatea lor este declansata de ce avem in filtre
in momentul cand primim ceva, acestea se executa si trimit in pipe-ul de iesire produsul lor prelucrat.


 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        Muncitor Ion = new Muncitor("Ion",Tasks.C);
        Muncitor Vasile = new Muncitor("Vasile",Tasks.F);
        Muncitor Petru = new Muncitor("Petru",Tasks.B);
        Muncitor Gheo = new Muncitor("Gheo",Tasks.S);
        Muncitor Costi = new Muncitor("Costi",Tasks.P);

        BlockingQueue<Scaun> q1 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q2 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q3 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q4 = new ArrayBlockingQueue<>(2);

        Ion.setOut(q1);
        Vasile.setIn(q1);
        Vasile.setOut(q2);
        Petru.setIn(q2);
        Petru.setOut(q3);
        Gheo.setIn(q3);
        Gheo.setOut(q4);
        Costi.setIn(q4);

        new Thread(Ion).start();
        new Thread(Vasile).start();
        new Thread(Petru).start();
        new Thread(Gheo).start();
        new Thread(Costi).start();
    }
}
