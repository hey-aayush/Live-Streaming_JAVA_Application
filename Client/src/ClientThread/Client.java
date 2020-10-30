package ClientThread;

import Application.OtherChannels;
import ControllerFiles.BaseStageController;
import ControllerFiles.LoginController;
import Query.LoginData;
import Query.Message;
import Query.RegisterData;
import Response.*;
import javafx.application.Platform;
import Main.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Client implements Runnable{

    static Socket socketClient;

    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;

    private static Client singleClient;

    private Client(){

    }
    //For making Client class as a Singleton class
    public static Client getInstance(){
        if(singleClient == null)
            singleClient = new Client();
        return singleClient;
    }


    public void createSocket() {
        try {

            //Creaing client
            socketClient = new Socket("localhost", 5781);
            System.out.println(socketClient+ "----");
            objectOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            objectInputStream = new ObjectInputStream(socketClient.getInputStream());
            //Sending firstMessage to server
            Message firstMessage = new Message();
            System.out.println(LoginController.getInstance().myUserName);
            firstMessage.setSendername(LoginController.myUserName);
            firstMessage.setContent("first message");
            objectOutputStream.writeObject(firstMessage);
            Thread t= new Thread(new Client());
            t.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        System.out.println("===== " + socketClient);
        while (socketClient != null && socketClient.isConnected()){
            try{
                Object ref = objectInputStream.readObject();
                System.out.println("Received");

                if(ref instanceof TFReply){
                    LoginController lc = new LoginController();
                    TFReply tfReply = (TFReply)ref;
                    if(tfReply.getObj() instanceof RegisterData){
                        System.out.println(lc.getController());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lc.getController().appendReply(tfReply);
                            }
                        });
                    }
                    else
                    if(tfReply.getObj() instanceof LoginData){
                        Main main = new Main();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Main.controller.appendReply(tfReply);
                            }
                        });
                    }

                }
                else
                if(ref instanceof SearchReply){
                    System.out.println("SearchReply aa gaya");
                    SearchReply searchReply = (SearchReply)ref;
                    BaseStageController bs = new BaseStageController();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            bs.getSearchPageController().appendReply(searchReply);
                        }
                    });
                }
                else
                if(ref instanceof MsgReply){
                    MsgReply msgReply = (MsgReply)ref;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            BaseStageController.chatPageController.appendConversationReply(msgReply);
                            //BaseStageController.chatPageController.appendConversationReply(msgReply);
                        }
                    });
                }
                else
                if(ref instanceof NewMsgReply){
                    NewMsgReply newMsgReply = (NewMsgReply)ref;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            BaseStageController.chatPageController.appendNewMsgs(newMsgReply);
                        }
                    });
                }
                else
                if(ref instanceof Message){
                    Message message = (Message)ref;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                BaseStageController.chatPageController.appendMessage(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else if(ref instanceof SearchFriendReply){
                    SearchFriendReply sfr = (SearchFriendReply)ref;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            BaseStageController.chatPageController.appendFriendList(sfr);
                        }
                    });

                }else if(ref instanceof ProfileReply) {
                    ProfileReply sfr = (ProfileReply) ref;
                    LoginController lc = new LoginController();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Main.controller.appendUser((sfr.getUser()));
                        }
                    });
                }else if(ref instanceof SearchChannelResponse){
                    SearchChannelResponse searchChannelResponse = (SearchChannelResponse) ref;
                    List<OtherChannels> searchedChannelList = searchChannelResponse.getsearchChannelList();

                    for(OtherChannels otherChannel : searchedChannelList){
                        System.out.println("Added :"+otherChannel.getChannelName());
                        BaseStageController.channelSectionController.SearchOtherChannelList.add(otherChannel);
                        BaseStageController.channelSectionController.SearchChannelList.add(otherChannel.getChannelName());
                    }
                    BaseStageController.channelSectionController.updateList();

                }
                // Allocating streaming address
                             /*
                             else if(ref instanceof StreamingAddress){
                                 StreamingAddress streamingAddress = (StreamingAddress)ref;
                                 System.out.println("In client class: " + streamingAddress.getAddress() + ", " + streamingAddress.getPort());
                                 Platform.runLater(new Runnable() {
                                     @Override
                                     public void run() {
                                         if(streamingAddress.getAddressUse()== StreamingConstants.FOR_STREAMING) {
                                             BaseStageController.streammerSectionController.setStreamingAddress(streamingAddress);
                                         }
                                     }
                                 });
                             }else if(ref instanceof SearchChannelResponse){
                                 SearchChannelResponse searchChannelResponse = (SearchChannelResponse) ref;
                                 List<OtherChannels> searchedChannelList = searchChannelResponse.getsearchChannelList();
                                 for(OtherChannels otherChannel : searchedChannelList){
                                     System.out.println("Added :"+otherChannel.getChannelName());
                                     BaseStageController.channelSectionController.SearchOtherChannelList.add(otherChannel);
                                     BaseStageController.channelSectionController.SearchChannelList.add(otherChannel.getChannelName());
                                 }
                                 BaseStageController.channelSectionController.updateList();
                             }*/

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}