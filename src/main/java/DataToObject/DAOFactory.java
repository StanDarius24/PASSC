package DataToObject;

import Factories.DummyDAOFactory;
import Factories.MySqlDAOFactory;

public abstract class DAOFactory {
    public static DAOFactory getDAOFactory(String factory)
    {
        if(factory.equals("mysql"))
            return new MySqlDAOFactory();
        else
            return new DummyDAOFactory();
    }
    public abstract HoroscopeDAO getHoroscopeDAO();
}
