package MySQLQuery;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {
    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public boolean validateLogin(String userName, String password){
        String verifyLoginQuery = "select count(1) from user where username = ? and password = ?";
        //Stop SQL injections like Pass = WrongPws'+'OR 1=1....
        try {
            PreparedStatement statement = connectDB.prepareStatement(verifyLoginQuery);
            statement.setString(1,userName);
            statement.setString(2,password);
            ResultSet queryResult = statement.executeQuery();
            if(queryResult.next()){
                //Query found in DataBase
                if (queryResult.getInt(1)==1){
                    return true;
                }//Not Found so invalid credentials
                else{
                   return false;
                }
            }
            connectDB.close();

        }catch (Exception E){
            E.printStackTrace();
            return false;
        }
        return false;
    }
}
