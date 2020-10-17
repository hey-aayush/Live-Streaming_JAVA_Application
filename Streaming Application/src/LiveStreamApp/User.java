package LiveStreamApp;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User  {
    protected int user_id;
    protected String username;
    protected String firstname;
    protected String lastname;
    protected ObservableList<OtherUsers> contactlist;
    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    public int getUser_id(){return this.user_id;}
    public String getUserName(){
        return this.username;
    }
    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }

    private void setUser_id(int id){this.user_id=id;}
    public void setUserName(String username){this.username =username;}
    public void setFirstName(String firstname){
        this.firstname=firstname;
    }
    public void setLastName(String lastname){
        this.lastname=lastname;
    }

    //private static User user ;

    User(String username){

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "select user_id,firstname,lastname from users_account_details where username = '"+username+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            queryResult.next();
            this.user_id=queryResult.getInt("user_id");
            this.firstname=queryResult.getString("firstname");
            this.lastname=queryResult.getString("lastname");
            this.username=username;
            this.contactlist=fetchContact();
            //System.out.println(this.user_id);
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    User(String username,String firstname,String lastname){
        this.username=username;
        this.lastname=lastname;
        this.username=username;
    }

    public ObservableList<OtherUsers> fetchContact(){

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String searchQuery = "select users_account_details.username,users_account_details.user_id,users_account_details.firstname,users_account_details.lastname from users_account_details join follow_request_table where (follow_request_table.sender_user_id = users_account_details.user_id  and follow_request_table.reciever_user_id =?) or (follow_request_table.reciever_user_id = users_account_details.user_id  and follow_request_table.sender_user_id =?);";
        // Limit to length of search result---
        try {
            PreparedStatement statement = connectDB.prepareStatement(searchQuery);
            statement.setInt(1,this.getUser_id());
            statement.setInt(2,this.getUser_id());
            ResultSet queryResult = statement.executeQuery();
            ObservableList<OtherUsers> otherUsersList = UserDao.getContactUserObjects(queryResult);
            return otherUsersList;

        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

//    public static User getInstance(String username){
//        if (user==null){
//            user = new User(username);
//            return user;
//        }
//        return user;
//    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//
//            Stage ProfileStage = new Stage();
//            ProfileStage.initStyle(StageStyle.TRANSPARENT);
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
//            Parent ProfileWindow = (Parent) loader.load();
//            Image appIcon = new Image("res/icon.png");
//            ProfileStage.getIcons().add(appIcon);
//            ProfileStage.setTitle("Live Stream");
//            Scene profilescene = new Scene(ProfileWindow, 676, 611);
//            profilescene.setFill(Color.TRANSPARENT);
//            ProfileStage.setTitle("HomePage");
//
//            ProfileWindow.setOnMousePressed(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    xOffset = event.getSceneX();
//                    yOffset = event.getSceneY();
//                }
//            });
//            ProfileWindow.setOnMouseDragged(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    ProfileStage.setX(event.getScreenX() - xOffset);
//                    ProfileStage.setY(event.getScreenY() - yOffset);
//                }
//            });
//            ProfileStage.setScene(profilescene);
//            ProfileStage.show();
//
//    }

//    public static void main(String[] args) {
//        System.out.println("User Created 1");
//        //launch(args);
//        System.out.println("User Created 2");
//    }

}
