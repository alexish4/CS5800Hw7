package MementoandMediator;

import java.util.Iterator;
import java.util.List;

public class SearchMessagesByUser implements Iterator<MessageMemento> {
    private List<MessageMemento> messages;
    private User userToSearchWith;
    private int currentIndex;

    public SearchMessagesByUser(List<MessageMemento> messages, User userToSearchWith) {
        this.messages = messages;
        this.userToSearchWith = userToSearchWith;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            MessageMemento messageMemento = messages.get(currentIndex);
            if(messageMemento.getSender().equals(userToSearchWith.getName())) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public MessageMemento next() {
        if(hasNext()) {
            MessageMemento messageMemento = messages.get(currentIndex++);
        }

        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
