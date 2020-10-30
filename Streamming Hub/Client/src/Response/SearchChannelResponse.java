package Response;

import Application.OtherChannels;
import java.util.ArrayList;
import java.util.List;

import java.io.Serializable;

public class SearchChannelResponse implements Serializable {

    private List<OtherChannels> searchChannelList= new ArrayList<>();

    public void setSearchChannelList(List<OtherChannels> searchChannelList) {
        this.searchChannelList = searchChannelList;
    }

    public List<OtherChannels> getsearchChannelList(){
        return this.searchChannelList;
    }


}
