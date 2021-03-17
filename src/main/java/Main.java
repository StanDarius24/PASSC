import EventsPackage.ChairCreatedEvent;
import EventsPackage.ChairSeatDone;
import Interfaces.ChairEvents;
import Interfaces.Worker;
import WorkersPackage.*;
import com.google.common.eventbus.EventBus;

public class Main {
    public static void main(String [] args)
    {
        EventBus eventBus = new EventBus();

        Worker a =new SeatCREATOR(1000,eventBus,"Ion");
        Worker b =new BackRest(500,eventBus,"Mihai");
        Worker r =new FeetWorker(1200,eventBus,"Bogdan");
        Worker t =new StabilizerW(900,eventBus,"George");
        Worker u =new PackageWorker(400,eventBus,"Rares");
        Worker p =new Printer(1,eventBus,"dwa");
        for(int i=0;i<4;i++) {
            Chair c = new Chair();
            ChairEvents ev = new ChairCreatedEvent();
            ev.attachChair(c);

            while (!ev.canItake()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                eventBus.post(ev);
            }
        }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {

                e1.printStackTrace();
            }

            //eventBus.post(new ChairSeatDone());
            System.exit(0);

        }
}
