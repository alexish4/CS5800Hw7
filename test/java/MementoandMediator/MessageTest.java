package MementoandMediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageTest {
    private Message message;

    @BeforeEach
    void setUp() {
        List<String> recipients = Arrays.asList("Frank", "Jimmy");
        message = new Message("Carlos", recipients, "Hello, team!", "5:00");
    }

    @Test
    void setSender() {
        message.setSender("Alice");
        assertEquals("Alice", message.getSender());
    }

    @Test
    void setRecipients() {
        List<String> newRecipients = Arrays.asList("Bob", "Charlie");
        message.setRecipients(newRecipients);
        assertEquals(newRecipients, message.getRecipients());
    }

    @Test
    void setMessageContent() {
        String newContent = "Good morning!";
        message.setMessageContent(newContent);
        assertEquals(newContent, message.getMessageContent());
    }

    @Test
    void setTimeStamp() {
        String newTimeStamp = "4:00";
        message.setTimeStamp(newTimeStamp);
        assertEquals(newTimeStamp, message.getTimeStamp());
    }
}