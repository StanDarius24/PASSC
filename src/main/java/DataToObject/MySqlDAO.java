package DataToObject;

import Factories.MySqlDAOFactory;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class MySqlDAO implements HoroscopeDAO{

    @Override
    public boolean predictGrades(int id) {
        Connection connection = MySqlDAOFactory.createConnection();

        int val =0;

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from studenti where idstudenti = " + id);

            if(resultSet.next())
            {
                String name = resultSet.getString("nume");
                    Integer i = 0;
                while(id!=0)
                {
                    i = id%10 +i;
                    id = id/10;
                }

               val = name.length() + i;


            }

        }catch ( Exception e )
        {
            e.printStackTrace();
        }
    MySqlDAOFactory.closeConnection(connection);

        if(val%2 == 1)
            return true;
        else
            return false;
    }

    @Override
    public int howManyStudents() {
        Connection connection = MySqlDAOFactory.createConnection();
        int val = 0;
        try{

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from studenti where nota > 8");

            while(resultSet.next())
            {
                int nrmatr = resultSet.getInt("idstudenti");

                if(predictGrades(nrmatr)){
                    val++;
                }
            }


        }catch ( Exception e )
        {
            e.printStackTrace();
        }

        MySqlDAOFactory.closeConnection(connection);
        return val;


    }

    @Override
    public boolean goodDay(int id) {
        Connection connection = MySqlDAOFactory.createConnection();
        int val =0;
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from studenti where idstudenti = " + id);
            if(resultSet.next())
            {
                String name = resultSet.getString("Nume");
                val = val + name.length();
                val = val + Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

            }

        }catch ( Exception e )
        {
            e.printStackTrace();
        }

        MySqlDAOFactory.closeConnection(connection);
        val = val%2;
        if(val == 0)
            return false;
        else
            return true;

    }
}
