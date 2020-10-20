package Server;

import Client.RegisterData;
import Database.DatabaseConnection;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Registration {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public boolean dublicatecheck(String username, Connection connectionDB){

        String dublicatecheckquery = "select count(*) from LiveStream_user_account where username = '"+username+"'";
        try{
            Statement dublicatestatement = connectionDB.createStatement();
            ResultSet resultSet = dublicatestatement.executeQuery(dublicatecheckquery);
            resultSet.next();
            if (resultSet.getInt(1)==1){
                dublicatestatement.close();
                return true;
            }
            dublicatestatement.close();
            return false;

        }catch (Exception e){
            e.printStackTrace();
            return true;
        }
    }
    boolean insertUser(RegisterData registerData){
        String username = registerData.getUserName();
        String firstname = registerData.getFirstName();
        String lastname = registerData.getLastName();
        String password = registerData.getPassword();
        if(dublicatecheck(username,connectDB)){
           // registrationmessage.setTextFill(Color.RED);
            //registrationmessage.setText("*Username already Exits");
            return false;
        }
        String registeruser = "insert ignore into LiveStream_user_account (firstname,lastname,username,password) values ('"+firstname+"','"+lastname+"','"+username+"','"+password+"');";

        try {
            Statement registrationupdate = connectDB.createStatement();
            int count = registrationupdate.executeUpdate(registeruser);
            System.out.println(count);
            if (count==1){
                registrationupdate.close();
                return true;
            }else{
                registrationupdate.close();
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
              return false;
        }
    }
}
