package MementoandMediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User userAlice;
    private User userBob;
    private User userCharlie;
    private ChatHistory chatHistory;

    @BeforeEach
    void setUp() {
        chatHistory = new ChatHistory();
        userAlice = new User("Alice", chatHistory);
        userBob = new User("Bob", chatHistory);
        userCharlie = new User("Charlie", chatHistory);
    }

    @Test
    void setName() {
        userAlice.setName("Bob");
        assertEquals("Bob", userAlice.getName());
    }

    @Test
    void setChatHistory() {
        ChatHistory newChatHistory = new ChatHistory();
        userAlice.setChatHistory(newChatHistory);
        assertEquals(newChatHistory, userAlice.getChatHistory());
    }

    @Test
    void sendMessage() {
        List<String> recipients = Arrays.asList("Bob", "Charlie");
        userAlice.sendMessage("Hello, everyone!", recipients);

        String lastMessage = chatHistory.getHistory().get(chatHistory.getHistory().size() - 1).toString();
        assertNotNull(lastMessage);
    }

    @Test
    void receiveMessage() {
        Message message = new Message("Bob", Arrays.asList("Alice"), "Hi, Alice!", "1:00");

        userAlice.receiveMessage(message);
        assertEquals("Hi, Alice!", message.getMessageContent());
    }

    @Test
    void undoLastMessage() {
        List<String> recipients = Arrays.asList("Bob", "Charlie");
        userAlice.sendMessage("First message", recipients);
        userAlice.sendMessage("Second message", recipients);

        chatHistory.viewHistory();
    }

    @Test
    void blockUser() {
        userAlice.blockUser("Bob");

        ChatServer mediator = ChatServer.getInstance();
        assertTrue(mediator.getBlockList().get("Alice").contains("Bob"));
    }

}