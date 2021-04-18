import java.rmi.*;

public class StockMarketServer {
    public static void main(String[] args) {
        try {
            StockMarketImpl stockMarketImpl = new
                    StockMarketImpl();
            Naming.rebind("NASDAQ",
                    stockMarketImpl );
        } catch (Exception e) {}
    }
}
