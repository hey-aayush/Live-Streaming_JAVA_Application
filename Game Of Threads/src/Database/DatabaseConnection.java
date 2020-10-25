package Database;
import java.sql.Connection;
import java.sql.DriverManager;

//watch DAO concepts
//set methods for each function smaje.....

public class DatabaseConnection {

    public static DatabaseConnection singleInstance = null;

    private DatabaseConnection(){

    }
    public static DatabaseConnection getInstance(){
        if(singleInstance == null)
            singleInstance = new DatabaseConnection();
        return singleInstance;
    }
    private Connection con;

    public Connection getConnection() {

        //hide this and look for connection pooling...
        String databaseName = "";
        String databaseUser = "root";
        String databasePassword = "";
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
