package tema1;

/*
    @StanDarius
 Pipes and Filters

 Etapele trebuie rulate in regim Multitasking, pentru acest fapt o sa folosim threaduri.
Filtrele sunt muncitorii, iar pentru acestia o sa "pornim" cate un thread pentru fiecare (descompunere in mod natural in mai multe etape de procesare).
O sa avem nevoie de un mod de comunicare intre acestea, adica fiecare sa primeasca o parte prelucrata din scaun
sa-si execute taskul (adica sa adauge ce are de adaugat) si sa-l dea mai departe, acestea o sa fie pipe-urile (gestionarea intre muncitori a scaunelor).
Pentru acestea, stiind ca threadurile folosesc stiva de date ca acces comun, o sa creem o coada
in main pentru fiecare 2 muncitori care o sa reprezinte modul prin care acestia o sa primeasca materialele (pipe-urile).
Componentele neadiacente nu folosesc informatiile comune in acest caz.

Aceste tipuri de filtre sunt Pasive, deoarece activitatea lor este declansata de ce avem in filtre
in momentul cand primim ceva, acestea se executa si trimit in pipe-ul de iesire produsul lor prelucrat.


 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) {

        // declararea fiecarei etape de procesare
        Muncitor Ion = new Muncitor("Ion",Tasks.C);
        Muncitor Vasile = new Muncitor("Vasile",Tasks.F);
        Muncitor Petru = new Muncitor("Petru",Tasks.B);
        Muncitor Gheo = new Muncitor("Gheo",Tasks.S);
        Muncitor Costi = new Muncitor("Costi",Tasks.P);
        // declararea pipe-urilor
        BlockingQueue<Scaun> q1 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q2 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q3 = new ArrayBlockingQueue<>(2);
        BlockingQueue<Scaun> q4 = new ArrayBlockingQueue<>(2);
        // legam pipe-urile intre procese
        Ion.setOut(q1);
        Vasile.setIn(q1);
        Vasile.setOut(q2);
        Petru.setIn(q2);
        Petru.setOut(q3);
        Gheo.setIn(q3);
        Gheo.setOut(q4);
        Costi.setIn(q4);
        //pornim prelucrarea scaunelor
        new Thread(Ion).start();
        new Thread(Vasile).start();
        new Thread(Petru).start();
        new Thread(Gheo).start();
        new Thread(Costi).start();
    }
}
