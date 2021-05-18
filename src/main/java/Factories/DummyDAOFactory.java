package Factories;

import DataToObject.DAOFactory;
import DataToObject.HoroscopeDAO;


public class DummyDAOFactory extends DAOFactory {
    public HoroscopeDAO getHoroscopeDAO() {
        return null;
    }
}
