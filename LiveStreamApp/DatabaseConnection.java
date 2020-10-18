package LiveStreamApp;
import java.sql.Connection;
import java.sql.DriverManager;

//watch DAO concepts
//set methods for each function smaje.....

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection() {

        //hide this and look for connection pooling...
        String databaseName = "test";
        String databaseUser = "root";
        String databasePassword = "@Pragya2007";
        String url = "jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
