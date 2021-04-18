import java.rmi.RemoteException;

public interface StockMarket extends java.rmi.Remote{
    float get_price (String Company) throws RemoteException;
}
