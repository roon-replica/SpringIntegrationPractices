package roon.practice.helloworld.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;

import java.util.Map;

@SpringBootTest
class FileWriteMessageConfigTest {
    @Autowired
    private MessageChannel fileWriteInputChannel;

    @Test
    public void test() {
        Message<String> message = new GenericMessage<>("sample message", Map.of("file_name", "sample_file_name"));

        fileWriteInputChannel.send(message);
    }
}