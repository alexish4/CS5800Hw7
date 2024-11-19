package MementoandMediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchMessagesByUserTest {
    private List<MessageMemento> messages;
    private User searchUser;
    private SearchMessagesByUser searchMessagesByUser;
    private ChatHistory chatHistory;

    @BeforeEach
    void setUp() {
        messages = Arrays.asList(
                new MessageMemento("Hello, Alice!", "10:00", Arrays.asList("Alice", "Bob")),
                new MessageMemento("Hey, Bob!", "11:00", Arrays.asList("Bob", "Charlie")),
                new MessageMemento("Hi, Charlie!", "12:00", Arrays.asList("Alice", "Charlie"))
        );
        chatHistory = new ChatHistory();

        searchUser = new User("Bob", chatHistory);
        searchMessagesByUser = new SearchMessagesByUser(messages, searchUser);
    }

    @Test
    void hasNext() {
        assertTrue(searchMessagesByUser.hasNext());
        searchMessagesByUser.next();
        assertTrue(searchMessagesByUser.hasNext());
        searchMessagesByUser.next();
        assertFalse(searchMessagesByUser.hasNext());
    }

    @Test
    void next() {
        MessageMemento firstMessage = searchMessagesByUser.next();
        assertNotNull(firstMessage);
        assertEquals("Message : Hello, Alice!\n" +
                "TimeStamp : 10:00", firstMessage.toString());

        MessageMemento secondMessage = searchMessagesByUser.next();
        assertNotNull(secondMessage);
        assertEquals("Message : Hey, Bob!\n" +
                "TimeStamp : 11:00", secondMessage.toString());

        assertNull(searchMessagesByUser.next());
    }

    @Test
    void remove() {
        assertThrows(UnsupportedOperationException.class, () -> searchMessagesByUser.remove());
    }
}