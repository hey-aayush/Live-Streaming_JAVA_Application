package Client.ControllerFiles;

import Server.Database.DatabaseConnection;
import User.User;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import User.*;


public class HomePageController {

    public static User homeUser;

    @FXML
    private TextField searchBar;

    @FXML
    private ImageView search_btn;

    @FXML
    private TableView<OtherUsers> searchTable;

    @FXML
    private TableColumn<OtherUsers,String> firstNameCol;
    @FXML
    private TableColumn<OtherUsers,String> lastNameCol;
    @FXML
    private TableColumn<OtherUsers,String> userNameCol;

    public void setUser(User user){
        homeUser = user;
        searchBar.setText(homeUser.getUserName());
    }

    public ObservableList<OtherUsers> searchUsers(){
        String search = searchBar.getText();

        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String searchQuery = "select * from user where username like ?;";
        // Limit to length of search result---
        try {
            PreparedStatement statement = connectDB.prepareStatement(searchQuery);
            statement.setString(1,"%"+search+"%");
            //statement.setString(2,homeUser.getUserName());
            ResultSet queryResult = statement.executeQuery();
            ObservableList<OtherUsers> otherUsersList = UserDao.getOtherUserObjects(queryResult, homeUser);
            return otherUsersList;

        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

    @FXML
    private void initialize() throws Exception{
        firstNameCol.setCellValueFactory(cellData->cellData.getValue().getfirstnameProperty());
        lastNameCol.setCellValueFactory(cellData->cellData.getValue().getlastnameProperty());
        userNameCol.setCellValueFactory(cellData->cellData.getValue().getusernameProperty());
    }

    private void populateTable(ObservableList<OtherUsers> otherUsersObservableList){
        searchTable.setItems(otherUsersObservableList);
    }

    public void searchBtnAction(MouseEvent event) throws Exception{
        ObservableList<OtherUsers> otherUsersList= searchUsers();
        populateTable(otherUsersList);
    }

}
