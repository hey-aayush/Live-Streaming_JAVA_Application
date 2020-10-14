package LiveStreamApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User  {
    protected String username;
    protected String firstname;
    protected String lastname;

    //Value of x,y relative to Scene required to drag window
    private double xOffset = 0;
    private double yOffset = 0;

    public String getUserName(){
        return this.username;
    }
    public String getFirstName(){
        return this.firstname;
    }
    public String getLastName(){
        return this.lastname;
    }

    public String setUserName(String username){
        return this.username;
    }
    public String setFirstName(){
        return this.firstname;
    }
    public String setLastName(){
        return this.lastname;
    }

    //private static User user ;

    User(String username){

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String verifyLogin = "select firstname,lastname from LiveStream_user_account where username = '"+username+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            queryResult.next();
            this.firstname=queryResult.getString(1);
            this.lastname=queryResult.getString(2);
            this.username=username;
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    User(String username,String firstname,String lastname){
        this.username=username;
        this.lastname=lastname;
        this.username=username;
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

    public static void main(String[] args) {
        System.out.println("User Created 1");
        //launch(args);
        System.out.println("User Created 2");
    }

}
