package MementoandMediator;

public class MessageMemento {
    private String messageContent;
    String timeStamp;

    public MessageMemento(String messageContent, String timeStamp) {
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
    }

    public String toString() {
        return "Message : " + messageContent + "\nTimeStamp : " + timeStamp;
    }
}
