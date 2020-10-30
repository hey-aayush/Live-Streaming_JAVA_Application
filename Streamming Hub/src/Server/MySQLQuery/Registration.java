package Server.MySQLQuery;

import Server.Query.RegisterData;
import Server.Database.DatabaseConnection;
import Server.Server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Registration {

    DatabaseConnection connection  = DatabaseConnection.getInstance();
    Connection connectDB = connection.getConnection();

    public boolean dublicatecheck(String username, Connection connectionDB){

        String dublicatecheckquery = "select count(*) from user where username = '"+username+"'";
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
    public boolean insertUser(RegisterData registerData){
        String username = registerData.getUserName();
        String firstname = registerData.getFirstName();
        String lastname = registerData.getLastName();
        String password = registerData.getPassword();
        if(dublicatecheck(username,connectDB)){
           // registrationmessage.setTextFill(Color.RED);
            //registrationmessage.setText("*Username already Exits");
            return false;
        }
        System.out.println("HI registration working");
        String registeruser = "insert ignore into user (firstName,lastName,userName,password) values ('"+firstname+"','"+lastname+"','"+username+"','"+password+"');";

        try {
            Statement registrationupdate = connectDB.createStatement();
            int count = registrationupdate.executeUpdate(registeruser);
            System.out.println(count);
            if (count!=0){
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
