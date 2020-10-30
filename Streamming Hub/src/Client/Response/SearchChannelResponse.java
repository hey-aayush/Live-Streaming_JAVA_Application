package Client.Response;

import Application.OtherChannels;
import Client.Query.SearchChannelQuery;
import Server.ClientHandler;
import Server.Database.DatabaseConnection;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchChannelResponse implements Serializable {
    private static final long SerialVersionUID = 4L;


    private static SearchChannelQuery searchChannelQuery;
    private List<OtherChannels> searchChannelList= new ArrayList<>();

    public void setSearchChannelList(List<OtherChannels> searchChannelList) {
        this.searchChannelList = searchChannelList;
    }

    public List<OtherChannels> getsearchChannelList(){
        return this.searchChannelList;
    }

    public void setSearchChannelQuery(SearchChannelQuery searchChannelQuery){
        this.searchChannelQuery = searchChannelQuery;
    }

    public static List<OtherChannels> getOtherChannelList(ResultSet resultSet){
        try{
            List<OtherChannels> otherChannelsList = new ArrayList<>();
            OtherChannels otherChannel;
            while (resultSet.next()){
                otherChannel = new OtherChannels(resultSet.getInt("ChannelId"),resultSet.getString("ChannelName"),resultSet.getInt("NoofSubcribers"));
                otherChannelsList.add(otherChannel);
            }

            return otherChannelsList;
        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

    public static List<OtherChannels> getSearchChannelList() {

        String searchedChannel = searchChannelQuery.getQueryChannel();

        DatabaseConnection connection  = DatabaseConnection.getInstance();
        Connection connectDB = connection.getConnection();

        String searchQuery = "select * from channel_table where ChannelName like ?;";

        try {
            PreparedStatement statement = connectDB.prepareStatement(searchQuery);
            statement.setString(1,"%"+searchedChannel+"%");
            ResultSet queryResult = statement.executeQuery();
            List<OtherChannels> otherChannelList = getOtherChannelList(queryResult);
            return otherChannelList;

        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

    public void setResponse(SearchChannelQuery searchChannelQuery){
        setSearchChannelQuery(searchChannelQuery);
        setSearchChannelList(getSearchChannelList());
        try{
            for (OtherChannels otherChannel : searchChannelList){
                System.out.println(otherChannel.getChannelName());
            }
            ClientHandler.o.writeObject(this);

            System.out.println("Response Sent");
        }catch (Exception exception){
            exception.printStackTrace();
        }

    }

}
