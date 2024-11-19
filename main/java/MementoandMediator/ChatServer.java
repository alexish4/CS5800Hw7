package MementoandMediator;

import java.util.*;

public class ChatServer {
    private static ChatServer instance;

    private Map<String, User> users = new HashMap<>();
    private Map<String, Set<String>> blockList = new HashMap<>();

    private ChatServer() {}

    public static ChatServer getInstance() {
        if (instance == null) {
            instance = new ChatServer();
        }

        return instance;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Set<String>> getBlockList() {
        return blockList;
    }

    public void registerUser(User user) {
        users.put(user.getName(), user);
        blockList.put(user.getName(), new HashSet<>());
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
        blockList.remove(user.getName());
    }

    public void sendMessage(Message message) {
        for (String recipient : message.getRecipients()) {
            if (users.containsKey(recipient) && !blockList.get(recipient).contains(message.getSender())) {
                users.get(recipient).receiveMessage(message);
            }
            if (blockList.get(recipient).contains(message.getSender())) {
                System.out.println("Message from " + message.getSender() + " was blocked.\n");
            }
        }
    }

    public void blockUser(String blocker, String blockee) {
        if (blockList.containsKey(blocker)) {
            blockList.get(blocker).add(blockee);
        }
    }
}
