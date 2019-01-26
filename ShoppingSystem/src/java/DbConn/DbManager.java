package DbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbManager
{
    public static Connection getConnection()
    {
        try {
            DriverManager.registerDriver(
                    new org.apache.derby.jdbc.ClientDriver());
            
            return DriverManager.getConnection("jdbc:derby://localhost:1527/GrocerySystem", "haydn", "pass");
            
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    
}
