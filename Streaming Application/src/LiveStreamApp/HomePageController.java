package LiveStreamApp;

import javafx.beans.property.Property;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HomePageController {

    static User homeUser;

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
    @FXML
    private TableColumn<OtherUsers, Button> actioncol;

    public void setUser(User user){
        homeUser = user;
        searchBar.setText(homeUser.username);
    }

    public ObservableList<OtherUsers> searchUsers(){
        String search = searchBar.getText();

        DatabaseConnection connection = new DatabaseConnection();
        Connection connectDB = connection.getConnection();

        String searchQuery = "select * from users_account_details where username like ? && username not in (?);";
        // Limit to length of search result---
        try {
            PreparedStatement statement = connectDB.prepareStatement(searchQuery);
            statement.setString(1,"%"+search+"%");
            statement.setString(2,homeUser.username);
            ResultSet queryResult = statement.executeQuery();
            ObservableList<OtherUsers> otherUsersList = UserDao.getOtherUserObjects(queryResult,homeUser.contactlist);
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
        actioncol.setCellValueFactory(new PropertyValueFactory<OtherUsers,Button>("button"));
    }

    private void populateTable(ObservableList<OtherUsers> otherUsersObservableList){
        searchTable.setItems(otherUsersObservableList);
    }

    public void searchBtnAction(MouseEvent event) throws Exception{
        ObservableList<OtherUsers> otherUsersList= searchUsers();
        populateTable(otherUsersList);
    }

}
