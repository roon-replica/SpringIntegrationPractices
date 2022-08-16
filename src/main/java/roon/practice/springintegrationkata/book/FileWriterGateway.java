package roon.practice.springintegrationkata.book;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/*
애플리케이션에서 통합 플로우로 데이터를 전송하는 게이트웨이를 생성하는거라고 함..
@MessagingGateway를 붙이면 spring integration에게 런타임에 이 인터페이스의 구현체를 생성하라고 알려주는거라고 함.
spring data에서 repository inteface의 구현체를 만들어주는 것과 같은 거라고 함!

defaultRequestChannel: 해당 인터페이스의 메서드 호출(누가 호출하지?)로 생성된 메시지가 지정한 메시지 채널로 전송된다고 함..

애플리케이션을 메세지 채널과 이어주는 역할이라 생각하면 될듯!
 */

@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWriterGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
