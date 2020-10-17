
import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
    private String sendername;
    private String receiverName;
    private String content;
    private int status;

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return sendername + "\n" + receiverName  + "\n" + content + "\n" + status;
    }
}
