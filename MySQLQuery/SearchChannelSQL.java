package MySQLQuery;

import Application.OtherChannels;
import Database.DatabaseConnection;
import Query.SearchChannelQuery;
import ClientHandler.ClientHandler;

import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchChannelSQL implements Serializable {
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
                otherChannel = new OtherChannels(resultSet.getInt("ChannelId"),resultSet.getString("channelName"),resultSet.getInt("NoofSubcribers"));
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

        String searchQuery = "select * from Channel_table where ChannelName like ?;";

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

    public List<OtherChannels> setResponse(SearchChannelQuery searchChannelQuery){
        setSearchChannelQuery(searchChannelQuery);
        setSearchChannelList(getSearchChannelList());
        try{
            for (OtherChannels otherChannel : searchChannelList){
                System.out.println(otherChannel.getChannelName());
            }

            System.out.println("Response Sent");
            return searchChannelList;


        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

}
