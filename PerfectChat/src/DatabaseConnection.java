
import java.sql.Connection;
import java.sql.DriverManager;

//watch DAO concepts
//set methods for each function smaje.....

public class DatabaseConnection {
    public Connection con;

    public Connection getConnection() {

        //hide this and look for connection pooling...
        String databaseName = "mydb";
        String databaseUser = "root";
        String databasePassword = "sk@715037";
        String url = "jdbc:mysql://localhost/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,databaseUser,databasePassword);

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return con;
    }
}
