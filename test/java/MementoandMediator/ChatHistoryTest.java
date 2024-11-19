package MementoandMediator;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ChatHistoryTest {
    private ChatHistory chatHistory;
    private MessageMemento message1;
    private MessageMemento message2;
    private MessageMemento message3;
    private User userCarlos;
    private User userFrank;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        chatHistory = new ChatHistory();
        userCarlos = new User("Carlos", chatHistory);
        userFrank = new User("Frank", chatHistory);

        message1 = new MessageMemento("Hello Frank!", "12:05", Arrays.asList("Frank"));
        message2 = new MessageMemento("How are you?", "1:00", Arrays.asList("Frank", "Jimmy"));
        message3 = new MessageMemento("Goodbye Frank!", "2:20", Arrays.asList("Frank"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        chatHistory.add(message1);
        assertEquals(1, chatHistory.getHistory().size());
        assertEquals(message1, chatHistory.getHistory().get(0));

        chatHistory.add(message2);
        assertEquals(2, chatHistory.getHistory().size());
        assertEquals(message2, chatHistory.getHistory().get(1));
    }

    @org.junit.jupiter.api.Test
    void undo() {
        chatHistory.add(message1);
        chatHistory.add(message2);

        chatHistory.undo();
        assertEquals(1, chatHistory.getHistory().size());
        assertEquals(message1, chatHistory.getHistory().get(0));

        chatHistory.undo();
        assertTrue(chatHistory.getHistory().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void viewHistory() {
        chatHistory.add(message1);
        chatHistory.add(message2);
        chatHistory.add(message3);

        // Capture the output using a custom OutputStream
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        chatHistory.viewHistory();

        String expectedOutput = """
                \nChat history:
                Message : Hello Frank!
                TimeStamp : 12:05
                Message : How are you?
                TimeStamp : 1:00
                Message : Goodbye Frank!
                TimeStamp : 2:20
                End of chat history
                \n""";
        assertEquals(expectedOutput, outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        chatHistory.add(message1);
        chatHistory.add(message2);
        chatHistory.add(message3);

        Iterator<MessageMemento> iterator = chatHistory.iterator(userFrank);

        assertTrue(iterator.hasNext());
        assertEquals(message1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(message2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(message3, iterator.next());

        assertFalse(iterator.hasNext());
    }
}