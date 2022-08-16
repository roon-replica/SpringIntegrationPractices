# 목적
- 좀 친해질 필요가 있다. 자주 쓰니까  
  인테그레이션 메세징 관련 아키텍처도 더 친해질 필요가 있
- DSL 잘 모르겠
- 내부 메세징 기능을 이용해서 재밌는 기능도 만들어보고 싶


# 주요 개념
- message
- message channel
- service activator
- transformer
- Message Endpoint
  - pipes-and-filters 아키텍처에서 필터 역할? 
  - 애플리케이션 코드를 메세지 프레임워크에 non-invasive하게 연결하는 역할  
    mvc 패러다임에서 컨트롤러가 요청을 처리하는 것처럼 messageEndpoint는 message 처리함
    컨트롤러가 url을 매핑하듯이 messageEndpoint는 채널을 매핑함
- message filter
  메세지가 output 채널로 전달될지 말지 결정
- message router
  어떤 채널이 메세지를 받아야 하는지를 결정  
  message의 내용 또는 header를 보고 결정

# 참고 자료
- [spring integration example github](https://github.com/SimpleProgramming/spring-integration-example)
- [spring integration docs](https://docs.spring.io/spring-integration/reference/html/index.html)
- spring in action 챕터 9(스프링 통합하기)

