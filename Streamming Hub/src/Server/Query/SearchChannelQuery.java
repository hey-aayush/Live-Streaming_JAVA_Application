package Server.Query;


import Server.EnumConstants.QueryCode;

import java.io.Serializable;

public class SearchChannelQuery extends Query implements Serializable {
    private static final long SerialVersionUID = 1007L;

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

    @Override
    public QueryCode getQueryCode() {
        return QueryCode.SEARCH_CHANNEL_QUERY;
    }
}
