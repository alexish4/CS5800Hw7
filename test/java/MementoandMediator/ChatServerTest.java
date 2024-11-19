package MementoandMediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest {
    private ChatServer chatServer;
    private User userCarlos;
    private User userFrank;
    private User userJimmy;

    @BeforeEach
    void setUp() {
        chatServer = ChatServer.getInstance();

        ChatHistory chatHistory = new ChatHistory();
        userCarlos = new User("Carlos", chatHistory);
        userFrank = new User("Frank", chatHistory);
        userJimmy = new User("Jimmy", chatHistory);

        chatServer.registerUser(userCarlos);
        chatServer.registerUser(userFrank);
        chatServer.registerUser(userJimmy);
    }

    @Test
    void registerUser() {
        User newUser = new User("Alice", new ChatHistory());
        chatServer.registerUser(newUser);

        assertTrue(chatServer.getUsers().containsKey("Alice"));
        assertTrue(chatServer.getBlockList().containsKey("Alice"));
    }

    @Test
    void unregisterUser() {
        chatServer.unregisterUser(userFrank);

        assertFalse(chatServer.getUsers().containsKey("Frank"));
        assertFalse(chatServer.getBlockList().containsKey("Frank"));
    }

    @Test
    void sendMessage() {
        userCarlos.sendMessage("Hello, how are you?", Arrays.asList("Frank", "Jimmy"));

        assertEquals(1, userFrank.getChatHistory().getHistory().size());
        assertEquals(1, userJimmy.getChatHistory().getHistory().size());
    }

    @Test
    void blockUser() {
        chatServer.blockUser("Jimmy", "Carlos");

        String messageContent = "Are you coming to the game?";
        Message message = new Message("Carlos", List.of("Jimmy"), messageContent, "9:50");

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        chatServer.sendMessage(message);

        assertTrue(chatServer.getBlockList().get("Jimmy").contains("Carlos"));

        assertEquals(0, userJimmy.getChatHistory().getHistory().size());

        String expectedOutput = "Message from Carlos was blocked.\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}