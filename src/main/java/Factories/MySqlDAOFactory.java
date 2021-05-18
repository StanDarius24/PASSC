package Factories;

import DataToObject.DAOFactory;
import DataToObject.HoroscopeDAO;
import DataToObject.MySqlDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDAOFactory extends DAOFactory {

    public static Connection createConnection()
    {   Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/passc","root","root");



        } catch ( Exception e )
        {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }
    public HoroscopeDAO getHoroscopeDAO() {
        return new MySqlDAO();
    }

}
