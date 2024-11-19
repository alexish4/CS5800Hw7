package MementoandMediator;

import java.util.Iterator;
import java.util.List;

public class User implements IterableByUser {
    private String name;
    private ChatServer mediator = ChatServer.getInstance();
    private ChatHistory chatHistory;

    public User(String name, ChatHistory chatHistory) {
        this.name = name;
        this.chatHistory = chatHistory;
        mediator.registerUser(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ChatHistory chatHistory) {
        this.chatHistory = chatHistory;
    }

    public void sendMessage(String message, List<String> recipients) {
        String timeStamp = String.valueOf(System.currentTimeMillis());
        Message messageToSend = new Message(name, recipients, message, timeStamp);
        chatHistory.add(new MessageMemento(message, timeStamp, recipients));

        mediator.sendMessage(messageToSend);
    }

    public void receiveMessage(Message message) {
        System.out.println(name + "'s Phone Notification:");
        System.out.println("From: " + message.getSender());
        System.out.println("Message: " + message.getMessageContent());
    }

    public void undoLastMessage() {
        chatHistory.undo();
    }

    public void blockUser(String blockee) {
        mediator.blockUser(name, blockee);
    }


    @Override
    public Iterator iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }
}
