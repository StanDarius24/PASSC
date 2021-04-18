import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;

public class StockMarketImpl extends UnicastRemoteObject implements StockMarket {
    public StockMarketImpl() throws RemoteException {}
    public float get_price(String company) {
        float price=12345;
        return price;
    }
}
