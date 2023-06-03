package roon.practice.helloworld.book.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class FileWriteMessageConfig {
    // inputChannel의 메세지를 받아서 outputChannel로 변환해줌
    @Bean
    @Transformer(inputChannel = "fileWriteInputChannel", outputChannel = "fileWriteOutputChannel")
    public GenericTransformer<String, String> uppercaseTransformer() {
        return String::toUpperCase;
    }

    // inputChannel로부터 메세지를 받고... MessageHandler 인터페이스를 구현한 클래스에 전달한다고 함. (messageHandler를 통해 서비스를 호출)
    @Bean
    @ServiceActivator(inputChannel = "fileWriteOutputChannel")
    public FileWritingMessageHandler fileWriter() {
        var file = new File("target-dir");

        var handler = new FileWritingMessageHandler(file); // 메시지를 파일에 쓰는 용도. 라이브러리에서 제공하는 구현체

        handler.setExpectReply(false); // output 채널은 지금 안쓰고 있으니까
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }

    @Bean
    public MessageChannel fileWriteInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriteOutputChannel() {
        return new DirectChannel();
    }
}
