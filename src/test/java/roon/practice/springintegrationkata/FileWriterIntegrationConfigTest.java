package roon.practice.springintegrationkata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FileWriterIntegrationConfigTest {
    @Autowired
    private MessageChannel fileWriterChannel;

    @Test
    public void test() {
        Message<String> msg = new GenericMessage<>("message", Map.of("file_name","file name from header"));

        fileWriterChannel.send(msg);
    }
}