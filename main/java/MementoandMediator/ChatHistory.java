package MementoandMediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser{
    List<MessageMemento> history = new ArrayList<>();

    public void add(MessageMemento message) {
        history.add(message);
    }

    public void getLastMessage() {
        System.out.println(history.get(history.size() - 1).toString());
    }

    public void undo() {
        history.remove(history.size() - 1);
    }

    public void viewHistory() {
        System.out.println("\nChat history:");

        for (MessageMemento m : history) {
            System.out.println(m.toString());
        }
        System.out.println("End of chat history\n");
    }

    @Override
    public Iterator iterator(User userToSearchWith) {
        return null;
    }
}
