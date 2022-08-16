//package roon.practice.springintegrationkata;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.annotation.Transformer;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.file.FileWritingMessageHandler;
//import org.springframework.integration.file.support.FileExistsMode;
//import org.springframework.integration.transformer.GenericTransformer;
//import org.springframework.messaging.MessageChannel;
//
//import java.io.File;
//
//@Configuration
//public class FileWriterIntegrationConfig {
//    @Bean
//    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")   // inputChannel의 메세지를 받아서 outputChannel로 쓰는 통합 플로우 변환기..
//    public GenericTransformer<String, String> uppercaseTransformer(){
//        return String::toUpperCase;
//    }
//
//    @Bean
//    @ServiceActivator(inputChannel = "fileWriterChannel")   // inputChannel로부터 메세지를 받고... FileWritingMessageHandler의 인스턴스로 정의된 서비스?에 넘겨준다고 함....
//    public FileWritingMessageHandler fileWriter(){
//        var handler = new FileWritingMessageHandler(new File("target-dir"));
//        handler.setExpectReply(false); // 응답 채널?을 사용하지 않음을 의미한다고 함..
//
//        handler.setFileExistsMode(FileExistsMode.APPEND);
//        handler.setAppendNewLine(true);
//
//        return handler;
//    }
//
//    @Bean
//    public MessageChannel textInChannel(){
//        return new DirectChannel();
//    }
//
//    @Bean
//    public MessageChannel fileWriterChannel(){
//        return new DirectChannel();
//    }
//}
