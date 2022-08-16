//package roon.practice.springintegrationkata;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.dsl.MessageChannels;
//import org.springframework.integration.file.dsl.Files;
//import org.springframework.integration.file.support.FileExistsMode;
//import org.springframework.messaging.MessageChannel;
//
//import java.io.File;
//
//@Configuration
//public class FileWriterIntegrationConfig_DSL {
//    @Bean
//    public IntegrationFlow fileWriterFlow() {
//        return IntegrationFlows
//                .from(MessageChannels.direct("textInChannel"))
//                .<String, String>transform(String::toUpperCase)
//                .handle(
//                        Files.outboundAdapter(new File("/target-dir"))
//                                .fileExistsMode(FileExistsMode.APPEND)
//                                .appendNewLine(true)
//                )
//                .get();
//    }
//
//    @Bean
//    public MessageChannel textInChannel() {
//        return new DirectChannel();
//    }
//
//    @Bean
//    public MessageChannel fileWriterChannel() {
//        return new DirectChannel();
//    }
//}
