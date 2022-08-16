# 참고 자료
- [spring integration example github](https://github.com/SimpleProgramming/spring-integration-example)
- [spring integration docs](https://docs.spring.io/spring-integration/reference/html/index.html)


# 주요 개념
- Message Endpoint
  - pipes-and-filters 아키텍처에서 필터 역할? 
  - 애플리케이션 코드를 메세지 프레임워크에 non-invasive하게 연결하는 역할. 
  
    mvc 패러다임에서 컨트롤러가 요청을 처리하는 것처럼 messageEndpoint는 message 처리함. 

    컨트롤러가 url을 매핑하듯이 messageEndpoint는 채널을 매핑함

- message filter

  메세지가 output 채널로 전달될지 말지 결정

- message router 

  어떤 채널이 메세지를 받아야 하는지를 결정. 

  message의 내용 또는 header를 보고 결정
  

