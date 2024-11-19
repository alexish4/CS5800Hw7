import MementoandMediator.ChatHistory;
import MementoandMediator.ChatServer;
import MementoandMediator.MessageMemento;
import MementoandMediator.User;

import java.util.Arrays;
import java.util.Iterator;


public class MessageAndMediatorDriver {
    public static void main(String[] args) {
        messageAndMediatorDriver();
    }

    public static void messageAndMediatorDriver() {
        ChatServer server = ChatServer.getInstance();

        ChatHistory chatHistory1 = new ChatHistory();
        ChatHistory chatHistory2 = new ChatHistory();

        User carlos = new User("Carlos", chatHistory1);
        User frank = new User("Frank", chatHistory1);
        User jimmy = new User("Jimmy", chatHistory1);

        User bob = new User("Bob", chatHistory2);
        User alice = new User("Alice", chatHistory2);

        carlos.sendMessage("Do you want to eat pizza today?", Arrays.asList("Frank", "Jimmy"));
        frank.sendMessage("Yeah!", Arrays.asList("Carlos", "Jimmy"));
        chatHistory1.viewHistory();
        frank.undoLastMessage();
        frank.sendMessage("Actually I am on a diet", Arrays.asList("Carlos", "Jimmy"));
        chatHistory1.viewHistory();
        jimmy.sendMessage("Who cares about diets?", Arrays.asList("Frank", "Carlos"));
        chatHistory1.viewHistory();

        alice.blockUser("Bob");
        bob.sendMessage("Do you want to be malicious hackers?", Arrays.asList("Alice"));

        Iterator iterator = carlos.iterator(frank);
        while (iterator.hasNext()) {
            MessageMemento message = (MessageMemento) iterator.next();
            if(message != null) {
                System.out.println(message.toString());
            }
        }

    }
}
