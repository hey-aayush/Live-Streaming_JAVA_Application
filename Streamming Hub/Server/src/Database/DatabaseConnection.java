package Database;
import java.sql.Connection;
import java.sql.DriverManager;

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

        String databaseName = [DatabaseName];
        String databaseUser =[User];
        String databasePassword = [Password];
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
