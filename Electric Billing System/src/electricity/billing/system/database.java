package electricity.billing.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database
{
    Connection connection;
    Statement statement;
    database()
    {
        try
        {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Bill_system","root","Virat@23195");//we r storing inside connection
            statement=connection.createStatement();// With the help of connection we r creating a statement
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
