package roon.practice.springintegrationkata;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/*
애플리케이션에서 통합 플로우로 데이터를 전송하는 게이트웨이를 생성하는거라고 함..
@MessagingGateway를 붙이면 spring integration에게 런타임에 이 인터페이스의 구현체를 생성하라고 알려주는거라고 함.
spring data에서 repository inteface의 구현체를 만들어주는 것과 같은 거라고 함!
 */

@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWriterGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
