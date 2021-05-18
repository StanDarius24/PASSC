import DataToObject.DAOFactory;
import DataToObject.HoroscopeDAO;

public class Horoscope {
    private DAOFactory daoFactory = DAOFactory.getDAOFactory("mysql");
    private HoroscopeDAO horoscopeDAO;


    void testGoodDay(int id)
    {
        if(horoscopeDAO.goodDay(id))
            System.out.println(id + " has a good day");
        else
            System.out.println(id + " has a bad day :(");

    }

    void testStudents()
    {
        System.out.println(horoscopeDAO.howManyStudents() + " students will get lower grades");

    }

    void testPredGrades(int id)
    {
        if(horoscopeDAO.predictGrades(id))
            System.out.println(id + " gets higher grades");
        else
            System.out.println(id + " gets lower grades");
    }

    public void doJod()
    {
        horoscopeDAO = daoFactory.getHoroscopeDAO();
        testPredGrades(392);
        testPredGrades(936);
        testStudents();
        testGoodDay(622);
        testGoodDay(1126);
    }

}
