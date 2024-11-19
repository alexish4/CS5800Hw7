package MementoandMediator;

import java.util.ArrayList;
import java.util.List;

public class MessageMemento {
    private String messageContent;
    String timeStamp;
    List<String> receivers;

    public MessageMemento(String messageContent, String timeStamp, List<String> receivers) {
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
        this.receivers = receivers;
    }

    public List<String> getReceivers() {
        return receivers;
    }

    public String toString() {
        return "Message : " + messageContent + "\nTimeStamp : " + timeStamp;
    }
}
