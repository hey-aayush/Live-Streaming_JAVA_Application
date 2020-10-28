package Client.Query;


import java.io.IOException;
import java.io.Serializable;

public class SearchChannelQuery implements Serializable {

    private String queryChannel;

    private static SearchChannelQuery searchChannelQuery=null;

    private void setQueryChannel(String channel){
        this.queryChannel=channel;
    }

    public String getQueryChannel(){
        return this.queryChannel;
    }

    public SearchChannelQuery(String searchedChannel) {
        this.setQueryChannel(searchedChannel);
    }
}
