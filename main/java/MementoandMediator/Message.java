package MementoandMediator;

import java.util.List;

public class Message {
    private String senderName;
    private List<String> recipients;
    private String messageContent;
    private String timeStamp;

    public Message(String senderName, List<String> recipients, String messageContent, String timeStamp) {
        this.senderName = senderName;
        this.recipients = recipients;
        this.messageContent = messageContent;
        this.timeStamp = timeStamp;
    }

    public String getSender() {
        return senderName;
    }

    public void setSender(String senderName) {
        this.senderName = senderName;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
