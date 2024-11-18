package MementoandMediator;

public class MessageMemento {
    private String messageContent;
    String timeStamp;
    String sender;

    public MessageMemento(String messageContent, String timeStamp, String sender) {
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public String toString() {
        return "Message : " + messageContent + "\nTimeStamp : " + timeStamp;
    }
}
