import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PutDataInDataBase {

    private static String sql = "insert into studenti ";

    private static String[] names ={
            "Bogdan","Andrei","Sergiu","Cristian","Aurelian","Marian"
    };
    private static String[] surname = {
            "Ionescu","Nastase","Boc","Voiculescu","Cristoiu","Gadea"
    };

    private static String[] grades = {
            "8","6","9","4","7","10"
    };

    public static Integer calcnrmat(int i,String name,String pren)
    {
        int val =0;

        val = i * 10 + name.length()*12 + pren.length()*100;

        return val;
    }

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Get connection to the database.
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/passc","root","root");
            //Create statement
            Statement myStmt = myConn.createStatement();

            ResultSet myRs = myStmt.executeQuery("SELECT * FROM STUDENTI");

            while(myRs.next())
            {
                System.out.println(myRs.getString("nume") +" " +myRs.getString("prenume"));
            }

            if(names.length == surname.length)
            {
                for(int i=0;i< names.length;i++)
                {

                    int val = calcnrmat(i,names[i],surname[i]);
                    String insertText = sql +"(idstudenti, nume, prenume, nota) " +
                            "values " + "('"+ val +"', '"+names[i]+"', '" +surname[i] + "', '" + grades[i] +"')";
                    System.out.println(insertText);

                    myStmt.executeUpdate(insertText);
                }
            }



        }catch ( Exception e )
        {
            e.printStackTrace();
        }

        }
}
