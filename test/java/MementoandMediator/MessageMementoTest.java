package MementoandMediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageMementoTest {
    private MessageMemento messageMemento;

    @BeforeEach
    void setUp() {
        List<String> receivers = Arrays.asList("Frank", "Jimmy");
        messageMemento = new MessageMemento("Hello, team!", "7:00", receivers);
    }

    @Test
    void testToString() {
        String expectedOutput = "Message : Hello, team!\nTimeStamp : 7:00";
        assertEquals(expectedOutput, messageMemento.toString());
    }
}