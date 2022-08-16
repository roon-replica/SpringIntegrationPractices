package roon.practice.springintegrationkata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class FileWriterIntegrationConfig {
    @Bean
    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")   // inputChannel의 메세지를 받아서 outputChannel로 쓰는 통합 플로우 변환기..
    public GenericTransformer<String, String> uppercaseTransformer(){
        return String::toUpperCase;
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")   // inputChannel로부터 메세지를 받고... MessageHandler 인터페이스를 구현한 클래스에 전달한다고 함. (messageHandler를 통해 서비스를 호출)
    public FileWritingMessageHandler fileWriter(){
        var file = new File("target-dir");

        var handler = new FileWritingMessageHandler(file);
        handler.setExpectReply(false); // 응답 채널?을 사용하지 않음을 의미한다고 함..

        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }

    @Bean
    public MessageChannel textInChannel(){
        return new DirectChannel();
    }

    @Bean
    public MessageChannel fileWriterChannel(){
        return new DirectChannel();
    }
}
